package dk.via.climatizer.view;

import dk.via.climatizer.viewmodel.ThermalViewModel;
import dk.via.climatizer.viewmodel.ViewModel;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.Region;

import static dk.via.climatizer.viewmodel.ThermalViewModel.TEMP_0_PROPERTY;
import static dk.via.climatizer.viewmodel.ThermalViewModel.TEMP_1_PROPERTY;
import static dk.via.climatizer.viewmodel.ThermalViewModel.TEMP_2_PROPERTY;


public class ThermalViewController extends ViewController {
	@FXML private Label t0;
	@FXML private Label t1;
	@FXML private Label t2;

	@Override public void init(ViewHandler handler, ViewModel viewModel, Region root) {
		this.viewModel = (ThermalViewModel) viewModel;
		super.init(handler, viewModel, root);
	}

	private ThermalViewModel viewModel;

	@Override public void setBindings() {
		viewModel.bind(TEMP_0_PROPERTY, t0.textProperty());
		viewModel.bind(TEMP_1_PROPERTY, t1.textProperty());
		viewModel.bind(TEMP_2_PROPERTY, t2.textProperty());
	}
}
