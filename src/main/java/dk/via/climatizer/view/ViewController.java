package dk.via.climatizer.view;

import dk.via.climatizer.viewmodel.ViewModel;
import javafx.scene.layout.Region;

public abstract class ViewController {
	private ViewModel viewModel;
	protected Region root;
	protected ViewHandler handler;

	public ViewController() {
	}

	public void init(ViewHandler handler, ViewModel viewModel, Region root) {
		this.viewModel = viewModel;
		this.root = root;
		this.handler = handler;
		setBindings();
		setListeners(handler);
	}

	public void reset() {
		viewModel.reset();
	}

	public void setListeners(ViewHandler handler) {

	}

	public abstract void setBindings();

	public Region getRoot() {
		return root;
	}
}
