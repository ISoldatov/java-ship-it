package ru.yandex.practicum.delivery;

import static ru.yandex.practicum.delivery.DeliveryApp.STANDARD_DELIVERY_COST;

public class StandardParcel extends Parcel {
    public StandardParcel(String description, int weight, String deliveryAddress, int sendDay) {
        super(description, weight, deliveryAddress, sendDay);
    }

    @Override
    protected int getDeliveryCost() {
        return STANDARD_DELIVERY_COST;
    }
}
