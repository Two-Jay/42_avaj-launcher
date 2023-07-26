package kr.ft.avaj.simulator.Core;

import kr.ft.avaj.simulator.Parser.ParsedDataDTO;
import kr.ft.avaj.simulator.Printer.Printer;

public abstract class Engine {
    public static Engine initilize(ParsedDataDTO parsedDataDTO) {
        Printer.getInstance().setFilepath("simulation.txt");
        return new EngineCore(parsedDataDTO);
    }

    public void run() {
        try {
            this.runProcess();
        } catch (Exception e) {
            System.err.println(e);
            Printer.getInstance().deleteFile();
            System.exit(1);
        }
    }

    protected abstract void runProcess();
}