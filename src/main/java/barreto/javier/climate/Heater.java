package barreto.javier.climate;

public class Heater {
  HeaterState state;

  public int getPowerLevel() {
    return state.getPowerLevel();
  }

  private void setState(HeaterState state) {
    this.state = state;
  }

  public void increaseState() {
    setState(state.increaseState());
  }

  public void decreaseState() {
    setState(state.decreaseState());
  }
}