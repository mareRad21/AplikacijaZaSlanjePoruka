package controller;

import javafx.scene.Scene;
import javafx.stage.Stage;
import model.Korisnik;
import model.KreirajNovogKorisnikaBtnEvent;
import view.Scena1;
import view.Scena2;
import view.Scena3;

public class Controller {

	private static Controller instance = null;

	private Scena1 scenaPrva;
	private Scena2 scenaDruga;
	private Scena3 scenaTreca;
	private Korisnik korisnik = new Korisnik(null);
	private Stage primaryStage = new Stage();
	
	
	private KreirajNovogKorisnikaBtnEvent kreirajNovogKorisnikaBtnEvent;
	
	private Scene sceneOne;
	private Scene sceneTwo;
	private Scene sceneThree;
	
	private Controller() {
		
		scenaPrva=new Scena1();
		scenaDruga=new Scena2(korisnik);
		scenaTreca=new Scena3();
		
		
		 sceneOne = new Scene(scenaPrva, 400, 400);

		 sceneTwo = new Scene(scenaDruga, 400, 400);

		 sceneThree = new Scene(scenaTreca, 400, 400);
		 
		 kreirajNovogKorisnikaBtnEvent = new KreirajNovogKorisnikaBtnEvent(scenaPrva.getEmailTextFld());
		
	}

	public static Controller getInstance() {

		if (instance == null) {

			instance = new Controller();
			return instance;
		}

		return instance;
	}

	

	public KreirajNovogKorisnikaBtnEvent getKreirajNovogKorisnikaBtnEvent() {
		return kreirajNovogKorisnikaBtnEvent;
	}

	public void setKreirajNovogKorisnikaBtnEvent(KreirajNovogKorisnikaBtnEvent kreirajNovogKorisnikaBtnEvent) {
		this.kreirajNovogKorisnikaBtnEvent = kreirajNovogKorisnikaBtnEvent;
	}

	public Scene getSceneOne() {
		return sceneOne;
	}

	public void setSceneOne(Scene sceneOne) {
		this.sceneOne = sceneOne;
	}

	public Scene getSceneTwo() {
		return sceneTwo;
	}

	public void setSceneTwo(Scene sceneTwo) {
		this.sceneTwo = sceneTwo;
	}

	public Scene getSceneThree() {
		return sceneThree;
	}

	public void setSceneThree(Scene sceneThree) {
		this.sceneThree = sceneThree;
	}

	public Scena1 getScenaPrva() {
		return scenaPrva;
	}

	public void setScenaPrva(Scena1 scenaPrva) {
		this.scenaPrva = scenaPrva;
	}

	public Scena2 getScenaDruga() {
		return scenaDruga;
	}

	public void setScenaDruga(Scena2 scenaDruga) {
		this.scenaDruga = scenaDruga;
	}

	public Scena3 getScenaTreca() {
		return scenaTreca;
	}

	public void setScenaTreca(Scena3 scenaTreca) {
		this.scenaTreca = scenaTreca;
	}

	public Korisnik getKorisnik() {
		return korisnik;
	}

	public void setKorisnik(Korisnik korisnik) {
		this.korisnik = korisnik;
	}

	public Stage getPrimaryStage() {
		return primaryStage;
	}

	public void setPrimaryStage(Stage primaryStage) {
		this.primaryStage = primaryStage;
	}
	
	
}
