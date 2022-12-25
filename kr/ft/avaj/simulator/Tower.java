package kr.ft.avaj.simulator;

import java.util.ArrayList;

public class Tower {
    private ArrayList<Flyable> observers = new ArrayList<Flyable>();

    public void register(Flyable flyable) {
        this.observers.add(flyable);
    }

    public void unregister(Flyable flyable) {
        this.observers.remove(flyable);
    }

    protected void conditionsChanged() {
        for (Flyable flyable : this.observers) {
            flyable.updateConditions();
        }
    }
}
