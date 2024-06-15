package org.example.services;


import org.example.entities.Vehicle;
import org.example.exceptions.InvalidVehicleType;


public interface CalculatorService {

    double calculateRentalCostPerDay(Vehicle vehicle) throws InvalidVehicleType;

    double calculateInsuranceCostPerDay(Vehicle vehicle) throws InvalidVehicleType;

    double calculateTotalCost(Vehicle vehicle) throws InvalidVehicleType;

    void printData(Vehicle vehicle) throws InvalidVehicleType;
}
