package kr.ft.avaj.simulator;

import java.util.ArrayList;

public class AircraftFactory {
    private ArrayList<String> aircraftTypes = new ArrayList<String>();

    public Flyable newAircraft(String type, String name, int longitude, int latitude, int height) {
        try {
            if (longitude < 0 || latitude < 0 || height < 0) {
                throw new InvalidCoordinatesException();
            }
            if (!aircraftTypes.contains(type)) {
                throw new InvalidAircraftTypeException();
            }
            Coordinates coordinates = new Coordinates(longitude, latitude, height);
            if (type.equals("Baloon")) {
                return new Baloon(name, coordinates);
            } else if (type.equals("JetPlane")) {
                return new JetPlane(name, coordinates);
            } else if (type.equals("Helicopter")) {
                return new Helicopter(name, coordinates);
            }
        } catch (InvalidCoordinatesException e) {
            System.out.println("Invalid coordinates");
            System.exit(1);
        } catch (InvalidAircraftTypeException e) {
            System.out.println("Invalid aircraft type");
            System.exit(1);
        }
        return null;
    }

    AircraftFactory() {
        aircraftTypes.add("Baloon");
        aircraftTypes.add("JetPlane");
        aircraftTypes.add("Helicopter");
    }
}