package kr.ft.avaj.simulator.Parser;

import java.util.Scanner;
import java.util.ArrayList;
import java.io.File;
import java.io.FileNotFoundException;
import kr.ft.avaj.simulator.Utils.SimulationMetaData;
import kr.ft.avaj.simulator.Aircraft.Flyable;

public class ParserImpl implements Parser {

    private ParserImpl() {

    }

    public static ParserImpl getInstance() {
        return Holder.INSTANCE;
    }

    private static class Holder {
        private static final ParserImpl INSTANCE = new ParserImpl();
    }

    public void setFilePath(String filePath) {

    }

    public void parseFile() throws Exception {

    }
}