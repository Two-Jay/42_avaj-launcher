package kr.ft.avaj.simulator.Core;

import kr.ft.avaj.simulator.Parser.ParsedDataDTO;

public class EngineCore extends Engine {
    private Resource re;

    protected EngineCore(ParsedDataDTO data) {
        re = new Resource(data);
    }

    public void runProcess() {
        for (int i = 0; i < this.re.getSimulationRepeatCount(); i++) {
            this.re.getWeatherTower().changeWeather();
        }
    }
}
