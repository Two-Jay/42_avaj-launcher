package kr.ft.avaj.simulator.Core.Aircraft.Coordinates;

import kr.ft.avaj.simulator.Exception.UnsupportedWeatherException;

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

    public static WEATHER of(String weather) throws UnsupportedWeatherException {
        for (WEATHER w : WEATHER.values()) {
            if (w.getWeather().equals(weather)) {
                return w;
            }
        }
        throw new UnsupportedWeatherException();
    }

    public String toString() {
        return weather;
    }
}
