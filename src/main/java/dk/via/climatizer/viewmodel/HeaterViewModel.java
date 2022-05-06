package dk.via.climatizer.viewmodel;

import dk.via.climatizer.model.Model;
import javafx.beans.property.Property;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import java.beans.PropertyChangeEvent;

public class HeaterViewModel extends ViewModel {
	public static final String HEATER_MODE_PROPERTY = "Mode";
	public static final String HEATER_VIEW_WARNING_PROPERTY = "Error";

	public static final String MODE_LABEL_DEFAULT = "Current Mode: ";

	private StringProperty modeLabel;
	private StringProperty error;

	public HeaterViewModel(Model model) {
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
		return MODE_LABEL_DEFAULT + model.getHeaterPower();
	}

	@Override public void reset() {
		modeLabel.set(getModeLabel());
		error.set("");
	}

	@Override public void propertyChange(PropertyChangeEvent evt) {
		switch (evt.getPropertyName()) {
			case HEATER_MODE_PROPERTY -> modeLabel.set(getModeLabel());
			case HEATER_VIEW_WARNING_PROPERTY -> error.set((String)evt.getNewValue());
		}
	}

	public void increaseMode() {
		model.increaseHeaterPower();
		propertyChange(new PropertyChangeEvent(this, HEATER_MODE_PROPERTY, modeLabel.getValue(), getModeLabel()));
	}

	public void decreaseMode() {
		model.decreaseHeaterPower();
		propertyChange(new PropertyChangeEvent(this, HEATER_MODE_PROPERTY, modeLabel.getValue(), getModeLabel()));
	}
}
