package org.example.entities;

import org.example.entities.enums.VehicleType;

public class CargoVan extends BaseVehicle {

    public static final double DAILY_COST = 50;
    public static final double DAILY_COST_FOR_MORE_THAN_A_WEEK = 40;
    public static final double INSURANCE_DAILY = 0.03;

    private VehicleType type = VehicleType.CARGO_VAN;
    private int driverExperience;

    public CargoVan(String brand, String model, double value, int rentalPeriod, int actualDays, int driverExperience) {
        super(brand, model, value, rentalPeriod, actualDays);
        this.driverExperience = driverExperience;
    }

    public int getDriverExperience() {
        return driverExperience;
    }

    public void setDriverExperience(int driverExperience) {
        this.driverExperience = driverExperience;
    }

    public VehicleType getType() {
        return type;
    }

    @Override
    public boolean haveInsuranceChange() {
        return this.driverExperience > 5;
    }
}
