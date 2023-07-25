package kr.ft.avaj.simulator.Printer.Logger;

import kr.ft.avaj.simulator.Core.Aircraft.Flyable;

enum TOWER_MESSAGE_FORMAT {
    REGISTER("Tower says: %s registered to weather tower."),
    UNREGISTER("Tower says: %s unregistered from weather tower.");

    private String message;

    TOWER_MESSAGE_FORMAT(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public String getMessage(Flyable flyable) {
        return String.format(message, flyable);
    }
}

public class WeatherTowerLogger extends Logger {
    private WeatherTowerLogger() {
    }

    public static WeatherTowerLogger getInstance() {
        return WeatherTowerLoggerHolder.instance;
    }

    public static class WeatherTowerLoggerHolder {
        public static final WeatherTowerLogger instance = new WeatherTowerLogger();
    }

    public void logRegister(Flyable flyable) {
        log(TOWER_MESSAGE_FORMAT.REGISTER.getMessage(flyable));
    }

    public void logUnregister(Flyable flyable) {
        log(TOWER_MESSAGE_FORMAT.UNREGISTER.getMessage(flyable));
    }
}
