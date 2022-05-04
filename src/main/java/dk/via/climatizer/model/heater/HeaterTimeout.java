package dk.via.climatizer.model.heater;

public class HeaterTimeout implements Runnable {
	private int delayMilis;

	private Heater heater;

	public HeaterTimeout(int delaySeconds, Heater heater) {
		this.delayMilis = (delaySeconds * 1000);
	}

	@Override public void run() {
		heater.decreaseState();
		try {
			Thread.sleep(delayMilis);
		} catch (InterruptedException e) {
			throw new IllegalStateException("Interrupted during sleep", e);
		}
	}
}
