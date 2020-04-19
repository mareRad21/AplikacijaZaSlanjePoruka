package view;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import model.Korisnik;

public class Scena2 extends BorderPane{
	private Label ukupnoPorukaLbl;
	private HBox hBoxZaLabeluUkupnoPoruka;
	private ComboBox<String> comboTipPoruka;
	private Button prikaziBtn;
	private HBox hBoxZaComboIDugmeTop;

	
	
	private TabelaPregledOdabranihPoruka tabelaPoruka ;
	private Button prikaziTekstBtn;
	private HBox hBoxZaPrikaziTextBtn;
	private TextArea textPoruke;
	private Button novaPorukaBtn;
	private HBox hBoxZaNovaPorukaBtn;
	
	
	private VBox vBoxZaSveKomponenteScena2;
	
	
	
	private Korisnik korisnik;

	
	

	public Scena2() {
		
		
		ukupnoPorukaLbl = new Label();
		ObservableList<String> comboBoxDelovi = FXCollections.observableArrayList("Odlazne", "Dolazne");
		comboTipPoruka = new ComboBox<>(comboBoxDelovi);
		comboTipPoruka.setValue(comboBoxDelovi.get(0));
		prikaziBtn = new Button("Prikazi");
		
		

		prikaziTekstBtn = new Button("Prikazi tekst");
		textPoruke = new TextArea();

		novaPorukaBtn = new Button("Nova poruka");
		hBoxZaLabeluUkupnoPoruka = new HBox();
		hBoxZaLabeluUkupnoPoruka.setAlignment(Pos.CENTER);
		hBoxZaLabeluUkupnoPoruka.setMargin(ukupnoPorukaLbl, new Insets(15, 15, 5, 15));
		hBoxZaLabeluUkupnoPoruka.getChildren().add(ukupnoPorukaLbl);
		
		hBoxZaComboIDugmeTop = new HBox();
		hBoxZaComboIDugmeTop.setAlignment(Pos.CENTER);
		hBoxZaComboIDugmeTop.setMargin(comboTipPoruka, new Insets(15, 5, 15, 10));
		hBoxZaComboIDugmeTop.setMargin(prikaziBtn, new Insets(15, 10, 15, 5));
		hBoxZaComboIDugmeTop.getChildren().addAll(comboTipPoruka,prikaziBtn);
		
		hBoxZaPrikaziTextBtn = new HBox();
		hBoxZaPrikaziTextBtn.setAlignment(Pos.CENTER);
		hBoxZaPrikaziTextBtn.setMargin(prikaziTekstBtn, new Insets(10, 10, 10, 10));
		hBoxZaPrikaziTextBtn.getChildren().add(prikaziTekstBtn);
		
		hBoxZaNovaPorukaBtn = new HBox();
		hBoxZaNovaPorukaBtn.setAlignment(Pos.CENTER);
		hBoxZaNovaPorukaBtn.setMargin(novaPorukaBtn, new Insets(15, 15, 15, 15));
		hBoxZaNovaPorukaBtn.getChildren().add(novaPorukaBtn);
		
		tabelaPoruka = new TabelaPregledOdabranihPoruka();
		vBoxZaSveKomponenteScena2 = new VBox();
		
		vBoxZaSveKomponenteScena2.getChildren().addAll(hBoxZaLabeluUkupnoPoruka , hBoxZaComboIDugmeTop , tabelaPoruka , hBoxZaPrikaziTextBtn ,textPoruke ,hBoxZaNovaPorukaBtn );
		setCenter(vBoxZaSveKomponenteScena2);
		

	}


	public Label getUkupnoPorukaLbl() {
		return ukupnoPorukaLbl;
	}


	public void setUkupnoPorukaLbl(Label ukupnoPorukaLbl) {
		this.ukupnoPorukaLbl = ukupnoPorukaLbl;
	}


	public ComboBox<String> getComboTipPoruka() {
		return comboTipPoruka;
	}


	public void setComboTipPoruka(ComboBox<String> comboTipPoruka) {
		this.comboTipPoruka = comboTipPoruka;
	}


	public Button getPrikaziBtn() {
		return prikaziBtn;
	}


	public void setPrikaziBtn(Button prikaziBtn) {
		this.prikaziBtn = prikaziBtn;
	}


	public TabelaPregledOdabranihPoruka getTabelaPoruka() {
		return tabelaPoruka;
	}


	public void setTabelaPoruka(TabelaPregledOdabranihPoruka tabelaPoruka) {
		this.tabelaPoruka = tabelaPoruka;
	}


	public Button getPrikaziTekstBtn() {
		return prikaziTekstBtn;
	}


	public void setPrikaziTekstBtn(Button prikaziTekstBtn) {
		this.prikaziTekstBtn = prikaziTekstBtn;
	}


	public TextArea getTextPoruke() {
		return textPoruke;
	}


	public void setTextPoruke(TextArea textPoruke) {
		this.textPoruke = textPoruke;
	}


	public Button getNovaPorukaBtn() {
		return novaPorukaBtn;
	}


	public void setNovaPorukaBtn(Button novaPorukaBtn) {
		this.novaPorukaBtn = novaPorukaBtn;
	}


	public Korisnik getKorisnik() {
		return korisnik;
	}


	public void setKorisnik(Korisnik korisnik) {
		this.korisnik = korisnik;
	}
	
	


}
