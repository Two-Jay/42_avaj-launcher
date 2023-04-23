package kr.ft.avaj.simulator.WeatherProvider;

import java.util.ArrayList;
import kr.ft.avaj.simulator.Aircraft.Coordinates.Coordinates;

public class Field {
    long height;
    long width;
    ArrayList<ArrayList<String>> FieldInfo = new ArrayList<ArrayList<String>>();

    Field(long height, long width, String[] weather) {
        this.height = height;
        this.width = width;

        this.updateWeather(weather);
    }

    public void updateWeather(String[] weather) {
        this.FieldInfo.clear();
        for (int i = 0; i < height; i++) {
            ArrayList<String> row = new ArrayList<String>();
            for (int j = 0; j < width; j++) {
                row.add(generateRandomWeather(weather));
            }
            this.FieldInfo.add(row);
        }
    }

    private String generateRandomWeather(String[] weather) {
        int rand = (int) ((Math.random() * 10000) % weather.length);
        return weather[rand];
    }

    public String getWeather(int x, int y) {
        return FieldInfo.get(x).get(y);
    }

    public String getWeather(Coordinates coordinates) {
        return FieldInfo.get(coordinates.getLongitude()).get(coordinates.getLatitude());
    }
}