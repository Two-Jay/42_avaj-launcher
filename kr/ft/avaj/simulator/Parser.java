package kr.ft.avaj.simulator;

import java.util.Scanner;
import java.util.ArrayList;
import java.io.File;

public class Parser {
    File file;
    
    Parser (String filepath) {
        try {
            this.file = new File(filepath);
        } catch (Exception e) {
            System.err.println("File not found: " + filepath);
            System.exit(1);
        }
    }

    public ArrayList<String> parseSenarioFile() {
        try {
            Scanner scanner = new Scanner(file);
            ArrayList<String> lines = new ArrayList<String>();
    
            while (scanner.hasNextLine()) {
                lines.add(scanner.nextLine());
            }
    
            scanner.close();
            return lines;
        } catch (Exception e) {
            System.err.println("File not found: " + file);
            System.exit(1);
        }
        return null;
    }
};