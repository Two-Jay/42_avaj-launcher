package kr.ft.avaj.simulator.Parser;

import java.util.ArrayList;

public class ParsedDataDTO {
    int simulationCount;
    ArrayList<AircraftInfo> AircraftInfos;

    public ParsedDataDTO(int simulationCount, ArrayList<AircraftInfo> aircrafts) {
        this.simulationCount = simulationCount;
        this.AircraftInfos = aircrafts;
    }

    public int getSimulationCount() {
        return simulationCount;
    }

    public ArrayList<AircraftInfo> getAircraftInfos() {
        return this.AircraftInfos;
    }
}
