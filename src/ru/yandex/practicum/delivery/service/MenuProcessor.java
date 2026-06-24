package ru.yandex.practicum.delivery.service;

import ru.yandex.practicum.delivery.model.Parcel;
import ru.yandex.practicum.delivery.model.ParcelType;

import static ru.yandex.practicum.delivery.service.ConsoleIOService.*;

public class MenuProcessor {
    private final DeliveryService deliveryService;

    public MenuProcessor() {
        this.deliveryService = new DeliveryService();
    }

    public void addParcel() {
        ParcelType parcelType = choosTypeParcel();
        int weight = readNumberWithPrompt("Укажите вес посылки целым числом: ");
        String description = readStringWithPrompt("Введите описание посылки: ");
        String deliveryAddress = readStringWithPrompt("Укажите адрес доставки: ");
        int sendDay = readNumberWithPrompt("Укажите день отправки: ");
        int timeToLive = 0;
        if (parcelType == ParcelType.PERISHABLE) {
            timeToLive = readNumberWithPrompt("Укажите срок хранения в днях: ");
        }
        deliveryService.addParcel(parcelType, weight, description, deliveryAddress, sendDay, timeToLive);
    }

    public void sendParcels() {
        deliveryService.sendParcels();
    }

    public void calculateCosts() {
        System.out.println("Общая стоимость доставки всех посылок составляет: " + deliveryService.calculateCosts());
    }

    public void changeLocation() {
        String newLocation = ConsoleIOService.readStringWithPrompt("Введите новое местоположение посылок: ");
        deliveryService.changeLocation(newLocation);
    }

    public void getAllFromParcelBox() {
        ParcelType parcelType = choosTypeParcel();
        System.out.println("Коробка с типом \"" + parcelType.getTitle() +"\" содержит следующие посылки: ");
        for (Parcel parcel : deliveryService.getAllFromParcelBox(parcelType)) {
            System.out.println(parcel.getDescription());
        }
    }

    private ParcelType choosTypeParcel() {
        int parcelTypeNumber = readNumberWithPrompt("Выберите тип посылки (1-Стандартная, 2-Хрупкая, 3-Скоропортящаяся): ");
        return ParcelType.values()[parcelTypeNumber - 1];
    }
}
