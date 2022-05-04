package dk.via.climatizer.model.heater.states;

public class StateManual extends State {

  public StateManual(Heater heater) {
		super(heater);
	}
  
	@Override 
  public void increasePower() {
    if( heater.getPowerLevel < Heater.MAX ) {
      heater.increasePower();
    }
	}
  
	@Override 
  public void decreasePower() {
    if( heater.getPowerLevel > Heater.MIN ) {
      heater.decreasePower();
    }
	}
}
  