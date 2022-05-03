package barreto.javier.climate;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class OutdoorThermometerMock {
	private double temperature = 0;
	private PropertyChangeSupport support;

	public OutdoorThermometerMock() {
		support = new PropertyChangeSupport(this);
	}

	public void addPropertyChangeListener(PropertyChangeListener listener) {
		support.addPropertyChangeListener(listener);
	}

	public void removePropertyChangeListener(PropertyChangeListener listener) {
		support.removePropertyChangeListener(listener);
	}

	public void setTemperature(double value) {
		support.firePropertyChange("Temperature", this.temperature, value);
		this.temperature = value;
	}
}
