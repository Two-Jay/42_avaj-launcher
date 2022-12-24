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
    // }s

    private String buildSpeakMessage() {
        return this.type + "#" + this.name + "(" + this.capitalType + this.id + "): " + this.getByWeather(WeatherProvider.getCurrentWeather(this.coordinates)) 
            + " (" + this.coordinates.getLongitude() + ", " + this.coordinates.getLatitude() + ", " + this.coordinates.getHeight() + ")" + "\n";
    }

    public void speak() {
        System.out.println(buildSpeakMessage());
    }
}
