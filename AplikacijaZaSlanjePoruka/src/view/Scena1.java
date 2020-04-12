package view;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;

public class Scena1 extends BorderPane {
	
	private Label emailLbl;
	private TextField emailTextFld;
	private Button pregledPorukaBtn;
	private Button kreirajNovogKorisnikaBtn;
	private HBox scena1Hbox;
	
	public Scena1() {
		emailLbl = new Label("Unesite svoj email:");
		emailTextFld = new TextField();
		pregledPorukaBtn = new Button("Pregled poruka");
		kreirajNovogKorisnikaBtn= new Button("Kreiraj novog korisnika");
		scena1Hbox = new HBox();
		scena1Hbox.setMargin(emailLbl, new Insets(30, 10, 30, 20));
		scena1Hbox.setMargin(emailTextFld, new Insets(30, 10, 30, 10));
		scena1Hbox.setMargin(pregledPorukaBtn, new Insets(30, 20, 30, 10));
		scena1Hbox.setMargin(kreirajNovogKorisnikaBtn, new Insets(30, 20, 30, 10));
		
		scena1Hbox.getChildren().addAll(emailLbl,emailTextFld,pregledPorukaBtn,kreirajNovogKorisnikaBtn);
		setCenter(scena1Hbox);
	}

	public Label getEmailLbl() {
		return emailLbl;
	}

	public void setEmailLbl(Label emailLbl) {
		this.emailLbl = emailLbl;
	}

	public TextField getEmailTextFld() {
		return emailTextFld;
	}

	public void setEmailTextFld(TextField emailTextFld) {
		this.emailTextFld = emailTextFld;
	}

	public Button getPregledPorukaBtn() {
		return pregledPorukaBtn;
	}

	public void setPregledPorukaBtn(Button pregledPorukaBtn) {
		this.pregledPorukaBtn = pregledPorukaBtn;
	}

	public HBox getScena1Hbox() {
		return scena1Hbox;
	}

	public void setScena1Hbox(HBox scena1Hbox) {
		this.scena1Hbox = scena1Hbox;
	}

	public Button getKreirajNovogKorisnikaBtn() {
		return kreirajNovogKorisnikaBtn;
	}

	public void setKreirajNovogKorisnikaBtn(Button kreirajNovogKorisnikaBtn) {
		this.kreirajNovogKorisnikaBtn = kreirajNovogKorisnikaBtn;
	}
	
	
}
