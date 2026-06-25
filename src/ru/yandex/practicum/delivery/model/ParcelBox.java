package ru.yandex.practicum.delivery.model;

import java.util.ArrayList;
import java.util.List;

public class ParcelBox<T extends Parcel> {
    public static final int DEFAULT_BOX_WEIGHT = 25;

    private final int maxWeight;
    private int currentWeight;

    private final List<T> parcelsInBox = new ArrayList<>();

    public ParcelBox(int maxWeight) {
        this.maxWeight = maxWeight;
        currentWeight = 0;
    }

    public void addParcel(T parcel) {
        int newWeight = parcel.getWeight() + currentWeight;
        if (newWeight > maxWeight) {
            System.out.println("ОШИБКА! Максимальный вес коробки превышен на " + (newWeight - maxWeight) + " кг.");
            return;
        }
        currentWeight = newWeight;
        parcelsInBox.add(parcel);
        System.out.println("Посылка " + parcel.getDescription() + " добавлена в коробку.");
    }

    public List<T> getAllParcels() {
        return parcelsInBox;
    }
}
