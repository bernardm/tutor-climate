package dk.via.climatizer.view;

import dk.via.climatizer.viewmodel.ViewModelFactory;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.Region;

import java.io.IOError;
import java.io.IOException;

public class ViewFactory {
	private final ViewHandler viewHandler;
	private final ViewModelFactory viewModelFactory;

	public ViewFactory(ViewHandler viewHandler, ViewModelFactory viewModelFactory) {
		this.viewHandler = viewHandler;
		this.viewModelFactory = viewModelFactory;
	}

	public Region loadView(View view) {
		if (view.getController().getRoot() == null) {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(getClass().getResource(view.getFxml()));
			try {
				Region root = loader.load();
				view.setController(loader.getController());
				view.getController().init(viewHandler, viewModelFactory.getViewModel(view), root);
			} catch (IOException e) {
				throw new IOError(e);
			}
		}
		view.getController().reset();
		return view.getController().getRoot();
	}
}
