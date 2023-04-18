package kr.ft.avaj.simulator.Aircraft.UpdateStrategy;

import kr.ft.avaj.simulator.Aircraft.Coordinates.Coordinates;
import kr.ft.avaj.simulator.WeatherProvider.WeatherProvider;

public class JetPlaneMoveUpdateStrategy implements AircraftMoveUpdateStrategy {
    public void update(Coordinates coordinates) {
        WeatherProvider weatherProvider = WeatherProvider.getInstance();
        String weather = weatherProvider.getCurrentWeather(coordinates);

        switch (weather) {
            case "SUN":
                coordinates.setLongitude(coordinates.getLongitude());
                coordinates.setLatitude(coordinates.getLatitude() + 10);
                coordinates.setHeight(coordinates.getHeight() + 2);
                break;
            case "RAIN":
                coordinates.setLongitude(coordinates.getLongitude());
                coordinates.setLatitude(coordinates.getLatitude() + 5);
                coordinates.setHeight(coordinates.getHeight());
                break;
            case "FOG":
                coordinates.setLongitude(coordinates.getLongitude());
                coordinates.setLatitude(coordinates.getLatitude() + 1);
                coordinates.setHeight(coordinates.getHeight());
                break;
            case "SNOW":
                coordinates.setLongitude(coordinates.getLongitude());
                coordinates.setLatitude(coordinates.getLatitude());
                coordinates.setHeight(coordinates.getHeight() - 7);
                break;
        }
    }
}
