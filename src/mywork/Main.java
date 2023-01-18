package mywork;

import mywork.transport.Car;
import mywork.transport.Bus;
import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {

        insertSeparator();
        System.out.println("Список автомобилей");
        insertSeparator();

        Car car1 = new Car("Lada","Granta", 1.7,  184,"желтый", 2015, "Россия", "ручная",
                "cедан", "в563аа177", 4,
                true, new Car.Key(false, false));
        Car car2 = new Car("Audi", "A8 50 L TDI quattro", 3.0, 250, "черный", 2020, "Германия",
                "автоматическая", "седан", "а001аа177", 4,
                false, new Car.Key(false, true));
        Car car3 = new Car("BMW", "Z8", 3.0, 250, "черный", 2021, "Германия", "автоматическая",
                "родстер", "р896ва102", 2,
                true, new Car.Key(true, false));
        Car car4 = new Car("Kia", "Sportage 4-го поколения", 2.4, 197, "красный", 2018, "Южная Корея",
                "автоматическая", "внедорожник", "к564ра116", 6,
                false, new Car.Key(true, true));
        Car car5 = new Car("Hyundai", "Avante", 1.6, 203, "оранжевый", 2016, "Южная Корея",
                "механическая", "хэтчбек", "о831уа10", 4,
                false, new Car.Key(true, false));

        System.out.println(car1);
        System.out.println(car2);
        System.out.println(car3);
        System.out.println(car4);
        System.out.println(car5);

        insertSeparator();

        car1.setSummerTyre(Car.changeTyre(LocalDate.now().getMonthValue())); //замена резины в зависимости от текущего месяца
        System.out.println("Сменить резину у следующих автомобилей:\n " + car1);

        insertSeparator();
        System.out.println("Список автобусов");
        insertSeparator();

        Bus bus1 = new Bus("Mercedes-Benz", "Tourismo", 2017, "Германия", "белый", 140);
        Bus bus2 = new Bus("Scania", "A80", 2019, "Швеция", "красный", 100);
        Bus bus3 = new Bus("Toyota", "Coaster", 2015, "Япония", "серый", 130);

        System.out.println(bus1);
        System.out.println(bus2);
        System.out.println(bus3);

        insertSeparator();
    }

    public static void insertSeparator() {
        System.out.println("===========================================================" +
                "=============================================");
    }
}
