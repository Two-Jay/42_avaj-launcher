package kr.ft.avaj.simulator.Aircraft.UpdateStrategy;

import kr.ft.avaj.simulator.Aircraft.Coordinates.Coordinates;

public abstract class AircraftMoveUpdateStrategy implements AircraftMoveUpdateStrategyInterface {
    public void addToCoordinates(Coordinates coordinates, int addToLongitude, int addToLatitude, int addToHeight) {
        coordinates.setLongitude(coordinates.getLongitude() + addToLongitude);
        coordinates.setLatitude(coordinates.getLatitude() + addToLatitude);
        coordinates.setHeight(coordinates.getHeight() + addToHeight);
    }
}
