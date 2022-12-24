package kr.ft.avaj.simulator;

public class AircraftFactory {
    public Flyable newAircraft(String type, String name, int longitude, int latitude, int height) {
        Coordinates coordinates = new Coordinates(longitude, latitude, height);
        if (type.equals("Baloon")) {
            return new Baloon(name, coordinates);
        } else if (type.equals("JetPlane")) {
            return new JetPlane(name, coordinates);
        } else if (type.equals("Helicopter")) {
            return new Helicopter(name, coordinates);
        } else {
            System.err.println("Invalid aircraft type: " + type);
            System.exit(1);
        }
        return null;
    }
}
