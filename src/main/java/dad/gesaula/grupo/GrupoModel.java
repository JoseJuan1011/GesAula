package dad.gesaula.grupo;

import java.time.LocalDate;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class GrupoModel {

	private StringProperty denominacion;
	
	private ObjectProperty<LocalDate> iniCurso;
	
	private ObjectProperty<LocalDate> finCurso;
	
	private DoubleProperty examenes;
	
	private DoubleProperty practicas;
	
	private DoubleProperty actitud;
	
	public GrupoModel() {
		denominacion= new SimpleStringProperty();
		iniCurso = new SimpleObjectProperty<LocalDate>();
		finCurso = new SimpleObjectProperty<LocalDate>();
		examenes = new SimpleDoubleProperty();
		practicas = new SimpleDoubleProperty();
		actitud = new SimpleDoubleProperty();
	}

	public final StringProperty denominacionProperty() {
		return this.denominacion;
	}

	public final String getDenominacion() {
		return this.denominacionProperty().get();
	}

	public final void setDenominacion(final String denominacion) {
		this.denominacionProperty().set(denominacion);
	}

	public final ObjectProperty<LocalDate> iniCursoProperty() {
		return this.iniCurso;
	}

	public final LocalDate getIniCurso() {
		return this.iniCursoProperty().get();
	}

	public final void setIniCurso(final LocalDate iniCurso) {
		this.iniCursoProperty().set(iniCurso);
	}

	public final ObjectProperty<LocalDate> finCursoProperty() {
		return this.finCurso;
	}

	public final LocalDate getFinCurso() {
		return this.finCursoProperty().get();
	}

	public final void setFinCurso(final LocalDate finCurso) {
		this.finCursoProperty().set(finCurso);
	}

	public final DoubleProperty examenesProperty() {
		return this.examenes;
	}

	public final double getExamenes() {
		return this.examenesProperty().get();
	}

	public final void setExamenes(final double examenes) {
		this.examenesProperty().set(examenes);
	}

	public final DoubleProperty practicasProperty() {
		return this.practicas;
	}

	public final double getPracticas() {
		return this.practicasProperty().get();
	}

	public final void setPracticas(final double practicas) {
		this.practicasProperty().set(practicas);
	}

	public final DoubleProperty actitudProperty() {
		return this.actitud;
	}

	public final double getActitud() {
		return this.actitudProperty().get();
	}

	public final void setActitud(final double actitud) {
		this.actitudProperty().set(actitud);
	}
}
