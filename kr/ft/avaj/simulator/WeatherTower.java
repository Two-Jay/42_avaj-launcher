package kr.ft.avaj.simulator;

class WeatherTower extends Tower {
    private static WeatherProvider weatherProvider = WeatherProvider.getInstance();

    public String getWeather(Coordinates coordinates) {
        return weatherProvider.getCurrentWeather(coordinates);
    }

    void changeWeather() {
        weatherProvider.updateWeather();
    }
}
