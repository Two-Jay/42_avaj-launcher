package kr.ft.avaj.simulator.Parser.AircraftInfo;

public class AircraftInfo {
    public String type;
    public String name;
    public int longitude;
    public int latitude;
    public int height;

    public String getType() {
        return this.type;
    }

    public String getName() {
        return this.name;
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

    private AircraftInfo(Builder builder) {
        this.type = builder.type;
        this.name = builder.name;
        this.longitude = builder.longitude;
        this.latitude = builder.latitude;
        this.height = builder.height;
    }

    public static class Builder implements AircraftInfoBuilder {
        private String type;

        private String name;

        private int longitude;

        private int latitude;

        private int height;

        @Override
        public AircraftInfoBuilder setType(String type) {
            this.type = type;
            return this;
        }

        @Override
        public AircraftInfoBuilder setName(String name) {
            this.name = name;
            return this;
        }

        @Override
        public AircraftInfoBuilder setLongitude(int longitude) {
            this.longitude = longitude;
            return this;
        }

        @Override
        public AircraftInfoBuilder setLatitude(int latitude) {
            this.latitude = latitude;
            return this;
        }

        @Override
        public AircraftInfoBuilder setHeight(int height) {
            this.height = height;
            return this;
        }

        @Override
        public AircraftInfo build() {
            return new AircraftInfo(this);
        }
    }
}
