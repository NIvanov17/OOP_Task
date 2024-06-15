package org.example.exceptions;

public class InvalidVehicleType extends IllegalArgumentException{

    public InvalidVehicleType(String message) {
        super(message);
    }

    public InvalidVehicleType(Throwable cause) {
        super(cause);
    }
}
