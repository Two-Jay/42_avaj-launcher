package kr.ft.avaj.simulator.Simulator;

import java.util.ArrayList;

import kr.ft.avaj.simulator.Aircraft.Flyable;
import kr.ft.avaj.simulator.Aircraft.Coordinates.Coordinates;
import kr.ft.avaj.simulator.Aircraft.Factory.AircraftFactory;
import kr.ft.avaj.simulator.Parser.*;
import kr.ft.avaj.simulator.Utils.*;
import kr.ft.avaj.simulator.WeatherTower.WeatherTower;

public class Simulator {
    SimulationMetaData simulationMetaData = new SimulationMetaData();
    ParserInterface parser;
    AircraftFactory aircraftFactory;
    int simulationCount;
    ArrayList<Flyable> aircrafts;

    public Simulator(String filePath) {
        parser = new Parser(filePath);
        aircraftFactory = new AircraftFactory();

        ParsedData parsedData = parser.getParsedData();
        this.simulationCount = parsedData.getSimulationCount();
        this.aircrafts = parsedData.getAircrafts();
        System.out.println("Simulation count: " + parsedData.getSimulationCount());
        System.out.println("Aircrafts: " + aircrafts.size());
    }

    private Boolean isNeededToDetach(Flyable aircraft) {
        Coordinates current = aircraft.getCoordinates();

        return current.getHeight() <= simulationMetaData.heightMinimum
                || current.getLatitude() < simulationMetaData.latitudeMinimum
                || current.getLongitude() < simulationMetaData.longitudeMinimum
                || current.getLongitude() >= simulationMetaData.longitudeMaximum
                || current.getLatitude() >= simulationMetaData.latitudeMaximum;
    }

    public void run() {
        Printer.getInstance().setFilePath("simulation.txt");
        WeatherTower weatherTower = new WeatherTower();

        for (Flyable aircraft : aircrafts) {
            aircraft.registerTower(weatherTower);
        }

        for (int i = 0; i < simulationCount; i++) {
            weatherTower.changeWeather();
            ArrayList<Flyable> flyables = weatherTower.getFlyables();
            for (int j = 0; j < flyables.size(); j++) {
                Flyable aircraft = flyables.get(j);
                aircraft.updateConditions();
                if (isNeededToDetach(aircraft)) {
                    aircraft.land(weatherTower);
                }
            }
        }

    }
}
