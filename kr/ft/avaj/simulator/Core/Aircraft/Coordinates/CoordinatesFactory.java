package kr.ft.avaj.simulator.Core.Aircraft.Coordinates;

public class CoordinatesFactory {
    public static Coordinates create(int longitude, int latitude, int height) {
        return new Coordinates(longitude, latitude, height);
    }
}
