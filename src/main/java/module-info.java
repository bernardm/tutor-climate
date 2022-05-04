module Assignment.Climatizer {
	requires javafx.controls;
	requires javafx.fxml;
	requires java.desktop;
	requires javafx.graphics;

	opens dk.via.climatizer to javafx.fxml;
	opens dk.via.climatizer.view to javafx.fxml;

	exports dk.via.climatizer;
}
