package ru.yandex.practicum.delivery;

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

    public int getSendDay() {
        return sendDay;
    }

    protected void packageItem() {
        System.out.println("Посылка " + description + " упакована.");
    }

    protected int calculateDeliveryCost() {
        return weight * getDeliveryCost();
    }

    protected void deliver() {
        System.out.println("Посылка " + description + " доставлена по адресу " + deliveryAddress +".");
    }
}
