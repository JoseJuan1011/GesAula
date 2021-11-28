package dad.gesaula.main;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import dad.gesaula.Alumnos.AlumnosMainController;
import dad.gesaula.grupo.GrupoController;
import dad.gesaula.ui.model.Grupo;
import javafx.beans.binding.Bindings;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Tab;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;

public class MainController implements Initializable {

	@FXML
    private Tab alumnosTab;

    @FXML
    private Tab grupoTab;

    @FXML
    private Button guardarButton;

    @FXML
    private TextField nombreField;

    @FXML
    private Button nuevoButton;

    @FXML
    private VBox view;
    
    private Grupo grupo = new Grupo();
	
    private AlumnosMainController alumnosController = new AlumnosMainController();
    
    private GrupoController grupoController = new GrupoController();
    
	public MainController() {
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/MainView.fxml"));
			loader.setController(this);
			loader.load();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		alumnosTab.setContent(alumnosController.getView());
		grupoTab.setContent(grupoController.getView()); 
		
		grupo.denominacionProperty().bind(grupoController.getModel().denominacionProperty());
		grupo.iniCursoProperty().bind(grupoController.getModel().iniCursoProperty());
		grupo.finCursoProperty().bind(grupoController.getModel().finCursoProperty());
		grupo.getPesos().examenesProperty().bind(grupoController.getModel().examenesProperty());
		grupo.getPesos().practicasProperty().bind(grupoController.getModel().practicasProperty());
		grupo.getPesos().actitudProperty().bind(grupoController.getModel().actitudProperty());
		
		Bindings.bindContentBidirectional(grupo.getAlumnos(),alumnosController.getModel().getAlumnos());
	}
	
	@FXML
    void onGuardarAction(ActionEvent event) {
		Alert alert = new Alert(AlertType.INFORMATION,"Grupo guardado en "+nombreField.getText());
		alert.setTitle("Guardar Archivo");
		alert.setHeaderText("Archivo "+nombreField.getText()+" guardado.");
		alert.showAndWait()
    	.filter(response -> response == ButtonType.OK)
    	.ifPresent(response -> {
			try {
				grupo.save(new File(nombreField.getText()));
			} catch (Exception e) {
				Alert errorAlert = new Alert(AlertType.ERROR,e.getMessage());
				errorAlert.setTitle("Error");
				errorAlert.setHeaderText("Error al guardar Grupo");
				errorAlert.showAndWait();
			}
		});
    }

    @FXML
    void onNuevoButton(ActionEvent event) {
    	grupo = new Grupo();
    	grupoController.clear();
    	alumnosController.clear();
    }
    
    public VBox getView() {
		return view;
	}

}
