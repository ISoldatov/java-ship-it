package ru.yandex.practicum.delivery.model;

import static ru.yandex.practicum.delivery.service.DeliveryService.PERISHABLE_DELIVERY_COST;

public class PerishableParcel extends Parcel {
    private final int timeToLive;
    private boolean isExpected;

    public PerishableParcel(String description, int weight, String deliveryAddress, int sendDay, int timeToLive) {
        super(description, weight, deliveryAddress, sendDay);
        this.timeToLive = timeToLive;
        isExpected = false;
    }

    public boolean isExpected() {
        return isExpected;
    }

    public void isExpired(int currentDay) {
        isExpected = (getSendDay() + timeToLive) < currentDay;
    }

    @Override
    protected int getDeliveryCost() {
        return PERISHABLE_DELIVERY_COST;
    }
}
