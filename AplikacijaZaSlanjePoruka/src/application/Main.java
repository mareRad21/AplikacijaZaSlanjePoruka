package application;
	
import controller.Controller;
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
			
			primaryStage= Controller.getInstance().getPrimaryStage();
			
		
			Scene scene = Controller.getInstance().getSceneOne();
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
			
			Controller.getInstance().getScenaPrva().getKreirajNovogKorisnikaBtn().setOnAction(Controller.getInstance().getKreirajNovogKorisnikaBtnEvent());
			
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
