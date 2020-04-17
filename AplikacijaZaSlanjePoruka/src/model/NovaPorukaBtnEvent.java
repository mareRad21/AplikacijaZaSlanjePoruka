package model;

import controller.Controller;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class NovaPorukaBtnEvent implements EventHandler<javafx.event.ActionEvent> {

	private Scene scene3;
	private Stage primaryStage;
	
	public  NovaPorukaBtnEvent() {
		
		
		
	}
	
	
	
	
	
	
	@Override
	public void handle(ActionEvent arg0) {
		
		scene3 = Controller.getInstance().getSceneThree();
		//provera korisnika
		System.out.println(Controller.getInstance().getKorisnik()+"stampa iz nova porukaBtn! ");
		primaryStage= Controller.getInstance().getPrimaryStage();

		primaryStage.setScene(scene3);
		primaryStage.show();
		
	}

}
