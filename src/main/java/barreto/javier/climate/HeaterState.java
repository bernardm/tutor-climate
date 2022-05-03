package barreto.javier.climate;

public interface HeaterState {
	int getPowerLevel();
	HeaterState increaseState();
	HeaterState decreaseState();
}
