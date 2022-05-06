package dk.via.climatizer.model.heater;

public class StateManual extends State {

  public StateManual(Heater heater) {
		super(heater);
	}
  
	@Override 
  public void increasePower() {
		if (heater.getPowerLevel() == Heater.MED) {
			heater.setState(new StateTimed(30, heater));
		}
		heater.powerLevel++;
	}
  
	@Override 
  public void decreasePower() {
    if(heater.getPowerLevel() >= Heater.MIN) {
      heater.powerLevel--;
    }
	}
}
  