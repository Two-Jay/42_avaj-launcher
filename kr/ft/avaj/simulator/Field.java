package kr.ft.avaj.simulator;

import java.util.ArrayList;

public class Field {
    int height;
    int width;
    ArrayList<ArrayList<String>> weather = new ArrayList<ArrayList<String>>();

    Field(int height, int width, String[] weather) {
        this.height = height;
        this.width = width;
    
        for (int i = 0; i < height; i++) {
            ArrayList<String> row = new ArrayList<String>();
            for (int j = 0; j < width; j++) {
                int rand = (int)(Math.random() * weather.length);
                row.add(weather[rand]);
            }
            this.weather.add(row);
        }
    }

    public int getHeight() {
        return this.height;
    }

    public int getWidth() {
        return this.width;
    }

    public String getWeather(int x, int y) {
        return weather.get(x).get(y);
    }

    public String getWeather(Coordinates coordinates) {
        return weather.get(coordinates.getLongitude()).get(coordinates.getLatitude());
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