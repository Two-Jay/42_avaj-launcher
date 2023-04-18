package kr.ft.avaj.simulator.Aircraft.MessageBuilder;

import kr.ft.avaj.simulator.Aircraft.Coordinates.Coordinates;

public class CoordinatesMessageBuilder {
    String code;

    public CoordinatesMessageBuilder(Coordinates coordinates) {
        this.setCode(coordinates);
    }

    public String getCode() {
        return code;
    }

    public void setCode(Coordinates coordinates) {
        code = this.BuildCoordinatesForm(coordinates);
    }

    public String BuildCoordinatesForm(Coordinates coordinates) {
        return String.format(
                "(%d, %d, %d)",
                coordinates.getLongitude(),
                coordinates.getLatitude(),
                coordinates.getHeight());
    }
}
