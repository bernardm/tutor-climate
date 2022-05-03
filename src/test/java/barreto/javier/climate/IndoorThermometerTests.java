package barreto.javier.climate;

import java.beans.PropertyChangeListener;

import static org.junit.jupiter.api.Assertions.fail;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assumptions.assumeTrue;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class IndoorThermometerTests {
  static final double TEMPERATURE_MIN = -20;
  static final double TEMPERATURE_MAX = 20;
  static final int DISTANCE_TO_HEATER = 7;
  
    @Test
    @DisplayName("Returns a non-zero temperature")
    void getTemperature() {
      IndoorThermometer thermometer = new IndoorThermometer(DISTANCE_TO_HEATER);
      assertNotEquals(0.0, thermometer.getTemperature(), 0.01);
    }

  @Test @DisplayName("Gets the outdoor temperature via Observer")
  void getTemperatureObserver() {
    OutdoorThermometerMock observable = new OutdoorThermometerMock();
    IndoorThermometer observer = new IndoorThermometer(DISTANCE_TO_HEATER);
    
    observable.addPropertyChangeListener(observer);
    
    observable.setTemperature(TEMPERATURE_MAX);
    double whenAtOutdoorMax = observer.getTemperature();

    observable.setTemperature(TEMPERATURE_MIN);
    double whenAtOutdoorMin = observer.getTemperature();
    
    assertNotEquals(whenAtOutdoorMax, whenAtOutdoorMin);
    	//private double measureTemperature(double lastTemp, int heaterPower, int distanceToHeater, double outDoorTemp, int secondsSinceLast) 
      //measureTemperature(10, 0, 7, 10, 0);
  }
}
