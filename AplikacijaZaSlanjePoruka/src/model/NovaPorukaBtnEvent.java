package model;

import controller.Controller;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class NovaPorukaBtnEvent implements EventHandler<javafx.event.ActionEvent> {

	private Scene scene3;
	private Stage primaryStage;

	public NovaPorukaBtnEvent() {

	}

	@Override
	public void handle(ActionEvent arg0) {

		Controller.getInstance().getScenaTreca().setKorisnik(Controller.getInstance().getKorisnik());

		scene3 = Controller.getInstance().getSceneThree();
		primaryStage = Controller.getInstance().getPrimaryStage();

		primaryStage.setScene(scene3);
		primaryStage.show();

	}

}
