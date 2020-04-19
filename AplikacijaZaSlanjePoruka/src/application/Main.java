package application;

import controller.Controller;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import model.PrikaziPorukeBtnEvent;

public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {

			primaryStage = Controller.getInstance().getPrimaryStage();

			Controller.getInstance().getScenaPrva().getPregledPorukaBtn()
					.setOnAction(Controller.getInstance().getPregledPorukaBtnEvent());
			Controller.getInstance().getScenaPrva().getKreirajNovogKorisnikaBtn()
					.setOnAction(Controller.getInstance().getKreirajNovogKorisnikaBtnEvent());
			Controller.getInstance().getScenaDruga().getNovaPorukaBtn()
					.setOnAction(Controller.getInstance().getNovaPorukaBtnEvent());
			Controller.getInstance().getScenaTreca().getPosaljiBtn()
					.setOnAction(Controller.getInstance().getPosaljiBtnEvent());
			Controller.getInstance().getScenaDruga().getPrikaziBtn()
					.setOnAction(Controller.getInstance().getPrikaziPorukeBtnEvent());
			Controller.getInstance().getScenaDruga().getPrikaziTekstBtn()
					.setOnAction(Controller.getInstance().getPrikaziTextPorukeBtnEvent());

			Scene scene = Controller.getInstance().getSceneOne();
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		launch(args);
	}
}
