package mywork.transport;

public class Bus extends Transport{

    public Bus (String brand,
                String model,
                int year,
                String country,
                String color,
                int maxSpeed) {
        super(brand, model, year, country, color, maxSpeed);
    }

    public int validateMaxSpeed(int maxSpeed) {
        return maxSpeed <= 0 ? 90 : maxSpeed;
    }
}