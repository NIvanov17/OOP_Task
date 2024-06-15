package org.example;

import org.example.entities.*;
import org.example.exceptions.InvalidVehicleType;
import org.example.services.CalculatorService;
import org.example.services.Impl.CalculatorServiceImpl;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        Vehicle car = new Car("Audi", "A5", 15000, 10,10 ,3);
        Vehicle motorcycle = new Motorcycle("Yamaha", "R1", 10000, 10, 10,20);
        Vehicle van = new CargoVan("Ford", "Transit", 20000, 15, 10,8);
        CalculatorService service = new CalculatorServiceImpl();

        List<Vehicle> vehicles = new ArrayList<>();
        vehicles.add(car);
        vehicles.add(motorcycle);
        vehicles.add(van);


        vehicles
                .forEach(service::printData);
    }
}