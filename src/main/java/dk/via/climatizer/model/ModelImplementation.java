package dk.via.climatizer.model;

import dk.via.climatizer.model.heater.Heater;
import dk.via.climatizer.model.thermometer.IndoorThermometer;
import dk.via.climatizer.model.thermometer.OutdoorThermometer;
import dk.via.climatizer.model.thermometer.ThermometerRun;

import java.beans.PropertyChangeSupport;

public class ModelImplementation implements Model {
	public static final int INDOOR_MEASURE_DELAY = 6;
	public static final int OUTDOOR_MEASURE_DELAY = 10;

	private Heater heater;
	private OutdoorThermometer t0;
	private IndoorThermometer t1;
	private IndoorThermometer t2;

	public ModelImplementation() {
		this.heater = new Heater();
		t0 = new OutdoorThermometer(IndoorThermometer.OUTDOOR_TEMPERATURE_MIN, IndoorThermometer.OUTDOOR_TEMPERATURE_MAX);
		t1 = new IndoorThermometer(1, heater, INDOOR_MEASURE_DELAY);
		t2 = new IndoorThermometer(7, heater, INDOOR_MEASURE_DELAY);
		t0.addListener(t1);
		t0.addListener(t2);
		Thread outdoorTemp = new Thread(new ThermometerRun(t0, OUTDOOR_MEASURE_DELAY));
		Thread indoorTemp1 = new Thread(new ThermometerRun(t1, INDOOR_MEASURE_DELAY));
		Thread indoorTemp2 = new Thread(new ThermometerRun(t2, INDOOR_MEASURE_DELAY));
	}
  
	@Override public int getHeaterPower() {
		return heater.getPowerLevel();
	}

  @Override public void increaseHeaterPower() {
    heater.increasePower();
  }

  @Override public void decreaseHeaterPower() {
    heater.decreasePower();
  }
}
