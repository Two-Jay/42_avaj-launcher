package kr.ft.avaj.simulator.Aircraft.UpdateStrategy;

import kr.ft.avaj.simulator.Aircraft.Coordinates.Coordinates;
import kr.ft.avaj.simulator.WeatherProvider.WeatherProvider;

public class BaloonMoveUpdateStrategy extends AircraftMoveUpdateStrategy
        implements AircraftMoveUpdateStrategyInterface {
    public void update(Coordinates coordinates) {
        WeatherProvider weatherProvider = WeatherProvider.getProvider();
        String weather = weatherProvider.getCurrentWeather(coordinates);

        switch (weather) {
            case "SUN":
                addToCoordinates(coordinates, 0, 2, 4);
                break;
            case "RAIN":
                addToCoordinates(coordinates, 0, 0, -5);
                break;
            case "FOG":
                addToCoordinates(coordinates, 0, 0, -3);
                break;
            case "SNOW":
                addToCoordinates(coordinates, 0, 0, -15);
                break;
        }
    }
}
