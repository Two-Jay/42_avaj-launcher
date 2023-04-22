package kr.ft.avaj.simulator;

import kr.ft.avaj.simulator.Simulator.Simulator;

public class main {
    public static Boolean validateArgs(String[] args) {
        if (args.length != 1) {
            System.out.println("Exception : invalid number of arguments.");
            System.exit(1);
        }
        return true;
    }

    public static void main(String[] args) {
        if (validateArgs(args)) {
            Simulator simulator = new Simulator(args[0]);
            simulator.run();
        }
    }
}