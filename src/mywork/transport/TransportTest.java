package mywork.transport;

public class TransportTest {
    public static void main(String[] args) {

        Car testCar = new Car(
                "Audi",
                "",
                1.7,
                250,
                "зеленый",
                0,
                "",
                "автоматическая",
                null,
                "л45щз",
                0,
                true,
                new Car.Key(true, false));

        System.out.println("Блок проверки (автомобиль)");
        System.out.println(testCar);
        testCar.setEngineVolume(0);
        testCar.setColor("");
        testCar.setGearBox(" ");
        testCar.setRegistrationNumber("п123ро196");
        testCar.setMaxSpeed(0);
        System.out.println(testCar);

        Bus testBus = new Bus(
                "Iveco",
                "",
                2020,
                " ",
                "зеленый",
                100
        );
        System.out.println("Блок проверки (автобус)");
        System.out.println(testBus);
        testBus.setColor(" ");
        testBus.setMaxSpeed(-1);
        System.out.println(testBus);
    }
}
