package barreto.javier.climate;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeEvent;

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
