package dk.via.climatizer.model;

import dk.via.climatizer.model.heater.Heater;

public class ModelImplementation implements Model {
	Heater heater = new Heater();
  
	@Override public int getHeaterMode() {
		return heater.getPowerLevel();
	}

  @Override public void increasePower() {
    
  }

  @Override public void decreasePower() {
    
  }
}
