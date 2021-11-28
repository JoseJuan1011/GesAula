package dad.gesaula.Alumnos;

import java.time.LocalDate;

import dad.gesaula.ui.model.Alumno;
import dad.gesaula.ui.model.Sexo;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class AlumnosModel {

	private StringProperty nombre;

	private StringProperty apellidos;

	private ObjectProperty<LocalDate> fechaNacimiento;

	private ObjectProperty<Sexo> Sexo;

	private BooleanProperty repite;
	
	private ObservableList<Alumno> alumnos;

	private ObjectProperty<Alumno> alumno;
	
	public AlumnosModel() {
		this.nombre = new SimpleStringProperty();
		this.apellidos = new SimpleStringProperty();
		this.fechaNacimiento = new SimpleObjectProperty<LocalDate>();
		this.Sexo = new SimpleObjectProperty<Sexo>();
		this.repite = new SimpleBooleanProperty();
		this.alumno = new SimpleObjectProperty<Alumno>(new Alumno());
		this.alumnos = FXCollections.observableArrayList();
	}
	
	public AlumnosModel(String nombre, String apellidos, LocalDate fechaNacimiento,
			Sexo sexo, boolean repite) {
		this.nombre = new SimpleStringProperty(nombre);
		this.apellidos = new SimpleStringProperty(apellidos);
		this.fechaNacimiento = new SimpleObjectProperty<LocalDate>(fechaNacimiento);
		this.Sexo = new SimpleObjectProperty<Sexo>(sexo);
		this.repite = new SimpleBooleanProperty(repite);
		this.alumno = new SimpleObjectProperty<Alumno>(new Alumno());
		this.alumnos = FXCollections.observableArrayList();
	}
	
	public final StringProperty nombreProperty() {
		return this.nombre;
	}

	public final String getNombre() {
		return this.nombreProperty().get();
	}

	public final void setNombre(final String nombre) {
		this.nombreProperty().set(nombre);
	}

	public final StringProperty apellidosProperty() {
		return this.apellidos;
	}

	public final String getApellidos() {
		return this.apellidosProperty().get();
	}

	public final void setApellidos(final String apellidos) {
		this.apellidosProperty().set(apellidos);
	}

	public final ObjectProperty<LocalDate> fechaNacimientoProperty() {
		return this.fechaNacimiento;
	}

	public final LocalDate getFechaNacimiento() {
		return this.fechaNacimientoProperty().get();
	}

	public final void setFechaNacimiento(final LocalDate fechaNacimiento) {
		this.fechaNacimientoProperty().set(fechaNacimiento);
	}

	public final ObjectProperty<Sexo> SexoProperty() {
		return this.Sexo;
	}

	public final Sexo getSexo() {
		return this.SexoProperty().get();
	}

	public final void setSexo(final Sexo Sexo) {
		this.SexoProperty().set(Sexo);
	}

	public final BooleanProperty repiteProperty() {
		return this.repite;
	}

	public final boolean isRepite() {
		return this.repiteProperty().get();
	}

	public final void setRepite(final boolean repite) {
		this.repiteProperty().set(repite);
	}

	public ObservableList<Alumno> getAlumnos() {
		return alumnos;
	}

	public void setAlumnos(ObservableList<Alumno> alumnos) {
		this.alumnos = alumnos;
	}

	public ObjectProperty<Alumno> getAlumno() {
		return alumno;
	}

	public void setAlumno(ObjectProperty<Alumno> alumno) {
		this.alumno = alumno;
	}
}
