package barreto.javier.climate;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class OutdoorThermometer extends Thermometer {
  private final double min;
  private final double max;

  private PropertyChangeSupport support;
	
  public OutdoorThermometer(double min, double max) {
    this.min = min;
    this.max = max;
    support = new PropertyChangeSupport(this);
	}
  
  public void changeTemperature() {
    double previousTemperature = this.currentTemperature;
    this.currentTemperature = getTemperature();
	  support.firePropertyChange("Temperature", previousTemperature, this.currentTemperature);
	}
  
  public double getTemperature() {
    return calculateExternalTemperature(this.currentTemperature, this.min, this.max);
  }

	/**
	 * Calculating the external temperature. Values are only valid if the temperature is being
	 * measured approximately every 10th second.
	 *
	 * @param lastTemp  the last measured external temperature
	 * @param min a lower limit (might be temporally undershot)
	 * @param max an upper limit (might be temporally exceeded)
	 *
	 * @return an updated external temperature
	 */
	private double calculateExternalTemperature(double lastTemperature, double min, double max) {
		double left = lastTemperature - min;
		double right = max - lastTemperature;
		int sign = Math.random() * (left + right) > left ? 1 : -1;
		lastTemperature += sign * Math.random();
		return lastTemperature;
	}

  public void addListener(PropertyChangeListener listener) {
		support.addPropertyChangeListener(listener);
	}

	public void removeListener(PropertyChangeListener listener) {
		support.removePropertyChangeListener(listener);
	}
}
