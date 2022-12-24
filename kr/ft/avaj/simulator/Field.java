package kr.ft.avaj.simulator;

import java.util.ArrayList;

enum Weather {
    RAIN, FOG, SUN, SNOW
}

public class Field {
    int height;
    int width;
    ArrayList< ArrayList<Weather>> weather = new ArrayList< ArrayList<Weather>>();
    
    Field(int height, int width) {
        this.height = height;
        this.width = width;
    
        for (int i = 0; i < height; i++) {
            ArrayList<Weather> row = new ArrayList<Weather>();
            for (int j = 0; j < width; j++) {
                row.add(Weather.SUN);
            }
            weather.add(row);
        }
    }

    public int getHeight() {
        return this.height;
    }

    public int getWidth() {
        return this.width;
    }

    public void printWeather() {
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                System.out.print(weather.get(i).get(j) + " ");
            }
            System.out.println();
        }
    }
}