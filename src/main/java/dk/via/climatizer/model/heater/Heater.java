package dk.via.climatizer.model.heater;

public class Heater {
  private HeaterState state;

  public Heater() {
    this.state = new HeaterOFF();
  }

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