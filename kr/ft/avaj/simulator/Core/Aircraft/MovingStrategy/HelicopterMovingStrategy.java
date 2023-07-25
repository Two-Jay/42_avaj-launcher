package kr.ft.avaj.simulator.Core.Aircraft.MovingStrategy;

import kr.ft.avaj.simulator.Core.Aircraft.Coordinates.Coordinates;

public class HelicopterMovingStrategy implements MovingStrategy {
    public void move(Coordinates co) {
        switch (co.getWeather()) {
            case SUN:
                co.setLongitude(co.getLongitude() + 10);
                co.setHeight(co.getHeight() + 2);
                break;
            case RAIN:
                co.setLongitude(co.getLongitude() + 5);
                break;
            case FOG:
                co.setLongitude(co.getLongitude() + 1);
                break;
            case SNOW:
                co.setHeight(co.getHeight() - 12);
                break;
            default:
                break;
        }
    }
}

// Helicopter Moving Strategy ---------------------------------
// ◦ SUN - Longitude increases with 10, Height increases with 2
// ◦ RAIN - Longitude increases with 5
// ◦ FOG - Longitude increases with 1
// ◦ SNOW - Height decreases with 12
// ------------------------------------------------------------