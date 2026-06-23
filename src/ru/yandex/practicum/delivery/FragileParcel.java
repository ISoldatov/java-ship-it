package ru.yandex.practicum.delivery;

import static ru.yandex.practicum.delivery.DeliveryApp.FRAGILE_DELIVERY_COST;

public class FragileParcel extends Parcel implements Trackable {
    public FragileParcel(String description, int weight, String deliveryAddress, int sendDay) {
        super(description, weight, deliveryAddress, sendDay);
    }

    @Override
    public void packageItem() {
        System.out.println("Посылка " + getDescription() + " обёрнута в защитную плёнку.");
        super.packageItem();
    }

    @Override
    public int getDeliveryCost() {
        return FRAGILE_DELIVERY_COST;
    }

    @Override
    public void reportStatus(String newLocation) {
        System.out.println("Хрупкая посылка " + getDescription() + " изменила местоположение на " + newLocation);
    }
}
