package kr.ft.avaj.simulator.Core;

import kr.ft.avaj.simulator.Parser.ParsedDataDTO;

public class EngineCore implements Engine {
    private Integer simulationCount;

    private EngineCore(ParsedDataDTO parsedDataDTO) {
        this.simulationCount = parsedDataDTO.getSimulationCount();
    }

    public Engine initilize(ParsedDataDTO parsedDataDTO) {
        return new EngineCore(parsedDataDTO);
    }

    public void run() {
        for (int i = 0; i < this.simulationCount; i++) {
            System.out.println("Simulation " + i);
        }
    }
}
