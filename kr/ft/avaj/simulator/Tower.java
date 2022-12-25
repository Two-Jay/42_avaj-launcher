package kr.ft.avaj.simulator;

import java.util.ArrayList;

public class Tower {
    private ArrayList<Flyable> observers = new ArrayList<Flyable>();
    Printer printer = Printer.getInstance();

    public void register(Flyable flyable) {
        printer.printToFile(buildRegisterMessage(flyable));
        this.observers.add(flyable);
    }

    public void unregister(Flyable flyable) {
        this.observers.remove(flyable);
    }

    private String buildRegisterMessage (Flyable flyable) {
        String message = "Tower says: " + flyable.buildAircraftBarcode() + " registered to weather tower.";
        return message;
    }

    protected void conditionsChanged() {
        for (Flyable flyable : this.observers) {
            flyable.updateConditions();
        }
    }
}
