package kr.ft.avaj.simulator;

public interface Flyable {
    public abstract void updateConditions();
    public abstract void registerTower(WeatherTower weatherTower);

    public abstract String buildAircraftBarcode();
    public abstract Coordinates getCoordinates();
    public abstract void speak();
}
