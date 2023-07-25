package kr.ft.avaj.simulator.Core.Aircraft.MovingStrategy;

import kr.ft.avaj.simulator.Core.Aircraft.Coordinates.Coordinates;

public class BaloonMovingStrategy implements MovingStrategy {
    public void move(Coordinates co) {
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
                break;
        }
    }
}

// Baloon Moving Strategy ---------------------------------
// ◦ SUN - Longitude increases with 2, Height increases with 4
// ◦ RAIN - Height decreases with 5
// ◦ FOG - Height decreases with 3
// ◦ SNOW - Height decreases with 15
// ---------------------------------------------------------