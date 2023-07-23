package kr.ft.avaj.simulator.Parser;

import java.util.ArrayList;

import kr.ft.avaj.simulator.Parser.AircraftInfo.AircraftInfo;

public class ParsedDataDTO {
    int simulationCount;
    ArrayList<AircraftInfo> aircrafts;

    public ParsedDataDTO(int simulationCount, ArrayList<AircraftInfo> aircrafts) {
        this.simulationCount = simulationCount;
        this.aircrafts = aircrafts;
    }

    public int getSimulationCount() {
        return simulationCount;
    }

    public ArrayList<AircraftInfo> getAircrafts() {
        return aircrafts;
    }
}
