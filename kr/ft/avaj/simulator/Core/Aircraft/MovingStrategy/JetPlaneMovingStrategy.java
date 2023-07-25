package kr.ft.avaj.simulator.Core.Aircraft.MovingStrategy;

import kr.ft.avaj.simulator.Core.Aircraft.Coordinates.Coordinates;
import kr.ft.avaj.simulator.Exception.UnsupportedWeatherException;
import kr.ft.avaj.simulator.Utils.SimulationMetaData;

public class JetPlaneMovingStrategy implements MovingStrategy {
    public void move(Coordinates co) throws UnsupportedWeatherException {
        switch (co.getWeather()) {
            case SUN:
                co.setLatitude(co.getLatitude() + 10);
                co.setHeight(co.getHeight() + 2);
                break;
            case RAIN:
                co.setLatitude(co.getLatitude() + 5);
                break;
            case FOG:
                co.setLatitude(co.getLatitude() + 1);
                break;
            case SNOW:
                co.setHeight(co.getHeight() - 7);
                break;
            default:
                throw new UnsupportedWeatherException();
        }
        if (co.getHeight() > SimulationMetaData.heightMaximum) {
            co.setHeight(SimulationMetaData.heightMaximum);
        }
    }
}

// JetPlane Moving Strategy ---------------------------------
// ◦ SUN - Latitude increases with 10, Height increases with 2
// ◦ RAIN - Latitude increases with 5
// ◦ FOG - Latitude increases with 1
// ◦ SNOW - Height decreases with 7
// ----------------------------------------------------------