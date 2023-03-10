package kr.ft.avaj.simulator;

import java.util.ArrayList;

public class AircraftFactory {
    private ArrayList<String> aircraftTypes = new ArrayList<String>();

    public Flyable newAircraft(String type, String name, int longitude, int latitude, int height) {
        try {
            if (isValidAircraftType(type) == false) {
                throw new InvalidAircraftTypeException(type);
            }
            Coordinates coordinates = new Coordinates(longitude, latitude, height);
            if (type.equals("Baloon")) {
                return new Baloon(name, coordinates);
            } else if (type.equals("JetPlane")) {
                return new JetPlane(name, coordinates);
            } else if (type.equals("Helicopter")) {
                return new Helicopter(name, coordinates);
            }
        } catch (InvalidAircraftTypeException e) {
            System.out.println(e.getMessage());
            System.exit(1);
        }
        return null;
    }

    private boolean isValidAircraftType(String type) {
        return aircraftTypes.contains(type);
    }

    AircraftFactory() {
        aircraftTypes.add("Baloon");
        aircraftTypes.add("JetPlane");
        aircraftTypes.add("Helicopter");
    }
}