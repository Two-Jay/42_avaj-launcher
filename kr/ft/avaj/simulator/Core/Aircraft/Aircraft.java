package kr.ft.avaj.simulator.Core.Aircraft;

import kr.ft.avaj.simulator.Core.Aircraft.Coordinates.Coordinates;

public class Aircraft extends Flyable {
    protected long id;
    protected String type;
    protected String name;
    protected Coordinates coordinates;

    protected Aircraft(long id, String name, Coordinates coordinates) {
        this.id = id;
        this.type = this.getClass().getSimpleName();
        this.name = name;
        this.coordinates = coordinates;
    }

    @Override
    public void updateConditions() {
        throw new UnsupportedOperationException("Unimplemented method 'updateConditions'");
    }

    @Override
    public String toString() {
        return String.format("%s#%s(%d)", this.type, this.name, this.id);
    }
}
