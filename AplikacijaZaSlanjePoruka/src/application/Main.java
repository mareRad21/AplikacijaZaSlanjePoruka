package application;
	
import javafx.application.Application;
import javafx.stage.Stage;
import view.Scena1;
import view.Scena3;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			
			//BorderPane root = new BorderPane();
			Scena1 root= new Scena1();
			Scene scene = new Scene(root,600,100);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
