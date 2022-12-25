package kr.ft.avaj.simulator;

import java.util.ArrayList;

public class Field {
    int height;
    int width;
    ArrayList<ArrayList<String>> FieldInfo = new ArrayList<ArrayList<String>>();

    Field(int height, int width, String[] weather) {
        this.height = height;
        this.width = width;
    
        this.updateWeather(weather);
    }

    public void updateWeather(String[] weather) {
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

    public void updateField(Coordinates coordinates, String weather) {
        this.FieldInfo.get(coordinates.getLongitude()).set(coordinates.getLatitude(), weather);
    }

    public String getWeather(int x, int y) {
        return FieldInfo.get(x).get(y);
    }

    public String getWeather(Coordinates coordinates) {
        return FieldInfo.get(coordinates.getLongitude()).get(coordinates.getLatitude());
    }

    public void printWeather() {
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                System.out.print(this.getWeather(j, i) + " ");
            }
            System.out.println();
        }
    }
}