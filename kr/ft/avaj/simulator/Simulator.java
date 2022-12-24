package kr.ft.avaj.simulator;

import java.util.ArrayList;


public class Simulator {

    private static ArrayList<String> readFile(String path) {
        Parser parser = new Parser(path);
        return parser.parseSenarioFile();
    }

    public static void main(String[] args) {
        ArrayList<String> lines = readFile(args[0]);

        for (String line : lines) {
            System.out.println(line);
        }
    }
};