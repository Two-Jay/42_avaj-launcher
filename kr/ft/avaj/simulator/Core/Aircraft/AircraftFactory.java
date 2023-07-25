package kr.ft.avaj.simulator.Core.Aircraft;

import kr.ft.avaj.simulator.Core.Aircraft.Coordinates.Coordinates;
import kr.ft.avaj.simulator.Exception.UnsupportedAircraftTypeException;

public class AircraftFactory {
    private static Long idCounter = 0L;

    private AircraftFactory() {
    }

    private static class Holder {
        public static final AircraftFactory INSTANCE = new AircraftFactory();
    }

    public static AircraftFactory getINSTANCE() {
        return Holder.INSTANCE;
    }

    public static Flyable newAircraft(String type, String name, Coordinates co)
            throws UnsupportedAircraftTypeException {
        if (type.equals("Baloon")) {
            return new Baloon(AircraftFactory.nextId(), name, co);
        } else if (type.equals("JetPlane")) {
            return new JetPlane(AircraftFactory.nextId(), name, co);
        } else if (type.equals("Helicopter")) {
            return new Helicopter(AircraftFactory.nextId(), name, co);
        }
        throw new UnsupportedAircraftTypeException();
    }

    public static Long nextId() {
        return idCounter++;
    }
}
