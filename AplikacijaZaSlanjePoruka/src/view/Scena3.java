package view;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

public class Scena3 extends GridPane {
	private Label primalacLbl;
	private TextField primalacTextFld;
	private Label naslovLbl;
	private TextField naslovTextFld;
	private Label textPorukeLbl;
	private TextArea textPorukeTextArea;
	private Button posaljiBtn;
	
	public Scena3() {
		setPadding(new Insets(15, 15, 15, 15));
        setVgap(8);
        setHgap(10);
        
        //prvi red
        primalacLbl = new Label("Primalac: ");
        primalacTextFld = new TextField();
        setConstraints(primalacLbl, 0, 0);
        setConstraints(primalacTextFld, 1, 0);
        //drugi red
        naslovLbl = new Label("Naslov: ");
        naslovTextFld = new TextField();
        setConstraints(naslovLbl, 0, 1);
        setConstraints(naslovTextFld, 1, 1);
        //treci red
        textPorukeLbl = new Label("Tekst poruke:");
	}

	public Label getPrimalacLbl() {
		return primalacLbl;
	}

	public void setPrimalacLbl(Label primalacLbl) {
		this.primalacLbl = primalacLbl;
	}

	public TextField getPrimalacTextFld() {
		return primalacTextFld;
	}

	public void setPrimalacTextFld(TextField primalacTextFld) {
		this.primalacTextFld = primalacTextFld;
	}

	public Label getNaslovLbl() {
		return naslovLbl;
	}

	public void setNaslovLbl(Label naslovLbl) {
		this.naslovLbl = naslovLbl;
	}

	public TextField getNaslovTextFld() {
		return naslovTextFld;
	}

	public void setNaslovTextFld(TextField naslovTextFld) {
		this.naslovTextFld = naslovTextFld;
	}

	public Label getTextPorukeLbl() {
		return textPorukeLbl;
	}

	public void setTextPorukeLbl(Label textPorukeLbl) {
		this.textPorukeLbl = textPorukeLbl;
	}

	public TextArea getTextPorukeTextArea() {
		return textPorukeTextArea;
	}

	public void setTextPorukeTextArea(TextArea textPorukeTextArea) {
		this.textPorukeTextArea = textPorukeTextArea;
	}

	public Button getPosaljiBtn() {
		return posaljiBtn;
	}

	public void setPosaljiBtn(Button posaljiBtn) {
		this.posaljiBtn = posaljiBtn;
	}
	
	
}
