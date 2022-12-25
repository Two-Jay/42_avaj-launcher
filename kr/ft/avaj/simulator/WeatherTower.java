package kr.ft.avaj.simulator;

class WeatherTower extends Tower {
    public String getWeather(Coordinates coordinates) {
        return WeatherProvider.getInstance().getCurrentWeather(coordinates);
    }

    void changeWeather() {
        WeatherProvider.getInstance().updateWeather();
    }
}
