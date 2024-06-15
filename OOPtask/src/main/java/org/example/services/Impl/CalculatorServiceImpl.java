package org.example.services.Impl;

import org.example.entities.Car;
import org.example.entities.CargoVan;
import org.example.entities.Motorcycle;
import org.example.entities.Vehicle;
import org.example.entities.enums.VehicleType;
import org.example.exceptions.InvalidVehicleType;
import org.example.services.CalculatorService;

import java.time.LocalDate;

public class CalculatorServiceImpl implements CalculatorService {


    @Override
    public double calculateRentalCostPerDay(Vehicle vehicle) throws InvalidVehicleType {
        VehicleType type = vehicle.getType();
        double dailyCost = 0.0;

        switch (type) {
            case CAR:
                if (vehicle.getRentalPeriod() >= 7) {
                    dailyCost = Car.DAILY_COST_FOR_MORE_THAN_A_WEEK;
                } else {
                    dailyCost = Car.DAILY_COST;
                }
                break;

            case MOTORCYCLE:
                if (vehicle.getRentalPeriod() >= 7) {
                    dailyCost = Motorcycle.DAILY_COST_FOR_MORE_THAN_A_WEEK;
                } else {
                    dailyCost = Motorcycle.DAILY_COST;
                }
                break;

            case CARGO_VAN:
                if (vehicle.getRentalPeriod() >= 7) {
                    dailyCost = CargoVan.DAILY_COST_FOR_MORE_THAN_A_WEEK;
                } else {
                    dailyCost = CargoVan.DAILY_COST;
                }
                break;
            default:
                throw new InvalidVehicleType("Ooopss, vehicle type you provided is not in the list yet!");
        }

        return dailyCost;
    }


    @Override
    public double calculateInsuranceCostPerDay(Vehicle vehicle) throws InvalidVehicleType {
        VehicleType type = vehicle.getType();
        double value = vehicle.getValue();
        int days = vehicle.getRentalPeriod();
        double insuranceCost = 0.0;
        switch (type) {
            case CAR:
                insuranceCost = Car.INSURANCE_DAILY;
                if (vehicle.haveInsuranceChange()) {
                    insuranceCost *= 0.9;
                }
                break;

            case MOTORCYCLE:
                insuranceCost = Motorcycle.INSURANCE_DAILY;
                if (vehicle.haveInsuranceChange()) {
                    insuranceCost *= 1.2;
                }
                break;

            case CARGO_VAN:
                insuranceCost = CargoVan.INSURANCE_DAILY;
                if (vehicle.haveInsuranceChange()) {
                    insuranceCost *= 0.85;
                }
                break;

            default:
                throw new InvalidVehicleType("Ooopss, vehicle type you provided is not in the list yet!");
        }
        return insuranceCost * value / 100;
    }

    @Override
    public double calculateTotalCost(Vehicle vehicle) throws InvalidVehicleType {
        double totalSum = 0.0;
        int rentalDays = vehicle.getRentalPeriod();
        int actualDays = vehicle.getActualDays();
        if (rentalDays != actualDays) {
            rentalDays -= actualDays;
            totalSum += calculateRentalCostPerDay(vehicle) * actualDays;
            totalSum += (calculateRentalCostPerDay(vehicle) * rentalDays) / 2;
            totalSum += calculateInsuranceCostPerDay(vehicle) * actualDays;
        } else {
            totalSum += calculateRentalCostPerDay(vehicle) * rentalDays;
            totalSum += calculateInsuranceCostPerDay(vehicle) * rentalDays;
        }
        return totalSum;
    }

    @Override
    public void printData(Vehicle vehicle) throws InvalidVehicleType {
        System.out.printf("Date: " + LocalDate.now() + "%n");
        System.out.printf("Rented Vehicle: " + vehicle.getBrand() + " " + vehicle.getModel() + "%n");
        System.out.printf("Reservation start date: " + LocalDate.now() + "%n");
        System.out.printf("Reservation end date: " + LocalDate.now().plusDays(vehicle.getRentalPeriod()) + "%n");
        System.out.printf("Reserved days: %d%n", vehicle.getRentalPeriod());
        System.out.println();
        System.out.printf("Actual Return date: " + LocalDate.now().plusDays(vehicle.getActualDays()) + "%n");
        System.out.printf("Actual days: %d%n", vehicle.getActualDays());
        System.out.println();
        System.out.printf("Rental per day: %.2f$ %n", calculateRentalCostPerDay(vehicle));
        System.out.printf("Insurance per day: %.2f$ %n", calculateInsuranceCostPerDay(vehicle));
        System.out.println();
        System.out.printf("Total rent: %.2f$ %n", calculateRentalCostPerDay(vehicle) * vehicle.getActualDays());
        System.out.printf("Total insurance: %.2f$ %n", calculateInsuranceCostPerDay(vehicle) * vehicle.getActualDays());
        System.out.printf("Total Sum: %.2f$ %n", calculateTotalCost(vehicle));
        System.out.println("XXXXXXXXXXXXXXXXXXXXXXXXX");
    }
}
