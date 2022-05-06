package dk.via.climatizer.viewmodel;

import dk.via.climatizer.model.Model;
import javafx.beans.property.Property;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public abstract class ViewModel implements PropertyChangeListener {
	public Model model;
	protected PropertyChangeSupport support;

	public ViewModel(Model model) {
		this.model = model;
		this.support = new PropertyChangeSupport(this);
	}

	public abstract void bind(String name, Property<?> property);

	public void addListener(String propertyName, PropertyChangeListener listener) {
		support.addPropertyChangeListener(propertyName, listener);
	}

	public void removeListener(String propertyName, PropertyChangeListener listener) {
		support.removePropertyChangeListener(propertyName, listener);
	}

	public abstract void reset();
}
