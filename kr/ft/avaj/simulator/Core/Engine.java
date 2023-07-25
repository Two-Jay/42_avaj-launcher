package kr.ft.avaj.simulator.Core;

import kr.ft.avaj.simulator.Parser.ParsedDataDTO;
import kr.ft.avaj.simulator.Printer.Printer;

public abstract class Engine {
    public static Engine initilize(ParsedDataDTO parsedDataDTO) {
        Printer.getInstance().setFilepath("simulation.txt");
        return new EngineCore(parsedDataDTO);
    }

    public abstract void run();
}