package kr.ft.avaj.simulator;

public class Aircraft {
    protected long id;
    protected String name;
    protected Coordinates coordinates;
    protected String type;
    private static long idCounter = 0;

    protected Aircraft(String name, Coordinates coordinates) {
        this.name = name;
        this.coordinates = coordinates;
        this.id = nextId();
    }

    private long nextId() {
        return ++idCounter;
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
                return "It's snowing. We're gonna crash.";
            default:
                return "Unknown weather.";
        }
    }
}
