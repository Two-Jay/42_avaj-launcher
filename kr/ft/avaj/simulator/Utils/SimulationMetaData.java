package kr.ft.avaj.simulator.Utils;

public class SimulationMetaData {
    private SimulationMetaData() {
    }

    public static SimulationMetaData getInstance() {
        return DataHolder.INSTANCE;
    }

    private static class DataHolder {
        private static final SimulationMetaData INSTANCE = new SimulationMetaData();
    }

    public final int simulationCountIndex = 0;
    public final long latitudeMinimum = 0;
    public final long latitudeMaximum = 9999;
    public final long longitudeMinimum = 0;
    public final long longitudeMaximum = 9999;
    public final int heightMinimum = 0;
    public final int heightMaximum = 100;
}
