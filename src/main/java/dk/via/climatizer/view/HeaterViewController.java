package dk.via.climatizer.view;

import dk.via.climatizer.viewmodel.HeaterViewModel;
import dk.via.climatizer.viewmodel.ViewModel;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.Region;

import static dk.via.climatizer.viewmodel.HeaterViewModel.HEATER_MODE_PROPERTY;
import static dk.via.climatizer.viewmodel.HeaterViewModel.HEATER_VIEW_WARNING_PROPERTY;

public class HeaterViewController extends ViewController {
	HeaterViewModel viewModel;
	@FXML private Label modeLabel;
	@FXML private Label error;

	@Override public void init(ViewHandler handler, ViewModel viewModel, Region root) {
		this.viewModel = (HeaterViewModel) viewModel;
		super.init(handler, viewModel, root);
	}

	@Override public void setBindings() {
		viewModel.bind(HEATER_MODE_PROPERTY, modeLabel.textProperty());
		viewModel.bind(HEATER_VIEW_WARNING_PROPERTY, error.textProperty());
	}

	@Override public void setListeners(ViewHandler handler) {
		viewModel.addListener(View.HEATER.getName(),
																				evt -> handler.openView(View.HEATER));
		viewModel.addListener(View.THERMAL.getName(),
																				evt -> handler.openView(View.THERMAL));
	}

	public void increaseMode() {
		viewModel.increaseMode();
		System.out.println("Mode value: " + viewModel.model.getHeaterPower());
	}

	public void decreaseMode() {
		viewModel.decreaseMode();
		System.out.println("Mode value: " + viewModel.model.getHeaterPower());
	}

	public void seeTemperature() {
		handler.openView(View.THERMAL);
	}
}
