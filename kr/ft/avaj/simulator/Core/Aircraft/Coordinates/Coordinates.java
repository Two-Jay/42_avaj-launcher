package kr.ft.avaj.simulator.Core.Aircraft.Coordinates;

public class Coordinates {
    private int longitude;
    private int latitude;
    private int height;
    private WEATHER weather;

    Coordinates(int longitude, int latitude, int height) {
        this.longitude = longitude;
        this.latitude = latitude;
        this.height = height;
        this.weather = WEATHER.SUN;
    }

    public int getLongitude() {
        return longitude;
    }

    public int getLatitude() {
        return latitude;
    }

    public int getHeight() {
        return height;
    }

    public WEATHER getWeather() {
        return weather;
    }

    public void setLongitude(int longitude) {
        this.longitude = longitude;
    }

    public void setLatitude(int latitude) {
        this.latitude = latitude;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public void setWeather(String weather) {
        this.weather = WEATHER.of(weather);
    }

    public void setWeather(WEATHER weather) {
        this.weather = weather;
    }

    public String toString() {
        return String.format("(%d LON, %d LAT %d HEI)", longitude, latitude, height);
    }
}
