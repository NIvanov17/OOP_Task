package org.example.entities;

import org.example.entities.enums.VehicleType;

public class Car extends BaseVehicle {

    public static final double DAILY_COST = 20;
    public static final double DAILY_COST_FOR_MORE_THAN_A_WEEK = 15;
    public static final double INSURANCE_DAILY = 0.01;

    private VehicleType type = VehicleType.CAR;

    private int rating;


    public Car(String brand, String model, double value, int rentalPeriod, int actualDays, int rating) {
        super(brand, model, value, rentalPeriod, actualDays);
        this.rating = rating;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public VehicleType getType() {
        return type;
    }

    @Override
    public boolean haveInsuranceChange() {
        return this.rating > 3;
    }
}
