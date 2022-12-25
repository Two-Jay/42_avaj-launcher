package kr.ft.avaj.simulator;

public class JetPlane extends Aircraft implements Flyable {
    String type;
    String capitalType;

    public JetPlane(String name, Coordinates coordinates) {
        super(name, coordinates);
        this.type = "JetPlane";
        this.capitalType = "J";
    }

    public void updateConditions() {
    }

    // public void registerTower(WeatherTower weatherTower) {
    // }

    private String buildSpeakMessage() {
        return this.type + "#" + this.name + "(" + this.id + "): " + this.getByWeather(WeatherProvider.getCurrentWeather(this.coordinates)) 
            + " (" + this.coordinates.getLongitude() + ", " + this.coordinates.getLatitude() + ", " + this.coordinates.getHeight() + ")";
    }

    public void speak() {
        Printer.printToFile(buildSpeakMessage());
    }
}