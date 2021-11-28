package dad.gesaula.Alumnos;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.Objects;
import java.util.ResourceBundle;

import dad.gesaula.ui.model.Alumno;
import javafx.beans.binding.Bindings;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.SplitPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;

public class AlumnosMainController implements Initializable {

	@FXML
    private TableView<Alumno> alumnosTable;

    @FXML
    private TableColumn<Alumno, String> apellidosColumn;

    @FXML
    private Button eliminarButton;

    @FXML
    private TableColumn<Alumno, LocalDate> fechaNacimiento;

    @FXML
    private BorderPane rightView;
    
    @FXML
    private Label notSelectedLabel;
    
    @FXML
    private TableColumn<Alumno, String> nombreColumn;

    @FXML
    private Button nuevoButton;

    @FXML
    private SplitPane view;

	private AlumnoSeleccionadoController alumnoSelecController = new AlumnoSeleccionadoController();
	
    private AlumnosModel model = new AlumnosModel();
	
	public AlumnosMainController() {
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/AlumnosView.fxml"));
			loader.setController(this);
			loader.load();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		model.nombreProperty().bindBidirectional(alumnoSelecController.getNombreField().textProperty());
		model.apellidosProperty().bindBidirectional(alumnoSelecController.getApellidosField().textProperty());
		model.fechaNacimientoProperty().bindBidirectional(alumnoSelecController.getOnFechaNacimiento().valueProperty());
		model.SexoProperty().bindBidirectional(alumnoSelecController.getOnSexoComboBox().valueProperty());
		model.repiteProperty().bindBidirectional(alumnoSelecController.getRepiteCheckBox().selectedProperty());
		
		Bindings.bindContentBidirectional(model.getAlumnos(), alumnosTable.getItems());
		
		model.getAlumno().bind(alumnosTable.getSelectionModel().selectedItemProperty());
		
		model.getAlumno().addListener((obv, ov, nv) -> onAlumnoChanged(obv,ov,nv));
		
		nombreColumn.setCellValueFactory(new PropertyValueFactory<Alumno, String>("nombre"));
		apellidosColumn.setCellValueFactory(new PropertyValueFactory<Alumno, String>("apellidos"));
		fechaNacimiento.setCellValueFactory(new PropertyValueFactory<Alumno, LocalDate>("fechaNacimiento"));
	}
	
	public void onAlumnoChanged(ObservableValue<? extends Alumno> obv, Alumno ov, Alumno nv) {
		 
		if (ov != null) {
			model.nombreProperty().unbindBidirectional(ov.nombreProperty());
			model.apellidosProperty().unbindBidirectional(ov.apellidosProperty());
			model.fechaNacimientoProperty().unbindBidirectional(ov.fechaNacimientoProperty());
			model.SexoProperty().unbindBidirectional(ov.sexoProperty());
			model.repiteProperty().unbindBidirectional(ov.repiteProperty());
		}
		
		if (nv != null) {
			model.nombreProperty().bindBidirectional(nv.nombreProperty());
			model.apellidosProperty().bindBidirectional(nv.apellidosProperty());
			model.fechaNacimientoProperty().bindBidirectional(nv.fechaNacimientoProperty());
			model.SexoProperty().bindBidirectional(nv.sexoProperty());
			model.repiteProperty().bindBidirectional(nv.repiteProperty());
		}
	}
	
	@FXML
    void onEliminarAction(ActionEvent event) {
		Alumno alumno = alumnosTable.getSelectionModel().getSelectedItem();
		Alert alert = new Alert(AlertType.CONFIRMATION, "¿Estás Seguro?");
		alert.setTitle("Eliminar Alumnos");
		alert.setHeaderText("Se va a eliminar el alumno \""+alumno.getNombre()+" "+alumno.getApellidos()+"\"");
		alert.showAndWait()
	    	.filter(response -> response == ButtonType.OK)
	    	.ifPresent(response -> alumnosTable.getItems().remove(alumno));
	}
	
	@FXML
    void onTableClickedEvent(MouseEvent event) {
		boolean isItemNull = Objects.isNull(alumnosTable.getSelectionModel().getSelectedItem());
		rightView.setCenter(
				(isItemNull ? notSelectedLabel : alumnoSelecController.getView())
		);
    }

    @FXML
    void onNuevoAction(ActionEvent event) {
    	Alumno alumno = new Alumno();
    	alumno.setNombre("Sin nombre");
    	alumno.setApellidos("Sin apellidos");
    	
    	alumnosTable.getItems().add(alumno);
    }
	
	public TableView<Alumno> getAlumnosTable() {
		return alumnosTable;
	}

	public TableColumn<Alumno, String> getApellidosColumn() {
		return apellidosColumn;
	}

	public Button getEliminarButton() {
		return eliminarButton;
	}

	public TableColumn<Alumno, LocalDate> getFechaNacimiento() {
		return fechaNacimiento;
	}

	public BorderPane getRightView() {
		return rightView;
	}

	public Label getNotSelectedLabel() {
		return notSelectedLabel;
	}

	public TableColumn<Alumno, String> getNombreColumn() {
		return nombreColumn;
	}

	public Button getNuevoButton() {
		return nuevoButton;
	}

	public AlumnoSeleccionadoController getAlumnoSelecController() {
		return alumnoSelecController;
	}

	public AlumnosModel getModel() {
		return model;
	}

	public SplitPane getView() {
		return view;
	}

	public void clear() {
		alumnosTable.getItems().clear();
		rightView.setCenter(notSelectedLabel);
	}

}
