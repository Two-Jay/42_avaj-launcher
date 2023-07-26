package kr.ft.avaj.simulator.Printer;

import java.io.FileWriter;
import java.io.File;

public class Printer {
    private static String filepath;

    private Printer() {
    }

    public static Printer getInstance() {
        return Holder.INSTANCE;
    }

    private static class Holder {
        private static final Printer INSTANCE = new Printer();
    }

    public void setFilepath(String filepath) {
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

    public void printToFile(String message) {
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

    public void deleteFile() {
        if (filepath == null) {
            return;
        }
        File file = new File(filepath);
        file.delete();
    }
}