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
		
	
		//provera korisnika
		System.out.println(Controller.getInstance().getKorisnik()+" stampa iz novaPorukaBtn! ");
		
		System.out.println(Controller.getInstance().getScenaDruga().getKorisnik()+" korisnik scene 2");
		Controller.getInstance().getScenaTreca().setKorisnik(Controller.getInstance().getKorisnik());
		
		
		System.out.println(Controller.getInstance().getScenaTreca().getKorisnik()+ " ovo je korisnik kojeg koristi scena 3");
		
		scene3 = Controller.getInstance().getSceneThree();
		primaryStage= Controller.getInstance().getPrimaryStage();

		primaryStage.setScene(scene3);
		primaryStage.show();
		
	}

}
