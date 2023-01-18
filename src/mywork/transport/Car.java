package mywork.transport;


import mywork.Validation;
import java.util.Objects;
import java.util.regex.Pattern;

public class Car extends Transport {
    private double engineVolume;
    private String gearBox;
    private final String bodyType;
    private String registrationNumber;
    private final int seatQuantity;
    private boolean isSummerTyre;
    private final Key key;

    public Car(String brand,
               String model,
               double engineVolume,
               int maxSpeed,
               String color,
               int year,
               String country,
               String gearBox,
               String bodyType,
               String registrationNumber,
               int seatQuantity,
               boolean isSummerTyre,
               Key key) {
        super(brand, model, year, country, color, maxSpeed);
        this.engineVolume = validateEngineVolume(engineVolume);
        this.gearBox = Validation.validateCarParameter(gearBox);
        this.bodyType = Validation.validateCarParameter(bodyType);
        this.registrationNumber = validateRegistrationNumber(registrationNumber);
        this.seatQuantity = validateSeatQuantity(seatQuantity);
        this.isSummerTyre = Validation.validateBoolean(isSummerTyre);
        this.key = key;
    }

    public double getEngineVolume() {
        return engineVolume;
    }

    public void setEngineVolume(double engineVolume) {
        this.engineVolume = validateEngineVolume(engineVolume);
    }

    public String getGearBox() {
        return gearBox;
    }

    public void setGearBox(String gearBox) {
        this.gearBox = Validation.validateCarParameter(gearBox);
    }

    public String getBodyType() {
        return bodyType;
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public void setRegistrationNumber(String registrationNumber) {
        this.registrationNumber = validateRegistrationNumber(registrationNumber);
    }

    public int getSeatQuantity() {
        return seatQuantity;
    }

    public boolean getSummerTyre() {
        return isSummerTyre;
    }

    public void setSummerTyre(boolean summerTyre) {
        this.isSummerTyre = summerTyre;
    }

    public Key getKey() {
        return key;
    }

    public static class Key {
        private final boolean isRemoteEngineStart;
        private final boolean isKeylessEntry;

        public Key(boolean isRemoteEngineStart, boolean isKeylessEntry) {
            this.isRemoteEngineStart = Validation.validateBoolean(isRemoteEngineStart);
            this.isKeylessEntry = Validation.validateBoolean(isKeylessEntry);
        }

        @Override
        public String toString() {
            String remoteStart = isRemoteEngineStart ? "удаленный запуск двигателя - есть" : "удаленный запуск двигателя - нет";
            String keylessEntry = isKeylessEntry ? "бесключевой доступ - есть" : "бесключевой доступ - нет";
            return remoteStart + "\n    " + keylessEntry + "\n";
        }
    }

    @Override
    public String toString() {
        String summerTyre = isSummerTyre ? "летняя" : "зимняя";
        return super.toString() + "\n    объем двигателя - " + engineVolume + " л\n    коробка передач - " + gearBox +
                "\n    тип кузова - " + bodyType + "\n    регистрационный номер - " + registrationNumber +
                "\n    количество мест - " + seatQuantity + "\n    резина - " + summerTyre + "\n    " + key;
    }

    //  Метод для замены шин (летней на зимнюю и наоборот) в зависимости от месяца (летняя - с апреля по октябрь)
    public static boolean changeTyre(int currentMonth) {
        return currentMonth > 3 && currentMonth < 11;
    }

    //  Блок валидации параметров
    public double validateEngineVolume(double engineVolume) {
        return engineVolume <= 0 ? 1.5 : engineVolume;
    }

    public int validateMaxSpeed(int maxSpeed) {
        return maxSpeed <= 0 ? 160 : maxSpeed;
    }

    public String validateRegistrationNumber(String registrationNumber) {
        if (Pattern.matches("[авекмнорстух][0-9]{3}[авекмнорстух]{2}[0-9]{2,3}",registrationNumber)) {
            return registrationNumber;
        } else {
            return "ошибка! регистрационный номер указан неверно";
        }
    }
    public int validateSeatQuantity(int seatQuantity) {
        return seatQuantity <= 0 ? 4 : seatQuantity;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other == null || getClass() != other.getClass()) {
            return false;
        }
        if (!super.equals(other)) {
            return false;
        }
        Car car = (Car) other;
        return super.equals(other) && Double.compare(car.engineVolume, engineVolume) == 0 && seatQuantity == car.seatQuantity
                && Objects.equals(gearBox, car.gearBox) && Objects.equals(bodyType, car.bodyType)
                && Objects.equals(registrationNumber, car.registrationNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), engineVolume, gearBox, bodyType, registrationNumber, seatQuantity);
    }
}

