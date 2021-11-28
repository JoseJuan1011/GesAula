package dad.gesaula.grupo;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.util.converter.NumberStringConverter;

public class GrupoController implements Initializable {

	@FXML
    private Label actitudLabel;

    @FXML
    private Slider actitudSlider;

    @FXML
    private TextField denominacionField;

    @FXML
    private Label examenesLabel;

    @FXML
    private Slider examenesSlider;

    @FXML
    private DatePicker finCursoDatePicker;

    @FXML
    private DatePicker inicioCursoDatePicker;

    @FXML
    private Label practicasLabel;

    @FXML
    private Slider practicasSlider;
	
    @FXML
    private GridPane view;
    
    private GrupoModel model = new GrupoModel();
    
	public GrupoController() {
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/GrupoView.fxml"));
			loader.setController(this);
			loader.load();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		model.denominacionProperty().bindBidirectional(denominacionField.textProperty());
		model.iniCursoProperty().bindBidirectional(inicioCursoDatePicker.valueProperty());
		model.finCursoProperty().bindBidirectional(finCursoDatePicker.valueProperty());
		model.examenesProperty().bindBidirectional(examenesSlider.valueProperty());
		model.practicasProperty().bindBidirectional(practicasSlider.valueProperty());
		model.actitudProperty().bindBidirectional(actitudSlider.valueProperty());
		
		examenesLabel.textProperty().bindBidirectional(model.examenesProperty(), new NumberStringConverter());
		practicasLabel.textProperty().bindBidirectional(model.practicasProperty(), new NumberStringConverter());
		actitudLabel.textProperty().bindBidirectional(model.actitudProperty(), new NumberStringConverter());
	}
	
	public void clear() {
		denominacionField.clear();
		inicioCursoDatePicker.getEditor().clear();
		finCursoDatePicker.getEditor().clear();
		examenesSlider.setValue(0);
		practicasSlider.setValue(0);
		actitudSlider.setValue(0);
	}

	public Label getActitudLabel() {
		return actitudLabel;
	}

	public Slider getActitudSlider() {
		return actitudSlider;
	}

	public TextField getDenominacionField() {
		return denominacionField;
	}

	public Label getExamenesLabel() {
		return examenesLabel;
	}

	public Slider getExámenesSlider() {
		return examenesSlider;
	}

	public DatePicker getFinCursoDatePicker() {
		return finCursoDatePicker;
	}

	public DatePicker getInicioCursoDatePicker() {
		return inicioCursoDatePicker;
	}

	public Label getPracticasLabel() {
		return practicasLabel;
	}

	public Slider getPrácticasSlider() {
		return practicasSlider;
	}

	public GridPane getView() {
		return view;
	}

	public GrupoModel getModel() {
		return model;
	}
}
