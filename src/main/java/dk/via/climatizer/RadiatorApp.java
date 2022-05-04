package dk.via.climatizer;

import dk.via.climatizer.model.ModelImpl;
import dk.via.climatizer.model.Model;
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
		Model model = new ModelImpl();
		ViewModelFactory viewModel = new ViewModelFactory(model);
		ViewHandler view = new ViewHandler(viewModel);
		//TODO Threads go here
		view.start(stage);
	}

	public static void main(String[] args) {
		launch();
	}
}
