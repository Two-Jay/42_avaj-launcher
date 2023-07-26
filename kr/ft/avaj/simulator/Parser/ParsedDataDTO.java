package kr.ft.avaj.simulator.Parser;

import java.util.ArrayList;

public class ParsedDataDTO {
    int simulationRepeatCount;
    ArrayList<AircraftInfo> AircraftInfos;

    public ParsedDataDTO(int simulationCount, ArrayList<AircraftInfo> aircrafts) {
        this.simulationRepeatCount = simulationCount;
        this.AircraftInfos = aircrafts;
    }

    public int getSimulationCount() {
        return simulationRepeatCount;
    }

    public ArrayList<AircraftInfo> getAircraftInfos() {
        return this.AircraftInfos;
    }
}
