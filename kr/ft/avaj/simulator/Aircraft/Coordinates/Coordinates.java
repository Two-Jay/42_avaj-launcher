package kr.ft.avaj.simulator.Aircraft.Coordinates;

public class Coordinates {
    int longitude;
    int latitude;
    int height;
    int limit = 100;

    public Coordinates(int longitude, int latitude, int height) {
        this.longitude = longitude;
        this.latitude = latitude;
        this.height = height;
    }

    public void setLongitude(int longitude) {
        this.longitude = longitude;
    }

    public void setLatitude(int latitude) {
        this.latitude = latitude;
    }

    public void setHeight(int height) {
        this.height = height;
        if (this.height > this.limit) {
            this.height = this.limit;
        } else if (this.height < 0) {
            this.height = 0;
        }
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
