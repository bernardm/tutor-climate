package dk.via.climatizer.model.heater;

import dk.via.climatizer.model.heater.states.*;

public class Heater {
  private State state;

  public Heater() {
    this.state = new HeaterOFF();
  }

  public int getPowerLevel() {
    return state.getPowerLevel();
  }

  private void setState(State state) {
    this.state = state;
  }

  public void increaseState() {
    setState(state.increaseState());
  }

  public void decreaseState() {
    setState(state.decreaseState());
  }
}
