package ru.yandex.practicum.delivery.model;

public enum ParcelType {
    STANDARD("Стандартная"),
    FRAGILE ("Хрупкая"),
    PERISHABLE ("Скоропортящаяся");

    private final String title;

    ParcelType(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }
}
