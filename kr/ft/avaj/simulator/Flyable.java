package kr.ft.avaj.simulator;

public interface Flyable {
    public abstract void updateConditions();
    // public abstract void registerTower(WeatherTower weatherTower);

    // 얘네들 Simulator 클래스에서 업케스팅해서 호출하기 때문에 여기서 선언 빠지면 안됨.
    public abstract void speak();
}
