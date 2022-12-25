package kr.ft.avaj.simulator;

class InvalidAircraftTypeException extends RuntimeException {
    public InvalidAircraftTypeException(String aircraftName) {
        super(buildExceptionMessage(aircraftName));
    }

    private static String buildExceptionMessage(String aircraftName) {
        return "Exception : invalid coordinates. (" + aircraftName + ")";
    }
}
