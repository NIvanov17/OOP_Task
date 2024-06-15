package org.example.entities;

public abstract class BaseVehicle implements Vehicle {

    private String brand;
    private String model;
    private double value;
    private int rentalPeriod;
    private int actualDays;


    public BaseVehicle() {
    }

    public BaseVehicle(String brand, String model, double value, int rentalPeriod, int actualDays) {
        this.brand = brand;
        this.model = model;
        this.value = value;
        this.rentalPeriod = rentalPeriod;
        this.actualDays = actualDays;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public int getRentalPeriod() {
        return rentalPeriod;
    }

    public void setRentalPeriod(int rentalPeriod) {
        this.rentalPeriod = rentalPeriod;
    }

    public int getActualDays() {
        return actualDays;
    }

    public void setActualDays(int actualDays) {
        this.actualDays = actualDays;
    }

}
