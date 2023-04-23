package kr.ft.avaj.simulator.Simulator;

import java.util.ArrayList;

import kr.ft.avaj.simulator.Aircraft.Flyable;
import kr.ft.avaj.simulator.Aircraft.Coordinates.Coordinates;
import kr.ft.avaj.simulator.Parser.*;
import kr.ft.avaj.simulator.Utils.*;
import kr.ft.avaj.simulator.WeatherTower.WeatherTower;

public class Simulator {
    private static SimulationMetaData metaData = new SimulationMetaData();
    private ParserInterface parser;
    private ParsedData parsedData;

    public Simulator(String filePath) {
        parser = new Parser(filePath);
        parsedData = parser.getParsedData();
    }

    private Boolean isNeededToDetach(Flyable aircraft) {
        Coordinates current = aircraft.getCoordinates();

        return current.getHeight() <= metaData.heightMinimum
                || current.getLatitude() < metaData.latitudeMinimum
                || current.getLongitude() < metaData.longitudeMinimum
                || current.getLongitude() >= metaData.longitudeMaximum
                || current.getLatitude() >= metaData.latitudeMaximum;
    }

    public void run() {
        Printer.getInstance().setFilepath("simulation.txt");
        WeatherTower weatherTower = new WeatherTower();
        int simulationCount = parsedData.getSimulationCount();
        ArrayList<Flyable> aircrafts = parsedData.getAircrafts();

        System.out.println("Simulation count: " + parsedData.getSimulationCount());
        System.out.println("Aircrafts: " + aircrafts.size());

        for (Flyable aircraft : aircrafts) {
            aircraft.registerTower(weatherTower);
        }

        for (int i = 0; i < simulationCount; i++) {
            weatherTower.changeWeather();
            ArrayList<Flyable> flyables = weatherTower.getObservers();
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
