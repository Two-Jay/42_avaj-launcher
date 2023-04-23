package kr.ft.avaj.simulator.Parser;

import java.util.Scanner;
import java.util.ArrayList;
import java.io.File;
import java.io.FileNotFoundException;

import kr.ft.avaj.simulator.Utils.SimulationMetaData;
import kr.ft.avaj.simulator.Aircraft.Flyable;
import kr.ft.avaj.simulator.Aircraft.Factory.AircraftFactory;
import kr.ft.avaj.simulator.Exception.InvalidSimulationCountException;

public class Parser implements ParserInterface {
    private SimulationMetaData metaData = new SimulationMetaData();
    private ParsedData data;

    public Parser(String filepath) {
        try {
            ArrayList<String> lines = readSenarioFile(filepath);
            int simulationCount = parseSimulationCount(lines);
            lines.remove(0);
            ArrayList<Flyable> aircrafts = parseAircrafts(lines);
            data = new ParsedData(simulationCount, aircrafts);
        } catch (InvalidSimulationCountException e) {
            System.err.println(e.getMessage());
            System.exit(1);
        } catch (FileNotFoundException e) {
            System.err.println("File not found: " + filepath);
            System.exit(1);
        } catch (Exception e) {
            System.err.println("Invalid simulation count");
            System.exit(1);
        }
    }

    private ArrayList<String> readSenarioFile(String filepath) throws FileNotFoundException {
        File opened = new File(filepath);
        Scanner scanner = new Scanner(opened);
        ArrayList<String> lines = new ArrayList<String>();
        while (scanner.hasNextLine()) {
            lines.add(scanner.nextLine());
        }
        scanner.close();
        return lines;
    }

    private int parseSimulationCount(ArrayList<String> lines) throws InvalidSimulationCountException {
        int baseIndex = this.metaData.simulationCountIndex;

        String[] splitted = lines.get(baseIndex).split(" ");
        if (splitted.length != 1) {
            throw new InvalidSimulationCountException(lines.get(baseIndex));
        }
        int simulationCount = Integer.parseInt(lines.get(0));
        if (simulationCount < 0) {
            throw new InvalidSimulationCountException(lines.get(baseIndex));
        }
        return simulationCount;
    }

    private Boolean isValidCoordinates(int longitude, int latitude, int height) {
        if (longitude < this.metaData.longitudeMinimum || longitude > this.metaData.longitudeMaximum) {
            return false;
        }
        if (latitude < this.metaData.latitudeMinimum || latitude > this.metaData.latitudeMaximum) {
            return false;
        }
        if (height < this.metaData.heightMinimum || height > this.metaData.heightMaximum) {
            return false;
        }
        return true;
    }

    private ArrayList<Flyable> parseAircrafts(ArrayList<String> lines) {
        ArrayList<Flyable> aircrafts = new ArrayList<Flyable>();
        AircraftFactory aircraftFactory = new AircraftFactory();

        for (String line : lines) {
            String[] splitted = line.split(" ");
            if (splitted.length != 5) {
                System.err.println("Invalid aircraft line: " + line);
                System.exit(1);
            }
            String type = splitted[0];
            String name = splitted[1];
            int longitude = Integer.parseInt(splitted[2]);
            int latitude = Integer.parseInt(splitted[3]);
            int height = Integer.parseInt(splitted[4]);
            if (isValidCoordinates(longitude, latitude, height) == false) {
                System.err.println("Invalid coordinates: " + line);
                System.exit(1);
            }
            Flyable aircraft = aircraftFactory.newAircraft(type, name, longitude, latitude, height);
            aircrafts.add(aircraft);
        }
        return aircrafts;
    }

    public ParsedData getParsedData() {
        return data;
    }
};