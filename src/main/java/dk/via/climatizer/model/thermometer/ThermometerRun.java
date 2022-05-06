package dk.via.climatizer.model.thermometer;

public class ThermometerRun implements Runnable {
	Thermometer thermometer;
	long miliseconds;

	public ThermometerRun(Thermometer thermometer, long miliseconds) {
		this.thermometer = thermometer;
		this.miliseconds = miliseconds;
	}

	@Override public void run() {
		while (true) {
			thermometer.changeTemperature();
			try {
				Thread.sleep(miliseconds);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
