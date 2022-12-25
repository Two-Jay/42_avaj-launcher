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
            try {
                String[] lineSplit = line.split(" ");
                if (lineSplit.length != 5) {
                    throw new InvalidArgumentException();
                }
                String type = lineSplit[0];
                String name = lineSplit[1];
                int longitude = Integer.parseInt(lineSplit[2]);
                int latitude = Integer.parseInt(lineSplit[3]);
                int height = Integer.parseInt(lineSplit[4]);
                if (isValidCoordinates(longitude, latitude, height) == false) {
                    throw new InvalidCoordinatesException(longitude, latitude, height);
                }
                Flyable flyable = aircraftFactory.newAircraft(type, name, longitude, latitude, height);
                flyables.add(flyable);
            } catch (InvalidCoordinatesException | InvalidArgumentException e) {
                System.out.println(e.getMessage());
                System.exit(1);
            } catch (NumberFormatException e) {
                System.out.println("Exception : invalid number format for coordinates. (" + line + ")");
                System.exit(1);
            }
        }
        return flyables;
    }
    
    private static int parseSimulationCount(ArrayList<String> parsed) {
        try {
            String[] lineSplit = parsed.get(0).split(" ");
            if (lineSplit.length != 1) {
                throw new InvalidSimulationCountException(parsed.get(0));
            }
            int simulationCount = Integer.parseInt(parsed.get(0));
            parsed.remove(0);
            return simulationCount;
        } catch (InvalidSimulationCountException e) {
            System.out.println(e.getMessage());
            System.exit(1);
        } catch (NumberFormatException e) {
            System.out.println("Exception : invalid simulation count. (" + parsed.get(0) + ")");
            System.exit(1);
        }
        return 0;
    }

    private static boolean isValidCoordinates(int longitude, int latitude, int height) {
        return longitude >= 0 && latitude >= 0 && height >= 0 && height <= 100 && latitude <= 300 && longitude <= 300;
    }

    private static boolean isNeededToUnregister(Flyable flyable) {
        return flyable.getCoordinates().getHeight() <= 0
            || flyable.getCoordinates().getLatitude() <= 0
            || flyable.getCoordinates().getLongitude() <= 0
            || flyable.getCoordinates().getLongitude() >= 300
            || flyable.getCoordinates().getLatitude() >= 300;
    }

    public static void main(String[] args) {
        Printer.getInstance().setFilePath("simulation.txt");
        WeatherTower weatherTower = new WeatherTower();

        if (args.length != 1) {
            System.out.println("Exception : invalid number of arguments.");
            System.exit(1);
        }
        ArrayList<String> lines = readFile(args[0]);
        int simulationCount = parseSimulationCount(lines);
        ArrayList<Flyable> flyables = generateAircrafts(lines);

        for (Flyable flyable : flyables) {
            flyable.registerTower(weatherTower);
        }

        for (int i = 0; i < simulationCount; i++) {
            weatherTower.changeWeather();
            for (Flyable flyable : flyables) {
                flyable.updateConditions();
                if (isNeededToUnregister(flyable)) {
                    weatherTower.unregister(flyable);
                }
            }
        }
    }
};