package model;

import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.Calendar;
import java.util.Date;

import controller.Controller;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class PosaljiBtnEvent implements EventHandler<javafx.event.ActionEvent> {

	private TextField primalacTextFld;
	private TextField naslovTextFld;
	private TextArea textPorukeTextArea;
	private Scene scene2;
	
	private Stage primaryStage;
	
	
	public PosaljiBtnEvent(TextField primalacTextFld, TextField naslovTextFld, TextArea textPorukeTextArea) {

		this.primalacTextFld = primalacTextFld;
		this.naslovTextFld = naslovTextFld;
		this.textPorukeTextArea = textPorukeTextArea;

	}

	@Override
	public void handle(ActionEvent arg0) {

		
		try {
			ObjectInputStream in = new ObjectInputStream(new FileInputStream("korisnici.dat"));
			Korisnik posiljalac = Controller.getInstance().getKorisnik();
			Korisnik korisnik;
			
			while((korisnik = (Korisnik) in.readObject())!= null) {
				
				//proveri da li postoji taj kome se salje poruka 
				
				if(korisnik.toString().equals(primalacTextFld.getText())){
					
					//ucitaj sve podatke i spakuj u poruku
					
					String naslovPoruke=naslovTextFld.getText();
					
					Date datumSlanjaPoruke= Calendar.getInstance().getTime();
					
					
					String textPoruke=textPorukeTextArea.getText();
					
					Poruka poruka = new Poruka(primalacTextFld.getText(), posiljalac.toString(), datumSlanjaPoruke, naslovPoruke, textPoruke);
					
					//spakuj tom korisniku tu poruku u poruke koje su poslate
					
					posiljalac.getPoslatePoruke().add(poruka);
					
					//dodaj tu poruku u primljene poruke korisnika koji je proveren da li postoji ( drugi korisnik)
					
					korisnik.getPrimljenePoruke().add(poruka);
					
					//prebaci na scenu2
					
					Controller.getInstance().setKorisnik(posiljalac);
					
					scene2 = Controller.getInstance().getSceneTwo();
					
					primaryStage= Controller.getInstance().getPrimaryStage();
			
					primaryStage.setScene(scene2);
					primaryStage.show();
				}
				else {
					Alert alert = new Alert(AlertType.INFORMATION);
					alert.setContentText("Korisnik kome zelite poslati poruku ne postoji!");
					alert.show();
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		
	
		
		
		
		
		

	}

}
