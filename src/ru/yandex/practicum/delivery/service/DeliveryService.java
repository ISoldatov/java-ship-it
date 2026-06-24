package ru.yandex.practicum.delivery.service;

import ru.yandex.practicum.delivery.model.*;

import java.util.*;

public class DeliveryService {
    public static final int STANDARD_DELIVERY_COST = 2;
    public static final int PERISHABLE_DELIVERY_COST = 3;
    public static final int FRAGILE_DELIVERY_COST = 4;
    public static final int DEFAULT_BOX_WEIGHT = 25;

    private final List<Parcel> allParcels = new ArrayList<>();
    private final List<Trackable> trackableParcels = new ArrayList<>();

    private final ParcelBox<StandardParcel> standartParselBox = new ParcelBox<>(DEFAULT_BOX_WEIGHT);
    private final ParcelBox<FragileParcel> fragileParcelBox = new ParcelBox<>(DEFAULT_BOX_WEIGHT);
    private final ParcelBox<PerishableParcel> perishableParcelBox = new ParcelBox<>(DEFAULT_BOX_WEIGHT);

    public void addParcel(ParcelType parcelType, int weight, String description, String deliveryAddress, int sendDay,
                          int timeToLive) {
        switch (parcelType) {
            case STANDARD:
                StandardParcel standardParcel = new StandardParcel(description, weight, deliveryAddress, sendDay);
                allParcels.add(standardParcel);
                standartParselBox.addParcel(standardParcel);
                break;
            case FRAGILE:
                FragileParcel fragileParcel = new FragileParcel(description, weight, deliveryAddress, sendDay);
                allParcels.add(fragileParcel);
                trackableParcels.add(fragileParcel);
                fragileParcelBox.addParcel(fragileParcel);
                break;
            case PERISHABLE:
                PerishableParcel perishableParcel = new PerishableParcel(description, weight, deliveryAddress, sendDay, timeToLive);
                allParcels.add(perishableParcel);
                perishableParcelBox.addParcel(perishableParcel);
                break;
            default:
        }
        System.out.println("Посылка " + description + " принята в службу доставки.");
    }

    public void sendParcels() {
        for (Parcel parcel : allParcels) {
            parcel.packageItem();
            parcel.deliver();
        }
    }

    public int calculateCosts() {
        int totalDeliveryCost = 0;
        for (Parcel parcel : allParcels) {
            totalDeliveryCost += parcel.calculateDeliveryCost();
        }
        return totalDeliveryCost;
    }

    public void changeLocation(String newLocation) {
        for (Trackable trackableParcel : trackableParcels) {
            trackableParcel.reportStatus(newLocation);
        }
    }

    public List<? extends Parcel> getAllFromParcelBox(ParcelType parcelType) {
        switch (parcelType) {
            case STANDARD:
                return standartParselBox.getAllParcels();
            case FRAGILE:
                return fragileParcelBox.getAllParcels();
            case PERISHABLE:
                return perishableParcelBox.getAllParcels();
        }
        return null;
    }
}

