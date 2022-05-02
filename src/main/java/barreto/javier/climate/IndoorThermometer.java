package barreto.javier.climate;

public class IndoorThermometer extends Thermometer {
  static final double OUTDOOR_TEMPERATURE_MIN = -20;
  static final double OUTDOOR_TEMPERATURE_MAX = 20;

  private static final int WAIT_DELAY_SECONDS = 6;
	private int distanceToHeater;
	private double outdoorTemperature;
  private Heater heater;

	public IndoorThermometer(int distanceToHeater, double outdoorTemperature, Heater heater) {
		this.distanceToHeater = distanceToHeater;
		this.outdoorTemperature = outdoorTemperature;
    this.heater = heater;
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

	public double getTemperature() {
		int heaterPower = 0;
		this.currentTemperature = measureTemperature(this.currentTemperature, heaterPower, distanceToHeater, outdoorTemperature, WAIT_DELAY_SECONDS);
    return currentTemperature;
	}
}
