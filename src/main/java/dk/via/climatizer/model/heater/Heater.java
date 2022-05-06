package dk.via.climatizer.model.heater;

public class Heater {
  public static final int OFF = 0;
  public static final int MIN = 1;
  public static final int MED = 2;
  public static final int MAX = 3;
  
  private State state;
  int powerLevel;

  public Heater() {
    this.state = new StateManual(this);
    this.powerLevel = OFF;
  }

  public void setState(State state) {
    this.state = state;
  }

  public int getPowerLevel() {
    return this.powerLevel;
  }
  
  public void increasePower() {
    state.increasePower();
  }

  public void decreasePower() {
    state.decreasePower();
  }
}
