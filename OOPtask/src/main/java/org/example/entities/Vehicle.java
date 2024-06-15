package org.example.entities;

import org.example.entities.enums.VehicleType;

public interface Vehicle {
    VehicleType getType();

    int getRentalPeriod();

    double getValue();

    boolean haveInsuranceChange();

    String getBrand();

    String getModel();

    int getActualDays();

}
