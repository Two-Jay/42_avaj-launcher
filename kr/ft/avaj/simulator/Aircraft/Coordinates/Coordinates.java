package kr.ft.avaj.simulator.Aircraft.Coordinates;

import kr.ft.avaj.simulator.Utils.SimulationMetaData;

public class Coordinates {
    private int longitude;
    private int latitude;
    private int height;
    private int heightLimit;

    public Coordinates(int longitude, int latitude, int height) {
        this.longitude = longitude;
        this.latitude = latitude;
        SimulationMetaData metaData = new SimulationMetaData();
        this.heightLimit = metaData.heightMaximum;
        if (height > this.heightLimit) {
            this.height = this.heightLimit;
        } else {
            this.height = height;
        }
    }

    public void setLongitude(int longitude) {
        this.longitude = longitude;
    }

    public void setLatitude(int latitude) {
        this.latitude = latitude;
    }

    public void setHeight(int height) {
        this.height = height;
        if (this.height > this.heightLimit) {
            this.height = this.heightLimit;
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
