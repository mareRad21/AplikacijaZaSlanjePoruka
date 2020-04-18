package model;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import javax.tools.FileObject;

import controller.Controller;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class PosaljiBtnEvent implements EventHandler<javafx.event.ActionEvent> {

	private TextField primalacTextFld;
	private TextField naslovTextFld;
	private TextArea textPorukeTextArea;
	private Scene scene2;
	private Scene scena3;
	private Label labelaScene2;

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
			
			ArrayList<Korisnik> korisniciIzFajla = (ArrayList<Korisnik>) in.readObject();
			in.close();
			Korisnik primalac = new Korisnik(primalacTextFld.getText());
			for (Korisnik korisnik : korisniciIzFajla) {
				if (korisnik.equals(primalac)) {
					String naslovPoruke = naslovTextFld.getText();

					Date datumSlanjaPoruke = Calendar.getInstance().getTime();

					String textPoruke = textPorukeTextArea.getText();

					Poruka poruka = new Poruka(primalac.toString(), Controller.getInstance().getKorisnik().toString(),
							datumSlanjaPoruke, naslovPoruke, textPoruke);


					System.out.println(Controller.getInstance().getKorisnik().getPoslatePoruke().size()
							+ " velicina niza poslatih poruka pre dodavanja");
					
					for(int i = 0 ; i < korisniciIzFajla.size() ; i ++) {
						
						if(korisniciIzFajla.get(i).equals(Controller.getInstance().getKorisnik())) {
							korisniciIzFajla.get(i).getPoslatePoruke().add(poruka);
						}
					}
					
				
					Controller.getInstance().getKorisnik().getPoslatePoruke().add(poruka);

					System.out.println(Controller.getInstance().getKorisnik().getPoslatePoruke().size()
							+ " velicina niza poslatih poruka posle dodavanja");
				
					
					if(korisnik.equals(Controller.getInstance().getScenaTreca().getKorisnik())) {
						Controller.getInstance().getScenaTreca().getKorisnik().getPrimljenePoruke().add(poruka);
					}
					else {
						korisnik.getPrimljenePoruke().add(poruka);
					}
		
					
					
					
					System.out.println(Controller.getInstance().getKorisnik().getPrimljenePoruke().size()
							+ " velicina niza primljenih poruka posle dodavanja");

					System.out.println(Controller.getInstance().getScenaDruga().getKorisnik() + "ovde vidim kog korisnika koristi scena 2");
					
					System.out.println(
							Controller.getInstance().getKorisnik().toString() + " -ovo je korisnik controller-a");

					// Controller.getInstance().getScenaDruga().setKorisnik(Controller.getInstance().getKorisnik());

					System.out.println(Controller.getInstance().getScenaTreca().getKorisnik()+ " ovde vidim kog korisnika koristi scena 3");
					
				
					
					
					
					Controller.getInstance().getScenaDruga().setKorisnik(Controller.getInstance().getKorisnik());
					
					Controller.getInstance().getScenaDruga().getUkupnoPorukaLbl().setText("Ukupno poruka: " + Controller.getInstance().getScenaDruga().getKorisnik().getPrimljenePoruke().size() + " dolazne i "				+ Controller.getInstance().getScenaDruga().getKorisnik().getPoslatePoruke().size() + " odlazne");
					

					ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("korisnici.dat"));
					System.out.println("upisivanje u file");
					out.writeObject(korisniciIzFajla);
					out.flush();

					out.close();

					
					scene2 = Controller.getInstance().getSceneTwo();
					
				//	Controller.getInstance().getScenaDruga().setUkupnoPorukaLbl(new LabelaScene2(Controller.getInstance().getScenaDruga()));
					
					
					
					primaryStage = Controller.getInstance().getPrimaryStage();

					primaryStage.setScene(scene2);
					System.out.println(Controller.getInstance().getScenaDruga().getKorisnik() + "ovde vidim kog korisnika koristi scena 2");
					primaryStage.show();
					return;
				}
			}
			
					Alert alert = new Alert(AlertType.INFORMATION);
					alert.setContentText("Korisnik kome zelite poslati poruku ne postoji!");
					alert.show();

				

		} catch (Exception e) {
			// TODO: handle exception
		}

	}

}
