package application;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Main extends Application {
	
	private static Scene mainScene;
	
	@Override
	public void start(Stage primaryStage) {
		try {
			
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/gui/TelaPrincipal.fxml"));
			VBox vbox = loader.load();
			
			mainScene = new Scene(vbox);
			primaryStage.setScene(mainScene);
			primaryStage.setTitle("Gestão de estoque");
			primaryStage.show();
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static Scene getMainScene() {
		return mainScene;
	}
	

	public static void main(String[] args) {
		launch(args);
	}

}
