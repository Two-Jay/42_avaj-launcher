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

    public void register(Flyable[] flyable) {
        for (Flyable f : flyable) {
            observers.add(f);
        }
    }

    public void unregister(Flyable[] flyable) {
        for (Flyable f : flyable) {
            observers.remove(f);
        }
    }
}
