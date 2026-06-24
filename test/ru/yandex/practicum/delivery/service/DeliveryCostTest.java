package ru.yandex.practicum.delivery.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.yandex.practicum.delivery.model.ParcelType;

public class DeliveryCostTest {

    private static DeliveryService deliveryService;

    @BeforeEach
    public void beforeEach() {
        deliveryService = new DeliveryService();
    }

    @Test
    void calculateCostForStandardParcels() {
        deliveryService.addParcel(ParcelType.STANDARD, 1, "Standard parcel #1",
                "Delivery address #1", 1, 0);
        deliveryService.addParcel(ParcelType.STANDARD, 3, "Standard parcel #2",
                "Delivery address #2", 1, 0);
        int expectedCost = (3 + 1) * 2;
        Assertions.assertEquals(expectedCost, deliveryService.calculateCosts());
    }

    @Test
    void calculateCostForFragileParcels() {
        deliveryService.addParcel(ParcelType.FRAGILE, 4, "Fragile parcel #1",
                "Delivery address #1", 2, 0);
        deliveryService.addParcel(ParcelType.FRAGILE, 5, "Fragile parcel #2",
                "Delivery address #2", 2, 0);
        int expectedCost = (4 + 5) * 4;
        Assertions.assertEquals(expectedCost, deliveryService.calculateCosts());
    }

    @Test
    void calculateCostForPerishableParcels() {
        deliveryService.addParcel(ParcelType.PERISHABLE, 2, "Perishable parcel #1",
                "Delivery address #1", 2, 5);
        deliveryService.addParcel(ParcelType.PERISHABLE, 3, "Perishable parcel #2",
                "Delivery address #2", 2, 10);
        int expectedCost = (2 + 3) * 3;
        Assertions.assertEquals(expectedCost, deliveryService.calculateCosts());
    }

    @Test
    void calculateCostsAllTypeParcels() {
        deliveryService.addParcel(ParcelType.STANDARD, 2, "Standard parcel #1",
                "Delivery address #1", 1, 0);
        deliveryService.addParcel(ParcelType.FRAGILE, 4, "Fragile parcel #2",
                "Delivery address #2", 2, 0);
        deliveryService.addParcel(ParcelType.PERISHABLE, 3, "Perishable parcel #3",
                "Delivery address #3", 2, 10);
        int expectedCost = (2 * 2) + (4 * 4) + (3 * 3);
        Assertions.assertEquals(expectedCost, deliveryService.calculateCosts());
    }
}
