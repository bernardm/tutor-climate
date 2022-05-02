package barreto.javier.climate;

public abstract class Thermometer {
	protected double currentTemp;

  public Thermometer() {
	}

	public double getTemperature() {
		return currentTemp;
	}
}
