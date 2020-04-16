package application;
	
import controller.Controller;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			
			primaryStage= Controller.getInstance().getPrimaryStage();
			
			Controller.getInstance().getScenaPrva().getPregledPorukaBtn().setOnAction(Controller.getInstance().getPregledPorukaBtnEvent());
			Controller.getInstance().getScenaPrva().getKreirajNovogKorisnikaBtn().setOnAction(Controller.getInstance().getKreirajNovogKorisnikaBtnEvent());
			Controller.getInstance().getScenaDruga().getNovaPorukaBtn().setOnAction(Controller.getInstance().getNovaPorukaBtnEvent());
			Controller.getInstance().getScenaTreca().getPosaljiBtn().setOnAction(Controller.getInstance().getPosaljiBtnEvent());
		
			Scene scene = Controller.getInstance().getSceneOne();
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
			
			
//			Controller.getInstance().getScenaPrva().getPregledPorukaBtn().setOnAction(Controller.getInstance().getPregledPorukaBtnEvent());
//			Controller.getInstance().getScenaPrva().getKreirajNovogKorisnikaBtn().setOnAction(Controller.getInstance().getKreirajNovogKorisnikaBtnEvent());
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
