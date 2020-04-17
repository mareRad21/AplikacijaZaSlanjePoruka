package model;

import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.ArrayList;
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
import view.Scena2;
import view.Scena3;

public class PosaljiBtnEvent implements EventHandler<javafx.event.ActionEvent> {

	private TextField primalacTextFld;
	private TextField naslovTextFld;
	private TextArea textPorukeTextArea;
	private Scene scene2;
	private Scene scena3;

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
			Korisnik primalac = new Korisnik(primalacTextFld.getText());
			for (Korisnik korisnik : korisniciIzFajla) {
				if (korisnik.equals(primalac)) {
					String naslovPoruke = naslovTextFld.getText();

					Date datumSlanjaPoruke = Calendar.getInstance().getTime();

					String textPoruke = textPorukeTextArea.getText();

					Poruka poruka = new Poruka(primalac.toString(), Controller.getInstance().getKorisnik().toString(),
							datumSlanjaPoruke, naslovPoruke, textPoruke);

					// spakuj tom korisniku tu poruku u poruke koje su poslate

					Controller.getInstance().getKorisnik().getPoslatePoruke().add(poruka);

					// dodaj tu poruku u primljene poruke korisnika koji je proveren da li postoji (
					// drugi korisnik)

					korisnik.getPrimljenePoruke().add(poruka);

					// prebaci na scenu2

					System.out.println(
							Controller.getInstance().getKorisnik().toString() + " -ovo je korisnik controller-a");

					scene2 = Controller.getInstance().getSceneTwo();
					Controller.getInstance().getScenaDruga().setKorisnik(Controller.getInstance().getKorisnik());
					primaryStage = Controller.getInstance().getPrimaryStage();

					primaryStage.setScene(scene2);
					primaryStage.show();
				} else {
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
