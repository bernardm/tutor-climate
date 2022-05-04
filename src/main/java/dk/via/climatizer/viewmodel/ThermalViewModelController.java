package dk.via.climatizer.viewmodel;

import dk.via.climatizer.model.Model;
import javafx.beans.property.Property;
import javafx.beans.property.StringProperty;

import java.beans.PropertyChangeEvent;

public class ThermalViewModelController extends ViewModel {
	public static final String INDOOR_TEMP_0_PROPERTY = "T0";
	public static final String INDOOR_TEMP_1_PROPERTY = "T1";
	public static final String INDOOR_TEMP_2_PROPERTY = "T2";

	private StringProperty t0;
	private StringProperty t1;
	private StringProperty t2;

	public ThermalViewModelController(Model model) {
		super(model);
	}

	@Override public void bind(String name, Property<?> property) {

	}

	@Override public void reset() {

	}

	@Override public void propertyChange(PropertyChangeEvent evt) {

	}
}
