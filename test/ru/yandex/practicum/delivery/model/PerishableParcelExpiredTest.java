package ru.yandex.practicum.delivery.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class PerishableParcelExpiredTest {
    private static final PerishableParcel PERISHABLE_PARCEL = new PerishableParcel(
            "Perishable parcel #1", 2, "Delivery address #1", 1, 10);

    @Test
    public void shouldExpiredBeFalse() {
        PERISHABLE_PARCEL.isExpired(11);
        Assertions.assertFalse(PERISHABLE_PARCEL.isExpected());
    }

    @Test
    public void shouldExpiredBeTrue() {
        PERISHABLE_PARCEL.isExpired(12);
        Assertions.assertTrue(PERISHABLE_PARCEL.isExpected());
    }
}
