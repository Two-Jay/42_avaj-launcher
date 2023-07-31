package kr.ft.avaj.simulator.Core.Tower;

import java.util.List;
import java.util.ArrayList;
import kr.ft.avaj.simulator.Core.Aircraft.Flyable;
import kr.ft.avaj.simulator.Printer.Logger.WeatherTowerLogger;

public class Tower {
    List<Flyable> observers;

    public Tower() {
        observers = new ArrayList<Flyable>();
    }

    protected void conditionsChanged() {
        for (int i = 0; i < observers.size(); i++) {
            observers.get(i).updateConditions();
        }
    }

    public void register(Flyable flyable) {
        observers.add(flyable);
        WeatherTowerLogger.getInstance().logRegister(flyable);
    }

    public void unregister(Flyable flyable) {
        observers.remove(flyable);
        WeatherTowerLogger.getInstance().logUnregister(flyable);
    }
}
