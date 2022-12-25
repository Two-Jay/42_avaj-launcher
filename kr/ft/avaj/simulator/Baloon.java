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
        this.speak();

        WeatherProvider weatherProvider = WeatherProvider.getInstance();
        String weather = weatherProvider.getCurrentWeather(this.coordinates);

        switch (weather) {
            case "SUN":
                this.coordinates = new Coordinates(
                    this.coordinates.getLongitude(),
                    this.coordinates.getLatitude() + 2,
                    this.coordinates.getHeight() + 4
                );
                break;
            case "RAIN":
                this.coordinates = new Coordinates(
                    this.coordinates.getLongitude(),
                    this.coordinates.getLatitude(),
                    this.coordinates.getHeight() - 5
                );
                break;
            case "FOG":
                this.coordinates = new Coordinates(
                    this.coordinates.getLongitude(),
                    this.coordinates.getLatitude(),
                    this.coordinates.getHeight() - 3
                );
                break;
            case "SNOW":
                this.coordinates = new Coordinates(
                    this.coordinates.getLongitude(),
                    this.coordinates.getLatitude(),
                    this.coordinates.getHeight() - 15
                );
                break;
        }
    }

    public void registerTower(WeatherTower weatherTower) {
        weatherTower.register(this);
    }

    private String buildSpeakMessage() {
        return this.type + "#" + this.name + "(" + this.id + "): " + this.getByWeather(WeatherProvider.getCurrentWeather(this.coordinates)) 
            + " (" + this.coordinates.getLongitude() + ", " + this.coordinates.getLatitude() + ", " + this.coordinates.getHeight() + ")";
    }

    public void speak() {
        Printer p = Printer.getInstance();
        p.printToFile(buildSpeakMessage());
    }
}
