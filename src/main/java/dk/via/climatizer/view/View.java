package dk.via.climatizer.view;

public enum View {
	HEATER("Heater View", "HeaterView.fxml", new HeaterViewController()),
	THERMAL("Temperature View","ThermalView.fxml", new ThermalViewController());

	private final String viewName;
	private final String fxmlFile;
	private ViewController controller;

	View(String viewName, String fxmlFile, ViewController controller) {
		this.viewName = viewName;
		this.fxmlFile = fxmlFile;
		this.controller = controller;
	}

	public String getName() {
		return viewName;
	}

	public String getFxml() {
		return fxmlFile;
	}

	public ViewController getController() {
		return controller;
	}

	public void setController(ViewController controller) {
		this.controller = controller;
	}

	@Override public String toString() {
		return viewName + " at " + fxmlFile;
	}
}
