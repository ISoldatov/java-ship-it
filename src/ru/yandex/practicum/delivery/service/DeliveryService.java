package ru.yandex.practicum.delivery.service;

import ru.yandex.practicum.delivery.model.*;

import java.util.*;

public class DeliveryService {
    private final List<Parcel> allParcels = new ArrayList<>();
    private final List<Trackable> trackableParcels = new ArrayList<>();

    private final ParcelBox<StandardParcel> standardParseBox = new ParcelBox<>();
    private final ParcelBox<FragileParcel> fragileParcelBox = new ParcelBox<>();
    private final ParcelBox<PerishableParcel> perishableParcelBox = new ParcelBox<>();

    public void addParcel(ParcelType parcelType, int weight, String description, String deliveryAddress, int sendDay,
                          int timeToLive) {
        Parcel parcel = null;
        switch (parcelType) {
            case STANDARD:
                parcel = new StandardParcel(description, weight, deliveryAddress, sendDay);
                standardParseBox.addParcel((StandardParcel) parcel);
                break;
            case FRAGILE:
                parcel = new FragileParcel(description, weight, deliveryAddress, sendDay);
                trackableParcels.add((FragileParcel) parcel);
                fragileParcelBox.addParcel((FragileParcel) parcel);
                break;
            case PERISHABLE:
                parcel = new PerishableParcel(description, weight, deliveryAddress, sendDay, timeToLive);
                perishableParcelBox.addParcel((PerishableParcel) parcel);
                break;
            default:
        }
        allParcels.add(parcel);
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
                return standardParseBox.getAllParcels();
            case FRAGILE:
                return fragileParcelBox.getAllParcels();
            case PERISHABLE:
                return perishableParcelBox.getAllParcels();
        }
        return null;
    }
}

