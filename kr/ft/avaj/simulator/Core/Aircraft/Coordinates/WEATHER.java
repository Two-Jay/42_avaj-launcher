package kr.ft.avaj.simulator.Core.Aircraft.Coordinates;

public enum WEATHER {
    SUN("SUN"),
    RAIN("RAIN"),
    FOG("FOG"),
    SNOW("SNOW");

    private String weather;

    WEATHER(String weather) {
        this.weather = weather;
    }

    public String getWeather() {
        return weather;
    }

    public static WEATHER of(String weather) {
        for (WEATHER w : WEATHER.values()) {
            if (w.getWeather().equals(weather)) {
                return w;
            }
        }
        return null;
    }

    public String toString() {
        return weather;
    }
}
