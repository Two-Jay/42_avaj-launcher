package kr.ft.avaj.simulator.Aircraft;

import kr.ft.avaj.simulator.Aircraft.MessageBuilder.AircraftMessageBuilder;
import kr.ft.avaj.simulator.Aircraft.UpdateStrategy.AircraftMoveUpdateStrategyInterface;
import kr.ft.avaj.simulator.Aircraft.Coordinates.Coordinates;

public abstract class Aircraft {
    protected long id;
    protected String name;
    protected String type;
    protected Coordinates coordinates;
    private static long idCounter = 0;
    protected AircraftMessageBuilder messageBuilder;
    protected AircraftMoveUpdateStrategyInterface moveUpdateStrategy;

    protected Aircraft(String name, Coordinates coordinates) {
        this.name = name;
        this.coordinates = coordinates;
        this.id = nextId();
    }

    private long nextId() {
        return ++idCounter;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public Coordinates getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(Coordinates coordinates) {
        this.coordinates = coordinates;
    }

    public abstract void speak();
}
