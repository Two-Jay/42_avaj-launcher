package kr.ft.avaj.simulator.Core;

import kr.ft.avaj.simulator.Parser.ParsedDataDTO;

public interface Engine {
    public Engine initilize(ParsedDataDTO parsedDataDTO);

    public void run();
}