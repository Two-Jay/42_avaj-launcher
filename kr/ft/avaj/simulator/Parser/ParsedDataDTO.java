package kr.ft.avaj.simulator.Parser;

import java.util.ArrayList;

import kr.ft.avaj.simulator.Aircraft.Flyable;

public class ParsedDataDTO {
    int simulationCount;
    ArrayList<Flyable> aircrafts;

    public ParsedDataDTO(int simulationCount, ArrayList<Flyable> aircrafts) {
        this.simulationCount = simulationCount;
        this.aircrafts = aircrafts;
    }

    public int getSimulationCount() {
        return simulationCount;
    }

    public ArrayList<Flyable> getAircrafts() {
        return aircrafts;
    }
}
