package kr.ft.avaj.simulator.Core;

import kr.ft.avaj.simulator.Parser.ParsedDataDTO;

public abstract class Engine {
    public static Engine initilize(ParsedDataDTO parsedDataDTO) {
        return new EngineCore(parsedDataDTO);
    }

    public abstract void run();
}