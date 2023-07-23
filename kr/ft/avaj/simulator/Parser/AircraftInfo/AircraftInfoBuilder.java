package kr.ft.avaj.simulator.Parser.AircraftInfo;

public interface AircraftInfoBuilder {
    public AircraftInfoBuilder setType(String type);

    public AircraftInfoBuilder setName(String name);

    public AircraftInfoBuilder setLongitude(int longitude);

    public AircraftInfoBuilder setLatitude(int latitude);

    public AircraftInfoBuilder setHeight(int height);

    public AircraftInfo build();
}
