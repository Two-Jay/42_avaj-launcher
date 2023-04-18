package kr.ft.avaj.simulator.Aircraft.UpdateStrategy;

import kr.ft.avaj.simulator.Aircraft.Coordinates.Coordinates;

public interface AircraftMoveUpdateStrategy {
    public void update(Coordinates coordinates);
}
