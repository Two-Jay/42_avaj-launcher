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
        this.speak();

        WeatherProvider weatherProvider = WeatherProvider.getInstance();
        String weather = weatherProvider.getCurrentWeather(this.coordinates);

        switch (weather) {
            case "SUN":
                this.coordinates = new Coordinates(
                    this.coordinates.getLongitude(),
                    this.coordinates.getLatitude() + 10,
                    this.coordinates.getHeight() + 2
                );
                break;
            case "RAIN":
                this.coordinates = new Coordinates(
                    this.coordinates.getLongitude(),
                    this.coordinates.getLatitude() + 5,
                    this.coordinates.getHeight()
                );
                break;
            case "FOG":
                this.coordinates = new Coordinates(
                    this.coordinates.getLongitude(),
                    this.coordinates.getLatitude() + 1,
                    this.coordinates.getHeight()
                );
                break;
            case "SNOW":
                this.coordinates = new Coordinates(
                    this.coordinates.getLongitude(),
                    this.coordinates.getLatitude(),
                    this.coordinates.getHeight() - 12
                );
                break;
        }
    }

    public void registerTower(WeatherTower weatherTower) {
        weatherTower.register(this);
    }

    private String buildSpeakMessage(String message) {
        return this.buildAircraftBarcode() + ": " + message + " " + this.buildAircraftCoordinatesMessage();
    }

    public String buildAircraftBarcode() {
        return this.type + "#" + this.name + "(" + this.id + ")";
    }

    public String buildAircraftCoordinatesMessage() {
        return "(" + this.coordinates.getLongitude() + ", " + this.coordinates.getLatitude() + ", " + this.coordinates.getHeight() + ")";
    }

    public void speak() {
        Printer p = Printer.getInstance();
        p.printToFile(buildSpeakMessage(this.getMessageByWeather(WeatherProvider.getCurrentWeather(this.coordinates))));
    }
}
