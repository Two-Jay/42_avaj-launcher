package kr.ft.avaj.simulator.Core.Aircraft.MovingStrategy;

import kr.ft.avaj.simulator.Core.Aircraft.Coordinates.Coordinates;
import kr.ft.avaj.simulator.Exception.UnsupportedWeatherException;

public interface MovingStrategy {
    public void move(Coordinates co) throws UnsupportedWeatherException;
}
