package kr.ft.avaj.simulator.Aircraft.UpdateStrategy;

import kr.ft.avaj.simulator.Aircraft.Coordinates.Coordinates;
import kr.ft.avaj.simulator.WeatherProvider.WeatherProvider;

public class BaloonMoveUpdateStrategy implements AircraftMoveUpdateStrategy {
    public void update(Coordinates coordinates) {
        WeatherProvider weatherProvider = WeatherProvider.getInstance();
        String weather = weatherProvider.getCurrentWeather(coordinates);

        switch (weather) {
            case "SUN":
                coordinates.setLongitude(coordinates.getLongitude());
                coordinates.setLatitude(coordinates.getLatitude() + 2);
                coordinates.setHeight(coordinates.getHeight() + 4);
                break;
            case "RAIN":
                coordinates.setLongitude(coordinates.getLongitude());
                coordinates.setLatitude(coordinates.getLatitude());
                coordinates.setHeight(coordinates.getHeight() - 5);
                break;
            case "FOG":
                coordinates.setLongitude(coordinates.getLongitude());
                coordinates.setLatitude(coordinates.getLatitude());
                coordinates.setHeight(coordinates.getHeight() - 3);
                break;
            case "SNOW":
                coordinates.setLongitude(coordinates.getLongitude());
                coordinates.setLatitude(coordinates.getLatitude());
                coordinates.setHeight(coordinates.getHeight() - 15);
                break;
        }
    }
}
