package ru.yandex.practicum.delivery.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

class ParcelBoxTest {

    public static final StandardParcel STANDARD_PARCEL_1 = new StandardParcel(
            "Standard parcel #1", 15, "Delivery address #1", 1);
    public static final StandardParcel STANDARD_PARCEL_2 = new StandardParcel(
            "Standard parcel #2", 10, "Delivery address #2", 2);
    public static final StandardParcel STANDARD_PARCEL_3 = new StandardParcel(
            "Standard parcel #3", 10, "Delivery address #3", 3);
    private static ParcelBox<StandardParcel> parcelBox;

    @BeforeEach
    public void beforeEach() {
        parcelBox = new ParcelBox<>();
    }

    @Test
    void shouldAddParcelInBoxWeightLessDefaultBoxWeight() {
        parcelBox.addParcel(STANDARD_PARCEL_1);
    }

    @Test
    void shouldAddParcelInBoxWeightEqualDefaultBoxWeight() {
        parcelBox.addParcel(STANDARD_PARCEL_1);
        parcelBox.addParcel(STANDARD_PARCEL_2);
    }

    @Test
    void shouldNotAddParcelInBoxWeightGreaterDefaultBoxWeight() {
        parcelBox.addParcel(STANDARD_PARCEL_1);
        parcelBox.addParcel(STANDARD_PARCEL_2);
        parcelBox.addParcel(STANDARD_PARCEL_3);

        int expectParcelInBox = 2;
        Assertions.assertEquals(expectParcelInBox, parcelBox.getAllParcels().size());

        ArrayList<StandardParcel> expectedStandardParcels = new ArrayList<>();
        expectedStandardParcels.add(STANDARD_PARCEL_1);
        expectedStandardParcels.add(STANDARD_PARCEL_2);
        Assertions.assertArrayEquals(expectedStandardParcels.toArray(), parcelBox.getAllParcels().toArray());
    }

    @Test
    void getAllParcels() {
        parcelBox.addParcel(STANDARD_PARCEL_1);
        parcelBox.addParcel(STANDARD_PARCEL_2);

        int expectParcelInBox = 2;
        Assertions.assertEquals(expectParcelInBox, parcelBox.getAllParcels().size());

        ArrayList<StandardParcel> expectedStandardParcels = new ArrayList<>();
        expectedStandardParcels.add(STANDARD_PARCEL_1);
        expectedStandardParcels.add(STANDARD_PARCEL_2);
        Assertions.assertArrayEquals(expectedStandardParcels.toArray(), parcelBox.getAllParcels().toArray());
    }
}