package kr.ft.avaj.simulator;

public class Helicopter extends Aircraft implements Flyable {
    String type;
    String capitalType;

    public Helicopter(String name, Coordinates coordinates) {
        super(name, coordinates);
        this.type = "Helicopter";
        this.capitalType = "H";
    }
    
    public void updateConditions() {
    }

    // public void registerTower(WeatherTower weatherTower) {
    // }

    private String buildSpeakMessage() {
        return this.type + "#" + this.name + "(" + this.capitalType + this.id + "): " + this.getByWeather(WeatherProvider.getCurrentWeather(this.coordinates)) 
            + " (" + this.coordinates.getLongitude() + ", " + this.coordinates.getLatitude() + ", " + this.coordinates.getHeight() + ")" + "\n";
    }

    public void speak() {
        System.out.println(buildSpeakMessage());
    }
}

