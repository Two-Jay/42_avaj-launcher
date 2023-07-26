package kr.ft.avaj.simulator;

import kr.ft.avaj.simulator.Core.Engine;
import kr.ft.avaj.simulator.Parser.ParsedDataDTO;
import kr.ft.avaj.simulator.Parser.Parser;
import kr.ft.avaj.simulator.Printer.Printer;

public class main {

    public static ParsedDataDTO runParser(String filepath) throws Exception {
        Parser parser = Parser.getINSTANCE();
        return parser.parseFile(filepath);
    }

    public static void main(String[] args) {
        try {
            if (args.length != 1) {
                throw new Exception("Invalid number of arguments");
            }
            Engine.initilize(runParser(args[0]))
                    .run();
        } catch (Exception e) {
            System.err.println(e);
            Printer.getInstance().deleteFile();
            System.exit(1);
        }
    }
}