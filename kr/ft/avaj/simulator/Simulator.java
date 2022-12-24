package kr.ft.avaj.simulator;

import java.util.Scanner;
import java.util.ArrayList;
import java.io.File;
import java.io.FileNotFoundException;

public class Simulator {
    private static ArrayList<String> readFile(String filepath) throws FileNotFoundException {
        File file = new File(filepath);
        Scanner scanner = new Scanner(file);
        System.err.println("Reading file: " + filepath);
        ArrayList<String> lines = new ArrayList<String>();

        while (scanner.hasNextLine()) {
            lines.add(scanner.nextLine());
        }
        scanner.close();

        for (String line : lines) {
            System.err.println(line);
        }
        return lines;
    }

    public static void main(String[] args) {
        try {
            ArrayList<String> lines = readFile(args[0]);
        } catch (FileNotFoundException e) {
            System.err.println("File not found: " + args[0]);
            System.exit(1);
        }
    }
};