package kr.ft.avaj.simulator.Exception;

class InvalidCoordinatesException extends RuntimeException {
    public InvalidCoordinatesException(int longitude, int latitude, int height) {
        super(buildExceptionMessage(longitude, latitude, height));
    }

    private static String buildExceptionMessage(int longitude, int latitude, int height) {
        String inputInfo = buildCoordinatesForm(longitude, latitude, height);
        return "Exception : invalid coordinates." + inputInfo;
    }

    private static String buildCoordinatesForm(int longitude, int latitude, int height) {
        return "(" + longitude + ", " + latitude + ", " + height + ")";
    }
}
