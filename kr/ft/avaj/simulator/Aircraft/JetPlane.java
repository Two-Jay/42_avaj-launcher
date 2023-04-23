package kr.ft.avaj.simulator.Aircraft;

import kr.ft.avaj.simulator.Aircraft.Coordinates.Coordinates;
import kr.ft.avaj.simulator.Aircraft.MessageBuilder.JetPlaneMessageBuilder;
import kr.ft.avaj.simulator.Aircraft.UpdateStrategy.JetPlaneMoveUpdateStrategy;

import kr.ft.avaj.simulator.Utils.Printer;
import kr.ft.avaj.simulator.WeatherTower.WeatherTower;
import kr.ft.avaj.simulator.WeatherProvider.WeatherProvider;

public class JetPlane extends Aircraft implements Flyable {
    public JetPlane(String name, Coordinates coordinates) {
        super(name, coordinates);
        this.type = "JetPlane";
        this.messageBuilder = new JetPlaneMessageBuilder(this);
        this.moveUpdateStrategy = new JetPlaneMoveUpdateStrategy();
    }

    public void updateConditions() {
        this.speak();
        this.moveUpdateStrategy.update(this.coordinates);
    }

    public void registerTower(WeatherTower weatherTower) {
        weatherTower.register(this);
    }

    public void land(WeatherTower weatherTower) {
        weatherTower.unregister(this);
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