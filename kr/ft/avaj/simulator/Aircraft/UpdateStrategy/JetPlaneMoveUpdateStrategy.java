package kr.ft.avaj.simulator.Aircraft.UpdateStrategy;

import kr.ft.avaj.simulator.Aircraft.Coordinates.Coordinates;
import kr.ft.avaj.simulator.WeatherProvider.WeatherProvider;

public class JetPlaneMoveUpdateStrategy extends AircraftMoveUpdateStrategy
        implements AircraftMoveUpdateStrategyInterface {
    public void update(Coordinates coordinates) {
        WeatherProvider weatherProvider = WeatherProvider.getProvider();
        String weather = weatherProvider.getCurrentWeather(coordinates);

        switch (weather) {
            case "SUN":
                addToCoordinates(coordinates, 0, 10, 2);
                break;
            case "RAIN":
                addToCoordinates(coordinates, 0, 5, 0);
                break;
            case "FOG":
                addToCoordinates(coordinates, 0, 1, 0);
                break;
            case "SNOW":
                addToCoordinates(coordinates, 0, 0, -7);
                break;
        }
    }
}
