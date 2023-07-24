package kr.ft.avaj.simulator.Core.Tower;

import java.util.List;
import java.util.ArrayList;
import kr.ft.avaj.simulator.Core.Aircraft.Flyable;

public class Tower {
    List<Flyable> observers;

    public Tower() {
        observers = new ArrayList<Flyable>();
    }

    public void conditionsChanged() {
        for (Flyable f : observers) {
            f.updateConditions();
        }
    }

    public void register(Flyable flyable) {
        observers.add(flyable);
    }

    public void register(List<Flyable> flyables) {
        observers.addAll(flyables);
    }

    public void unregister(Flyable flyable) {
        observers.remove(flyable);
    }

    public void unregister(List<Flyable> flyables) {
        observers.removeAll(flyables);
    }
}
