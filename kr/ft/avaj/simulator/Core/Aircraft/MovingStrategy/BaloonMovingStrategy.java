package kr.ft.avaj.simulator.Core.Aircraft.MovingStrategy;

import kr.ft.avaj.simulator.Core.Aircraft.Coordinates.Coordinates;
import kr.ft.avaj.simulator.Exception.UnsupportedWeatherException;
import kr.ft.avaj.simulator.Utils.SimulationMetaData;

public class BaloonMovingStrategy implements MovingStrategy {
    public void move(Coordinates co) throws UnsupportedWeatherException {
        switch (co.getWeather()) {
            case SUN:
                co.setLongitude(co.getLongitude() + 2);
                co.setHeight(co.getHeight() + 4);
                break;
            case RAIN:
                co.setHeight(co.getHeight() - 5);
                break;
            case FOG:
                co.setHeight(co.getHeight() - 3);
                break;
            case SNOW:
                co.setHeight(co.getHeight() - 15);
                break;
            default:
                throw new UnsupportedWeatherException();
        }
        if (co.getHeight() > SimulationMetaData.heightMaximum) {
            co.setHeight(SimulationMetaData.heightMaximum);
        }
    }
}

// Baloon Moving Strategy ---------------------------------
// ◦ SUN - Longitude increases with 2, Height increases with 4
// ◦ RAIN - Height decreases with 5
// ◦ FOG - Height decreases with 3
// ◦ SNOW - Height decreases with 15
// ---------------------------------------------------------