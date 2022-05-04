package dk.via.climatizer.model.thermometer;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class OutdoorThermometerTests {
  static final double TEMPERATURE_MIN = -20;
  static final double TEMPERATURE_MAX = 20;

  @Test
  @DisplayName("Returns the current outdoor temperature")
  void getTemperature() {
    OutdoorThermometer thermometer = new OutdoorThermometer(TEMPERATURE_MIN, TEMPERATURE_MAX);
    double temperature = thermometer.getTemperature();
    assertTrue(temperature >= TEMPERATURE_MIN, "Temperature should be above the lower limit");
    assertTrue(temperature <= TEMPERATURE_MAX, "Temperature should be below the upper limit");
  }

  @Test @DisplayName("Returns an updated (different) temperature every time")
  void randomTemperatureGet() {
    OutdoorThermometer thermometer = new OutdoorThermometer(TEMPERATURE_MIN, TEMPERATURE_MAX);
    double temp1 = thermometer.getTemperature();
    double temp2 = thermometer.getTemperature();
    assertNotEquals(temp1, temp2, "Two measurements are never equal");
  }
}
