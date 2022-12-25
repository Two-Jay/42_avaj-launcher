package kr.ft.avaj.simulator;

import java.util.ArrayList;

public class Simulator {
    private static ArrayList<String> readFile(String path) {
        Parser parser = new Parser(path);
        return parser.parseSenarioFile();
    }

    private static ArrayList<Flyable> generateAircrafts(ArrayList<String> parsed) {
        AircraftFactory aircraftFactory = new AircraftFactory();
        ArrayList<Flyable> flyables = new ArrayList<Flyable>();

        for (String line : parsed) {
            String[] lineSplit = line.split(" ");
            String type = lineSplit[0];
            String name = lineSplit[1];
            int longitude = Integer.parseInt(lineSplit[2]);
            int latitude = Integer.parseInt(lineSplit[3]);
            int height = Integer.parseInt(lineSplit[4]);
            Flyable flyable = aircraftFactory.newAircraft(type, name, longitude, latitude, height);
            flyables.add(flyable);
        }
        return flyables;
    }
    
    private static int parseSimulationCount(ArrayList<String> parsed) {
        int simulationCount = Integer.parseInt(parsed.get(0));
        parsed.remove(0);
        return simulationCount;
    }

    public static void main(String[] args) {
        ArrayList<String> lines = readFile(args[0]);

        int simulationCount = parseSimulationCount(lines);
        ArrayList<Flyable> flyables = generateAircrafts(lines);
        Printer printer = Printer.getInstance();

        printer.setFilePath("simulation.txt");

        for (int i = 0; i < simulationCount; i++) {
            for (Flyable flyable : flyables) {
                flyable.updateConditions();
            }
        }
    }
};