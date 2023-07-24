package kr.ft.avaj.simulator.Core.Aircraft;

import kr.ft.avaj.simulator.Core.Coordinates.Coordinates;

public class Aircraft {
    protected long id;
    protected String name;
    protected Coordinates coordinates;

    protected Aircraft(long id, String name, Coordinates coordinates) {
        this.id = id;
        this.name = name;
        this.coordinates = coordinates;
    }
}
