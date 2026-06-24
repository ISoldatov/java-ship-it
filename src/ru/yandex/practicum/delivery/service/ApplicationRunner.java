package ru.yandex.practicum.delivery.service;

public class ApplicationRunner {

    private final MenuProcessor menuProcessor;

    public ApplicationRunner() {
        this.menuProcessor = new MenuProcessor();
    }

    public void run() {
        boolean running = true;
        while (running) {
            showMenu();
            int choice = ConsoleIOService.readNumber();
            switch (choice) {
                case 1:
                    menuProcessor.addParcel();
                    break;
                case 2:
                    menuProcessor.sendParcels();
                    break;
                case 3:
                    menuProcessor.calculateCosts();
                    break;
                case 4:
                    menuProcessor.changeLocation();
                    break;
                case 5:
                    menuProcessor.getAllFromParcelBox();
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
        System.out.println("4 — Изменить местоположение отслеживаемых посылок");
        System.out.println("5 — Показать содержимое коробки");
        System.out.println("0 — Завершить");
    }
}
