package dad.gesaula.main;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class App extends Application {

	private MainController controller = new MainController();
	
	public static Stage primaryStage;
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		Scene scene = new Scene(controller.getView());
		
		primaryStage.setTitle("GesAula");
		primaryStage.setScene(scene);
		primaryStage.getIcons().add(new Image(getClass().getResourceAsStream("/images/app-icon-64x64.png")));
		primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}

}
