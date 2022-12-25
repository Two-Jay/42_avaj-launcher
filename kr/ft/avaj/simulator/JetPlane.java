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
                    this.coordinates.getHeight() - 7
                );
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
                return "It's sunny. Let's enjoy the good weather and take some pics.";
            case "SNOW":
                return "OMG! Winter is coming!";
            default:
                return "Unknown weather.";
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