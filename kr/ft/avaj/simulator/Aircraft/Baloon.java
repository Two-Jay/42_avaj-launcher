package kr.ft.avaj.simulator.Aircraft;

import kr.ft.avaj.simulator.Aircraft.Coordinates.Coordinates;
import kr.ft.avaj.simulator.Aircraft.MessageBuilder.AircraftMessageBuilder;
import kr.ft.avaj.simulator.Aircraft.MessageBuilder.BaloonMessageBuilder;
import kr.ft.avaj.simulator.Aircraft.UpdateStrategy.AircraftMoveUpdateStrategyInterface;
import kr.ft.avaj.simulator.Aircraft.UpdateStrategy.BaloonMoveUpdateStrategy;

import kr.ft.avaj.simulator.Utils.Printer;
import kr.ft.avaj.simulator.WeatherTower.WeatherTower;
import kr.ft.avaj.simulator.WeatherProvider.WeatherProvider;

public class Baloon extends Aircraft implements Flyable {
    AircraftMessageBuilder messageBuilder;
    AircraftMoveUpdateStrategyInterface moveUpdateStrategy;

    public Baloon(String name, Coordinates coordinates) {
        super(name, coordinates);
        this.type = "Baloon";
        messageBuilder = new BaloonMessageBuilder(this);
        moveUpdateStrategy = new BaloonMoveUpdateStrategy();
    }

    public void updateConditions() {
        this.speak();
        this.moveUpdateStrategy.update(this.coordinates);
    }

    public void registerTower(WeatherTower weatherTower) {
        weatherTower.register(this);
    }

    public Coordinates getCoordinates() {
        return this.coordinates;
    }

    public String getAircraftBarcode() {
        return this.messageBuilder.buildAircraftBarcode();
    }

    public void speak() {
        Printer p = Printer.getInstance();
        String weather = WeatherProvider.getInstance().getCurrentWeather(this.coordinates);
        String reportMessage = this.messageBuilder.buildMessage(weather);

        p.printToFile(reportMessage);
    }
}
