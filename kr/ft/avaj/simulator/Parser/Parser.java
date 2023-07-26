package kr.ft.avaj.simulator.Parser;

import java.util.Scanner;
import java.util.ArrayList;
import kr.ft.avaj.simulator.Utils.SimulationMetaData;
import java.io.File;

public class Parser {
    private Parser() {
    }

    public static Parser getINSTANCE() {
        return Holder.INSTANCE;
    }

    private static class Holder {
        private static final Parser INSTANCE = new Parser();
    }

    public ParsedDataDTO parseFile(String filePath) throws Exception {
        Scanner sc = new Scanner(new File(filePath));
        ParsedDataDTO parsedDataDTO = new ParsedDataDTO(this.parseSimulationCount(sc),
                this.parseAircraftInformations(sc));
        return parsedDataDTO;
    }

    private Integer parseSimulationCount(Scanner sc) throws Exception {
        String[] tokens = sc.nextLine().split(" ");
        if (tokens.length != 1)
            throw new Exception("Invalid simulation count");
        return Integer.parseInt(tokens[SimulationMetaData.simulationCountIndex]);
    }

    private ArrayList<AircraftInfo> parseAircraftInformations(Scanner sc) throws Exception {
        ArrayList<AircraftInfo> aircrafts = new ArrayList<AircraftInfo>();
        while (sc.hasNextLine()) {
            String[] tokens = sc.nextLine().split(" ");
            aircrafts.add(initAircraftInfo(tokens));
        }
        return aircrafts;
    }

    private AircraftInfo initAircraftInfo(String[] tokens) throws Exception {
        if (tokens.length != 5)
            throw new Exception("Invalid aircraft data");
        AircraftInfo aircraftInfo = new AircraftInfo.Builder()
                .setType(tokens[0])
                .setName(tokens[1])
                .setLongitude(Integer.parseInt(tokens[2]))
                .setLatitude(Integer.parseInt(tokens[3]))
                .setHeight(Integer.parseInt(tokens[4]))
                .build();
        validateCoordinates(aircraftInfo.getLongitude(), aircraftInfo.getLatitude(), aircraftInfo.getHeight());
        return aircraftInfo;
    }

    private Boolean validateCoordinates(Integer longitude, Integer latitude, Integer height) {
        if (longitude < SimulationMetaData.longitudeMinimum
                || latitude < SimulationMetaData.latitudeMinimum
                || height < SimulationMetaData.latitudeMinimum)
            throw new IllegalArgumentException("Invalid coordinates");
        return true;
    }
}