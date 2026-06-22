package ru.yandex.practicum.delivery;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DeliveryApp {
    public static final int STANDARD_DELIVERY_COST = 2;
    public static final int PERISHABLE_DELIVERY_COST = 3;
    public static final int FRAGILE_DELIVERY_COST = 4;

    private static final Scanner scanner = new Scanner(System.in);
    private static final List<Parcel> allParcels = new ArrayList<>();

    public static void main(String[] args) {
        boolean running = true;
        while (running) {
            showMenu();
            int choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1:
                    addParcel();
                    break;
                case 2:
                    sendParcels();
                    break;
                case 3:
                    calculateCosts();
                    break;
                case 0:
                    running = false;
                    break;
                default:
                    System.out.println("Неверный выбор.");
            }
        }
    }

    private static void showMenu() {
        System.out.println("Выберите действие:");
        System.out.println("1 — Добавить посылку");
        System.out.println("2 — Отправить все посылки");
        System.out.println("3 — Посчитать стоимость доставки");
        System.out.println("0 — Завершить");
    }

    // реализуйте методы ниже

    private static void addParcel() {
        // Подсказка: спросите тип посылки и необходимые поля, создайте объект и добавьте в allParcels
        allParcels.add(new StandardParcel("Стандартная посылка", 4, "Адрес доставки 1", 4));
        allParcels.add(new FragileParcel("Хрупкая посылка", 3, "Адрес доставки 2", 6));
        allParcels.add(new PerishableParcel("Скоропортящаяся посылка", 6, "Адрес доставки 3",
                8, 10));
    }

    private static void sendParcels() {
        // Пройти по allParcels, вызвать packageItem() и deliver()
        for (Parcel parcel: allParcels) {
            parcel.packageItem();
            parcel.deliver();
        }
    }

    private static void calculateCosts() {
        // Посчитать общую стоимость всех доставок и вывести на экран
        for (Parcel parcel: allParcels) {
            System.out.println(parcel.calculateDeliveryCost());
        }
    }

}

