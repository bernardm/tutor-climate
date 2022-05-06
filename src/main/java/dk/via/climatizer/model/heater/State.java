package dk.via.climatizer.model.heater;

public abstract class State {
  protected Heater heater;
  
  public State(Heater heater) {
    this.heater = heater;
  }
  
	public abstract void increasePower();
	public abstract void decreasePower();
}
