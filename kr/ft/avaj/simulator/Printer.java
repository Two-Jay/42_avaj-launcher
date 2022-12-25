package kr.ft.avaj.simulator;

import java.io.FileWriter;
import java.io.File;

public class Printer {
    private static String filepath;

    private Printer() {}

    public static Printer getInstance() {
        return Holder.INSTANCE;
    }

    private static class Holder {
        private static final Printer INSTANCE = new Printer();
    }

    public static void setFilePath(String filepath) {
        Printer.filepath = filepath;
        File f = new File(Printer.filepath);
        if (f.exists()) {
            f.delete();
        } else {
            try {
                f.createNewFile();
            } catch (Exception e) {
                System.err.println("File not found: " + filepath);
                System.exit(1);
            }
        }
    }

    public static void printToFile(String message) {
        FileWriter writer = null;

        try {
            writer = new FileWriter(filepath, true);
            writer.write(message);
            writer.write(System.lineSeparator());
            writer.close();
        } catch (Exception e) {
            System.err.println("File not found: " + filepath);
            System.exit(1);
        }
    }
}
