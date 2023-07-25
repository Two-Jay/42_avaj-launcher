package kr.ft.avaj.simulator.Core;

import java.util.ArrayList;
import java.util.List;

import kr.ft.avaj.simulator.Core.Aircraft.Flyable;
import kr.ft.avaj.simulator.Core.Aircraft.Aircraft;
import kr.ft.avaj.simulator.Core.Aircraft.Coordinates.Coordinates;
import kr.ft.avaj.simulator.Core.Aircraft.Coordinates.CoordinatesFactory;
import kr.ft.avaj.simulator.Core.Aircraft.Factory.AircraftFactory;
import kr.ft.avaj.simulator.Core.Tower.WeatherTower;
import kr.ft.avaj.simulator.Parser.ParsedDataDTO;
import kr.ft.avaj.simulator.Parser.AircraftInfo.AircraftInfo;

public class Resource {
    private int simulationCount;
    private WeatherTower weatherTower;
    private List<Flyable> flyables;

    protected Resource(ParsedDataDTO data) {
        this.simulationCount = data.getSimulationCount();
        this.weatherTower = new WeatherTower();
        this.flyables = initFlyables(data);
    }

    private List<Flyable> initFlyables(ParsedDataDTO parsedDataDTO) {
        List<Flyable> flyables = new ArrayList<Flyable>();
        for (AircraftInfo ai : parsedDataDTO.getAircraftInfos()) {
            Coordinates co = CoordinatesFactory.create(ai.getLongitude(), ai.getLatitude(), ai.getHeight());
            flyables.add(AircraftFactory.newAircraft(ai.getType(), ai.getName(), co));
            weatherTower.register(flyables.get(flyables.size() - 1));
        }
        return flyables;
    }

    public int getSimulationCount() {
        return this.simulationCount;
    }

    public List<Flyable> getFlyables() {
        return this.flyables;
    }

    public WeatherTower getWeatherTower() {
        return this.weatherTower;
    }
}
