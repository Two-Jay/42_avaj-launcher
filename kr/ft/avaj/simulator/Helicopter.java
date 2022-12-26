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
                this.coordinates.setLongitude(this.coordinates.getLongitude());
                this.coordinates.setLatitude(this.coordinates.getLatitude() + 10);
                this.coordinates.setHeight(this.coordinates.getHeight() + 2);
                break;
            case "RAIN":
                this.coordinates.setLongitude(this.coordinates.getLongitude());
                this.coordinates.setLatitude(this.coordinates.getLatitude() + 5);
                this.coordinates.setHeight(this.coordinates.getHeight());
                break;
            case "FOG":
                this.coordinates.setLongitude(this.coordinates.getLongitude());
                this.coordinates.setLatitude(this.coordinates.getLatitude() + 1);
                this.coordinates.setHeight(this.coordinates.getHeight());
                break;
            case "SNOW":
                this.coordinates.setLongitude(this.coordinates.getLongitude());
                this.coordinates.setLatitude(this.coordinates.getLatitude());
                this.coordinates.setHeight(this.coordinates.getHeight() - 12);
                break;
        }
    }

    protected String getMessageByWeather(String weather) {
        switch (weather) {
            case "RAIN":
                return "It's raining. Better watch out for lightings.";
            case "FOG":
                return "It's foggy. Be careful not to crash.";
            case "SUN":
                return "This is hot.";
            case "SNOW":
                return "My rotor is going to freeze!";
            default:
                return "Unknown weather.";
        }
    }

    public void registerTower(WeatherTower weatherTower) {
        weatherTower.register(this);
    }

    public Coordinates getCoordinates() {
        return this.coordinates;
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
