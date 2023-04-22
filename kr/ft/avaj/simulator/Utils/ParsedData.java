package kr.ft.avaj.simulator.Utils;

import java.util.ArrayList;

import kr.ft.avaj.simulator.Aircraft.Flyable;

public class ParsedData {
    int simulationCount;
    ArrayList<Flyable> aircrafts;

    public ParsedData(int simulationCount, ArrayList<Flyable> aircrafts) {
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
