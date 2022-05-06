package dk.via.climatizer.viewmodel;

import dk.via.climatizer.model.Model;
import dk.via.climatizer.view.View;

public class ViewModelFactory {
	private final HeaterViewModel heater;
	private final ThermalViewModel thermal;

	public ViewModelFactory(Model model) {
		this.heater = new HeaterViewModel(model);
		this.thermal = new ThermalViewModel(model);
	}

	public ViewModel getViewModel(View view) {
		return switch (view) {
			case HEATER -> heater;
			case THERMAL -> thermal;
		};
	}
}
