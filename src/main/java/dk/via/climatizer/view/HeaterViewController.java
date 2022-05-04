package dk.via.climatizer.view;

import dk.via.climatizer.viewmodel.HeaterViewModelController;
import dk.via.climatizer.viewmodel.ViewModel;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.Region;

import static dk.via.climatizer.viewmodel.HeaterViewModelController.HEATER_MODE_PROPERTY;
import static dk.via.climatizer.viewmodel.HeaterViewModelController.HEATER_VIEW_WARNING_PROPERTY;

public class HeaterViewController extends ViewController {
	HeaterViewModelController viewModel;
	@FXML private Label modeLabel;
	@FXML private Label error;

	@Override public void init(ViewHandler handler, ViewModel viewModel, Region root) {
		this.viewModel = (HeaterViewModelController) viewModel;
		super.init(handler, viewModel, root);
	}

	@Override public void setBindings() {
		viewModel.bind(HEATER_MODE_PROPERTY, modeLabel.textProperty());
		viewModel.bind(HEATER_VIEW_WARNING_PROPERTY, error.textProperty());
	}

	@Override public void setListeners(ViewHandler handler) {
		viewModel.addPropertyChangeListener(View.HEATER.getName(),
																				evt -> handler.openView(View.HEATER));
		viewModel.addPropertyChangeListener(View.THERMAL.getName(),
																				evt -> handler.openView(View.THERMAL));
	}

	public void increaseMode() {
		System.out.println("Mode would've been increased");
		viewModel.increaseMode();
	}

	public void decreaseMode() {
		System.out.println("Mode would've been decreased");
		viewModel.decreaseMode();
	}

	public void seeTemperature() {
		handler.openView(View.THERMAL);
	}
}
