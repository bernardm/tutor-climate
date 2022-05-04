package dk.via.climatizer.view;

import dk.via.climatizer.viewmodel.ThermalViewModelController;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class ThermalViewController extends ViewController {
	@FXML private Label t0;
	@FXML private Label t1;
	@FXML private Label t2;

	private ThermalViewModelController viewModel;

	@Override public void setBindings() {

	}
}
