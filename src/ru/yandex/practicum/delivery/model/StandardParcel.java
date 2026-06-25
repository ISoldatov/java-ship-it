package ru.yandex.practicum.delivery.model;

public class StandardParcel extends Parcel {
    public static final int STANDARD_DELIVERY_COST = 2;

    public StandardParcel(String description, int weight, String deliveryAddress, int sendDay) {
        super(description, weight, deliveryAddress, sendDay);
    }

    @Override
    protected int getDeliveryCost() {
        return STANDARD_DELIVERY_COST;
    }
}
