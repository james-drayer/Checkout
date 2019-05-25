package com.audition.checkout;

import org.apache.commons.lang3.RandomStringUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.util.ArrayList;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class InventoryTest {

    private ArrayList<InventoryItem> inventoryItems = new ArrayList<>();
    private String itemName = RandomStringUtils.randomAlphanumeric(10);
    private InventoryItem inventoryItem = new InventoryItem(itemName, BigDecimal.ZERO);
    private Inventory inventory;

    @BeforeEach
    void configureInventory(){
        inventoryItems.add(inventoryItem);
        inventory = new Inventory(inventoryItems);
    }
    @Test
    void getInventoryItemFromInventory() {
        InventoryItem foundItem = inventory.getItem(itemName);

        assertThat(foundItem).isEqualTo(inventoryItem);
    }

    @Test
    void throwsExceptionWhenItemNotFoundInInventory() {
        assertThrows(InventoryItemNotFoundException.class, () -> inventory.getItem(""));
    }
}