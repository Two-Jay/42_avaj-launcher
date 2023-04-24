package kr.ft.avaj.simulator.Aircraft;

import kr.ft.avaj.simulator.Aircraft.Coordinates.Coordinates;
import kr.ft.avaj.simulator.Aircraft.MessageBuilder.HelicopterMessageBuilder;
import kr.ft.avaj.simulator.Aircraft.UpdateStrategy.HelicopterMoveUpdateStrategy;

import kr.ft.avaj.simulator.WeatherTower.WeatherTower;
import kr.ft.avaj.simulator.Utils.Printer;

public class Helicopter extends Aircraft implements Flyable {
    public Helicopter(String name, Coordinates coordinates) {
        super(name, coordinates);
        this.type = "Helicopter";
        this.messageBuilder = new HelicopterMessageBuilder(this);
        this.moveUpdateStrategy = new HelicopterMoveUpdateStrategy();
    }

    public void updateConditions() {
        this.speak(this.followTower);
        this.moveUpdateStrategy.update(this.coordinates, this.followTower);
    }

    public void registerTower(WeatherTower weatherTower) {
        this.followTower = weatherTower;
        weatherTower.register(this);
    }

    public void land(WeatherTower weatherTower) {
        this.followTower = null;
        weatherTower.unregister(this);
    }

    public Coordinates getCoordinates() {
        return this.coordinates;
    }

    public String getAircraftBarcode() {
        return this.messageBuilder.buildAircraftBarcode();
    }

    public void speak(WeatherTower weatherTower) {
        Printer p = Printer.getInstance();
        String weather = this.followTower.getWeather(this.coordinates);
        String reportMessage = this.messageBuilder.buildMessage(weather);

        p.printToFile(reportMessage);
    }
}
