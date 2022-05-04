package dk.via.climatizer.viewmodel;

import dk.via.climatizer.model.Model;
import dk.via.climatizer.view.View;

public class ViewModelFactory {
	private final HeaterViewModelController heater;
	private final ThermalViewModelController thermal;

	public ViewModelFactory(Model model) {
		this.heater = new HeaterViewModelController(model);
		this.thermal = new ThermalViewModelController(model);
	}

	public ViewModel getViewModel(View view) {
		return switch (view) {
			case HEATER -> heater;
			case THERMAL -> thermal;
		};
	}
}
