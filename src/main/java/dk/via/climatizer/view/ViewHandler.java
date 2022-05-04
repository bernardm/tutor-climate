package dk.via.climatizer.view;

import dk.via.climatizer.viewmodel.ViewModelFactory;
import javafx.scene.Scene;
import javafx.scene.layout.Region;
import javafx.stage.Stage;

public class ViewHandler {
	private final Scene currentScene;
	private Stage primaryStage;
	private final ViewFactory viewFactory;

	public ViewHandler(ViewModelFactory viewModelFactory) {
		this.viewFactory = new ViewFactory(this, viewModelFactory);
		this.currentScene = new Scene(new Region());
	}

	public void start(Stage primaryStage) {
		this.primaryStage = primaryStage;
		openView(View.HEATER);
	}

	public void openView(View view) {
		Region root = viewFactory.loadView(view);
		currentScene.setRoot(root);
		if (root.getUserData() == null) {
			primaryStage.setTitle("Indoor Climate Control");
		} else {
			primaryStage.setTitle(root.getUserData().toString());
		}
		primaryStage.setScene(currentScene);
		primaryStage.sizeToScene();
		primaryStage.show();
	}
}
