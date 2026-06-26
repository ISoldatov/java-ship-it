package ru.yandex.practicum.delivery.model;

public class PerishableParcel extends Parcel {
    private static final int PERISHABLE_DELIVERY_COST = 3;

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
