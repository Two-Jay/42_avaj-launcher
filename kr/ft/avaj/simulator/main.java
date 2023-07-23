package kr.ft.avaj.simulator;

import kr.ft.avaj.simulator.Parser.ParsedDataDTO;
import kr.ft.avaj.simulator.Parser.Parser;
import kr.ft.avaj.simulator.Parser.ParserImpl;
import kr.ft.avaj.simulator.Parser.AircraftInfo.AircraftInfo;

public class main {

    public static void runParser(String filepath) {
        try {
            ParsedDataDTO dto = ParserImpl.getINSTANCE().parseFile(filepath);
            System.out.println(dto.getSimulationCount());
            for (int i = 0; i < dto.getAircrafts().size(); i++) {
                AircraftInfo aircraftInfo = dto.getAircrafts().get(i);
                System.out.println(aircraftInfo.getType() + " " + aircraftInfo.getName() + " "
                        + aircraftInfo.getLongitude() + " " + aircraftInfo.getLatitude() + " "
                        + aircraftInfo.getHeight());
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void main(String[] args) {
        runParser(args[0]);
    }
}