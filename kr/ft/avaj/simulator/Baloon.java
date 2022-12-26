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
                this.coordinates.setLongitude(this.coordinates.getLongitude());
                this.coordinates.setLatitude(this.coordinates.getLatitude() + 2);
                this.coordinates.setHeight(this.coordinates.getHeight() + 4);
                break;
            case "RAIN":
                this.coordinates.setLongitude(this.coordinates.getLongitude());
                this.coordinates.setLatitude(this.coordinates.getLatitude());
                this.coordinates.setHeight(this.coordinates.getHeight() - 5);
                break;
            case "FOG":
                this.coordinates.setLongitude(this.coordinates.getLongitude());
                this.coordinates.setLatitude(this.coordinates.getLatitude());
                this.coordinates.setHeight(this.coordinates.getHeight() - 3);
                break;
            case "SNOW":
                this.coordinates.setLongitude(this.coordinates.getLongitude());
                this.coordinates.setLatitude(this.coordinates.getLatitude());
                this.coordinates.setHeight(this.coordinates.getHeight() - 15);
                break;
        }
    }

    protected String getMessageByWeather(String weather) {
        switch (weather) {
            case "RAIN":
                return "Damn you rain! You messed up my baloon.";
            case "FOG":
                return "I can't see anything!. We are going down.";
            case "SUN":
                return "Let's enjoy the good weather and take some pics.";
            case "SNOW":
                return "It's snowing. We're gonsna crash.";
            default:
                return "Unknown weather";
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
