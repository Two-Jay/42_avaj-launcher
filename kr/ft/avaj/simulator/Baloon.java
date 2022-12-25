package kr.ft.avaj.simulator;

public class Baloon extends Aircraft implements Flyable {
    String type;
    String capitalType;

    public Baloon(String name, Coordinates coordinates) {
        super(name, coordinates);
        this.type = "Baloon";
        this.capitalType = "B";
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
