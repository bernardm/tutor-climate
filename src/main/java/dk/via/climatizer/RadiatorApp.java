package dk.via.climatizer;

import dk.via.climatizer.model.Model;
import dk.via.climatizer.model.ModelImplementation;
import dk.via.climatizer.view.ViewHandler;
import dk.via.climatizer.viewmodel.ViewModelFactory;
import javafx.application.Application;
import javafx.stage.Stage;

public class RadiatorApp extends Application {
	@Override public void init() throws Exception {
	}

	@Override public void stop() throws Exception {
	}

	@Override public void start(Stage stage) throws Exception {
		Model model = new ModelImplementation();
		ViewModelFactory viewModel = new ViewModelFactory(model);
		ViewHandler view = new ViewHandler(viewModel);
		//TODO Threads go here
		view.start(stage);
	}
}
