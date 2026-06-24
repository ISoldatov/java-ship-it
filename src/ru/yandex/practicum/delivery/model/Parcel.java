package ru.yandex.practicum.delivery.model;

public abstract class Parcel {

    private final String description;
    private final int weight;
    private final String deliveryAddress;
    private final int sendDay;

    protected abstract int getDeliveryCost();

    public Parcel(String description, int weight, String deliveryAddress, int sendDay) {
        this.description = description;
        this.weight = weight;
        this.deliveryAddress = deliveryAddress;
        this.sendDay = sendDay;
    }

    public String getDescription() {
        return description;
    }

    public int getWeight() {
        return weight;
    }

    public int getSendDay() {
        return sendDay;
    }

    public void packageItem() {
        System.out.println("Посылка " + description + " упакована.");
    }

    public int calculateDeliveryCost() {
        return weight * getDeliveryCost();
    }

    public void deliver() {
        System.out.println("Посылка " + description + " доставлена по адресу " + deliveryAddress + ".");
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;

        Parcel parcel = (Parcel) o;
        return description.equals(parcel.description);
    }

    @Override
    public int hashCode() {
        return description.hashCode();
    }
}
