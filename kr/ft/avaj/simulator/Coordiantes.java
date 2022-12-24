package kr.ft.avaj.simulator;

public class Coordiantes {
    int longitude;
    int latitude;
    int height;
    
    Coordiantes(int longitude, int latitude, int height) {
        this.longitude = longitude;
        this.latitude = latitude;
        this.height = height;
    }

    public int getLongitude() {
        return this.longitude;
    }

    public int getLatitude() {
        return this.latitude;
    }

    public int getHeight() {
        return this.height;
    }
}
