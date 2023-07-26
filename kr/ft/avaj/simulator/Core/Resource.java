package kr.ft.avaj.simulator.Core;

import kr.ft.avaj.simulator.Core.Aircraft.AircraftFactory;
import kr.ft.avaj.simulator.Core.Aircraft.Flyable;
import kr.ft.avaj.simulator.Core.Aircraft.Coordinates.Coordinates;
import kr.ft.avaj.simulator.Core.Aircraft.Coordinates.CoordinatesFactory;
import kr.ft.avaj.simulator.Core.Tower.WeatherTower;
import kr.ft.avaj.simulator.Parser.AircraftInfo;
import kr.ft.avaj.simulator.Parser.ParsedDataDTO;

public class Resource {
    private int simulationRepeatCount;
    private WeatherTower weatherTower;

    protected Resource(ParsedDataDTO data) {
        this.simulationCount = data.getSimulationCount();
        this.weatherTower = new WeatherTower();
        initFlyables(data);
    }

    private void initFlyables(ParsedDataDTO parsedDataDTO) {
        for (AircraftInfo ai : parsedDataDTO.getAircraftInfos()) {
            Coordinates co = CoordinatesFactory.create(ai.getLongitude(), ai.getLatitude(), ai.getHeight());
            Flyable f = AircraftFactory.newAircraft(ai.getType(), ai.getName(), co);
            weatherTower.register(f);
            f.registerTower(weatherTower);
        }
    }

    public int getSimulationCount() {
        return this.simulationCount;
    }

    public WeatherTower getWeatherTower() {
        return this.weatherTower;
    }
}
