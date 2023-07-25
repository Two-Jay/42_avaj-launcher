package kr.ft.avaj.simulator.Core.Aircraft.Factory;

import kr.ft.avaj.simulator.Core.Aircraft.Flyable;
import kr.ft.avaj.simulator.Core.Aircraft.Baloon;
import kr.ft.avaj.simulator.Core.Aircraft.Helicopter;
import kr.ft.avaj.simulator.Core.Aircraft.JetPlane;
import kr.ft.avaj.simulator.Core.Aircraft.Coordinates.Coordinates;

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

    public static Flyable newAircraft(String type, String name, Coordinates coordinates) {
        if (type.equals("Baloon")) {
            return new Baloon(AircraftFactory.nextId(), name, coordinates);
        } else if (type.equals("JetPlane")) {
            return new JetPlane(AircraftFactory.nextId(), name, coordinates);
        } else if (type.equals("Helicopter")) {
            return new Helicopter(AircraftFactory.nextId(), name, coordinates);
        }
        return null;
    }

    public static Long nextId() {
        return idCounter++;
    }
}
