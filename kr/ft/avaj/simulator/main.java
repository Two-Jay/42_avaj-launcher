package kr.ft.avaj.simulator;

import kr.ft.avaj.simulator.Core.Engine;
import kr.ft.avaj.simulator.Parser.ParsedDataDTO;
import kr.ft.avaj.simulator.Parser.Parser;

public class Main {

    public static ParsedDataDTO runParser(String filepath) throws Exception {
        Parser parser = Parser.getINSTANCE();
        return parser.parseFile(filepath);
    }

    public static void main(String[] args) {
        try {
            Engine.initilize(runParser(args[0])).run();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.exit(1);
        }
    }
}