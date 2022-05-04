package dk.via.climatizer.model.thermometer;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class Observer implements PropertyChangeListener {
  private double temperature;

  public double getTemperature() {
    return this.temperature;
  }

  public void propertyChange(PropertyChangeEvent evt) {
    this.temperature = (double) evt.getNewValue();
    System.out.println("Observed temperature: " + this.temperature );
  }
}
