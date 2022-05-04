package dk.via.climatizer.model.heater;

import dk.via.climatizer.model.heater.states.*;

public class Heater {
  public static final int OFF = 0
  public static final int MIN = 1
  public static final int MED = 2
  public static final int MAX = 3
  
  private State state;
  private int powerLevel;

  public Heater() {
    this.state = new StateOff(this);
    this.powerLevel = OFF
  }

  public int getPowerLevel() {
    return this.powerLevel;
  }
  
  public void increasePower() {
    this.powerLevel++;
  }

  public void decreasePower() {
    this.powerLevel--;
  }
}
