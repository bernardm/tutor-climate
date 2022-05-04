package dk.via.climatizer.viewmodel;

import dk.via.climatizer.model.Model;
import javafx.beans.property.Property;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import java.beans.PropertyChangeEvent;

public class HeaterViewModelController extends ViewModel {
	public static final String HEATER_MODE_PROPERTY = "Mode";
	public static final String HEATER_VIEW_WARNING_PROPERTY = "Error";

	public static final String MODE_LABEL_DEFAULT = "Current Mode: ";

	private StringProperty modeLabel;
	private StringProperty error;

	public HeaterViewModelController(Model model) {
		super(model);
		modeLabel = new SimpleStringProperty(getModeLabel());
		error = new SimpleStringProperty("");
	}

	@Override public void bind(String name, Property<?> property) {
		switch (name) {
			case HEATER_MODE_PROPERTY -> ((StringProperty) property).bind(modeLabel);
			case HEATER_VIEW_WARNING_PROPERTY -> ((StringProperty) property).bind(error);
		}
	}

	private String getModeLabel() {
		return MODE_LABEL_DEFAULT + model.getMode().toString();
	}

	@Override public void reset() {
		modeLabel.set("");
		error.set("");
	}

	@Override public void propertyChange(PropertyChangeEvent evt) {
		System.out.println("A property has changed " + evt.toString());
	}

	public void increaseMode() {
	}

	public void decreaseMode() {
	}
}
