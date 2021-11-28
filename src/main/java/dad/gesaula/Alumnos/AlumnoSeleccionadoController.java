package dad.gesaula.Alumnos;

import java.io.IOException;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import dad.gesaula.ui.model.Alumno;
import dad.gesaula.ui.model.Sexo;

public class AlumnoSeleccionadoController implements Initializable {

	@FXML
    private TextField apellidosField;

    @FXML
    private TextField nombreField;

    @FXML
    private DatePicker onFechaNacimiento;

    @FXML
    private ComboBox<Sexo> onSexoComboBox;

    @FXML
    private CheckBox repiteCheckBox;
    
    @FXML
    private GridPane view;
    
	public AlumnoSeleccionadoController() {
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/AlumnoSeleccionadoView.fxml"));
			loader.setController(this);
			loader.load();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		onSexoComboBox.getItems().addAll(Sexo.values());
	}

	public TextField getApellidosField() {
		return apellidosField;
	}

	public void setApellidosField(TextField apellidosField) {
		this.apellidosField = apellidosField;
	}

	public TextField getNombreField() {
		return nombreField;
	}

	public void setNombreField(TextField nombreField) {
		this.nombreField = nombreField;
	}

	public DatePicker getOnFechaNacimiento() {
		return onFechaNacimiento;
	}

	public void setOnFechaNacimiento(DatePicker onFechaNacimiento) {
		this.onFechaNacimiento = onFechaNacimiento;
	}

	public ComboBox<Sexo> getOnSexoComboBox() {
		return onSexoComboBox;
	}

	public void setOnSexoComboBox(ComboBox<Sexo> onSexoComboBox) {
		this.onSexoComboBox = onSexoComboBox;
	}

	public CheckBox getRepiteCheckBox() {
		return repiteCheckBox;
	}

	public void setRepiteCheckBox(CheckBox repiteCheckBox) {
		this.repiteCheckBox = repiteCheckBox;
	}

	public GridPane getView() {
		return view;
	}

	public void setView(GridPane view) {
		this.view = view;
	}

	
}
