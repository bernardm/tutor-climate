package dk.via.climatizer.viewmodel;

import dk.via.climatizer.model.Model;
import javafx.beans.property.Property;
import javafx.beans.property.StringProperty;

import java.beans.PropertyChangeEvent;

public class ThermalViewModel extends ViewModel {
	public static final String TEMP_0_PROPERTY = "T0";
	public static final String TEMP_1_PROPERTY = "T1";
	public static final String TEMP_2_PROPERTY = "T2";

	private StringProperty t0;
	private StringProperty t1;
	private StringProperty t2;

	public ThermalViewModel(Model model) {
		super(model);
	}

	@Override public void bind(String name, Property<?> property) {
		switch (name) {
			case TEMP_0_PROPERTY -> ((StringProperty) property).bind(t0);
			case TEMP_1_PROPERTY -> ((StringProperty) property).bind(t1);
			case TEMP_2_PROPERTY -> ((StringProperty) property).bind(t2);
		}
	}

	@Override public void reset() {

	}

	@Override public void propertyChange(PropertyChangeEvent evt) {

	}
}
