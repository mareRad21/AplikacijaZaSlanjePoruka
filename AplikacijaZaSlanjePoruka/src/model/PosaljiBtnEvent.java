package model;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

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
			// iscitavanje file-a i izvlacenje korisnika kome se salje poruka

			

			ArrayList<Korisnik> korisniciIzFajla = Controller.getInstance().getKorisniciUFileu();
			Korisnik primalac = new Korisnik(primalacTextFld.getText());
			for (Korisnik korisnik : korisniciIzFajla) {
				if (korisnik.equals(primalac)) {

					// pravljenje novog objekta tipa Poruka koji se kasnije dodaje u kolekciju
					// Korisnika koji salje i koji prima poruke

					Poruka poruka = new Poruka(primalac.toString(), Controller.getInstance().getKorisnik().toString(),
							Calendar.getInstance().getTime(), naslovTextFld.getText(), textPorukeTextArea.getText());

					for (int i = 0; i < korisniciIzFajla.size(); i++) {

						if (korisniciIzFajla.get(i).equals(Controller.getInstance().getKorisnik())) {
							korisniciIzFajla.get(i).getPoslatePoruke().add(poruka);
						}
					}

					

					if (korisnik.equals(Controller.getInstance().getScenaTreca().getKorisnik())) {
						Controller.getInstance().getScenaTreca().getKorisnik().getPrimljenePoruke().add(poruka);
					} else {
						korisnik.getPrimljenePoruke().add(poruka);
					}

					Controller.getInstance().getScenaDruga().setKorisnik(Controller.getInstance().getKorisnik());

					Controller.getInstance().getScenaDruga().getUkupnoPorukaLbl()
							.setText("Ukupno poruka: "
									+ Controller.getInstance().getScenaDruga().getKorisnik().getPrimljenePoruke().size()
									+ " dolazne i "
									+ Controller.getInstance().getScenaDruga().getKorisnik().getPoslatePoruke().size()
									+ " odlazne");

					ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("korisnici.dat"));
					out.writeObject(korisniciIzFajla);
					out.flush();
					out.close();

					scene2 = Controller.getInstance().getSceneTwo();
					primaryStage = Controller.getInstance().getPrimaryStage();
					primaryStage.setScene(scene2);
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
