package kr.ft.avaj.simulator.Printer.Logger;

import kr.ft.avaj.simulator.Printer.Printer;

public class Logger {
    private static Printer printer = Printer.getInstance();

    public Logger() {
    }

    protected void log(String message) {
        printer.printToFile(message);
    }
}
