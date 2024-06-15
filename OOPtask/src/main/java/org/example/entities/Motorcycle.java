package org.example.entities;

import org.example.entities.enums.VehicleType;

public class Motorcycle extends BaseVehicle {

    public static final double DAILY_COST = 15;
    public static final double DAILY_COST_FOR_MORE_THAN_A_WEEK = 10;
    public static final double INSURANCE_DAILY = 0.02;

    private VehicleType type = VehicleType.MOTORCYCLE;
    private int riderAge;

    public Motorcycle(String brand, String model, double value, int rentalPeriod, int actualDays, int riderAge) {
        super(brand, model, value, rentalPeriod, actualDays);
        this.riderAge = riderAge;
    }

    public int getRiderAge() {
        return riderAge;
    }

    public void setRiderAge(int riderAge) {
        this.riderAge = riderAge;
    }

    public VehicleType getType() {
        return type;
    }

    @Override
    public boolean haveInsuranceChange() {
        return this.riderAge < 25;
    }
}
