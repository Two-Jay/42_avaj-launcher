package kr.ft.avaj.simulator.Core.Aircraft.Factory;

import kr.ft.avaj.simulator.Core.Aircraft.Flyable;
import kr.ft.avaj.simulator.Core.Aircraft.Baloon;
import kr.ft.avaj.simulator.Core.Aircraft.Helicopter;
import kr.ft.avaj.simulator.Core.Aircraft.JetPlane;
import kr.ft.avaj.simulator.Core.Coordinates.Coordinates;

public class AircraftFactory {
    private static Long idCounter = 0L;

    public Flyable newAircraft(String type, String name, Coordinates coordinates) {
        if (type.equals("Baloon")) {
            return new Baloon(this.nextId(), name, coordinates);
        } else if (type.equals("JetPlane")) {
            return new JetPlane(this.nextId(), name, coordinates);
        } else if (type.equals("Helicopter")) {
            return new Helicopter(this.nextId(), name, coordinates);
        }
        return null;
    }

    public static Long nextId() {
        return idCounter++;
    }
}
