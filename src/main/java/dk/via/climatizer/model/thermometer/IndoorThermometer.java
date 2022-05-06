package dk.via.climatizer.model.thermometer;

import dk.via.climatizer.model.heater.Heater;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class IndoorThermometer extends Thermometer implements PropertyChangeListener {
  public static final double OUTDOOR_TEMPERATURE_MIN = -20;
  public static final double OUTDOOR_TEMPERATURE_MAX = 20;

	private int measureDelay;

	private int distanceToHeater;
	private double outdoorTemperature;
	private Heater heater;
	private PropertyChangeSupport support;

	public IndoorThermometer(int distanceToHeater, Heater heater, int measureDelay) {
		this.distanceToHeater = distanceToHeater;
		this.heater = heater;
		this.measureDelay = measureDelay;
		this.support = new PropertyChangeSupport(this);
	}

	@Override public void changeTemperature() {
		double previousTemperature = this.currentTemperature;
		this.currentTemperature = getTemperature();
		support.firePropertyChange("Temperature", previousTemperature, this.currentTemperature);
	}

  public double getTemperature() {
		int heaterPower = heater.getPowerLevel();
    return measureTemperature(currentTemperature, heaterPower, distanceToHeater, outdoorTemperature,
															measureDelay);
	}

	/**
	 * Calculating the internal temperature in one of two locations.
	 * This includes a term from a heater (depending on location and
	 * heaters power), and a term from an outdoor heat loss.
	 * Values are only valid in the outdoor temperature range [-20; 20]
	 * and when secondsSinceLast, the number of seconds between each measurements are
	 * between 4 and 8 seconds.
	 *
	 * @param lastTemp the last measured temperature
	 * @param heaterPower the heaters power {0, 1, 2 or 3} where 0 is turned off,
	 * 1 is low, 2 is medium and 3 is high
	 * @param distanceToHeater the distance between heater and measurements {1 or 7}
	 * where 1 is close to the heater and 7 is in the opposite corner
	 * @param outDoorTemp the outdoor temperature (valid in the range [-20; 20])
	 * @param secondsSinceLast the number of seconds since last measurement [4; 8]
	 * @return the temperature
	 */
	private double measureTemperature(double lastTemp, int heaterPower, int distanceToHeater, double outDoorTemp, int secondsSinceLast) {
		double tMax = Math.min(11 * heaterPower + 10, 11 * heaterPower + 10 + outDoorTemp);
		tMax = Math.max(Math.max(lastTemp, tMax), outDoorTemp);
		double heaterTerm = 0;
		if (heaterPower > 0) {
			double den = Math.max((tMax * (20 - 5 * heaterPower) * (distanceToHeater + 5)), 0.1);
			heaterTerm = 30 * secondsSinceLast * Math.abs(tMax - lastTemp) / den;
		}
		double outdoorTerm = (lastTemp - outDoorTemp) * secondsSinceLast / 250.0;
		lastTemp = Math.min(Math.max(lastTemp - outdoorTerm + heaterTerm, outDoorTemp), tMax);
		return lastTemp;
	}

	public void addListener(PropertyChangeListener listener) {
		support.addPropertyChangeListener(listener);
	}

	public void removeListener(PropertyChangeListener listener) {
		support.removePropertyChangeListener(listener);
	}

	public void propertyChange(PropertyChangeEvent evt) {
		this.outdoorTemperature = (double) evt.getNewValue();
		System.out.println("Observed temperature: " + this.outdoorTemperature);
	}}
