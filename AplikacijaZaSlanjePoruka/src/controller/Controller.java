package controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import javafx.scene.Scene;
import javafx.stage.Stage;
import model.Korisnik;
import model.KreirajNovogKorisnikaBtnEvent;
import model.NovaPorukaBtnEvent;
import model.PosaljiBtnEvent;
import model.PregledPorukaBtnEvent;
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
	private PregledPorukaBtnEvent pregledPorukaBtnEvent;
	private NovaPorukaBtnEvent novaPorukaBtnEvent;
	private PosaljiBtnEvent posaljiBtnEvent;
	private Scene sceneOne;
	private Scene sceneTwo;
	private Scene sceneThree;

	private ArrayList<Korisnik> korisniciUFileu = new ArrayList<>();

	private Controller() {


		scenaPrva = new Scena1();
		scenaDruga = new Scena2(korisnik);
		scenaTreca = new Scena3(korisnik);

		sceneOne = new Scene(scenaPrva, 400, 400);

		sceneTwo = new Scene(scenaDruga, 400, 400);

		sceneThree = new Scene(scenaTreca, 400, 400);

		pregledPorukaBtnEvent = new PregledPorukaBtnEvent(scenaPrva.getEmailTextFld());
		novaPorukaBtnEvent = new NovaPorukaBtnEvent();
		posaljiBtnEvent = new PosaljiBtnEvent(scenaTreca.getPrimalacTextFld(), scenaTreca.getNaslovTextFld(),
				scenaTreca.getTextPorukeTextArea());

		try {
			File file = new File("korisnici.dat");
			
			 
			  // kako da stavimo da se ovo izvrsi samo pri prvom pokretanju programa
			
			/*
			 * ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(file));
			 * korisniciUFileu.add(new Korisnik("admin@admin.com"));
			 * out.writeObject(korisniciUFileu);
			 */
			 
			ObjectInputStream in = new ObjectInputStream(new FileInputStream(file));

			try {
				korisniciUFileu = (ArrayList<Korisnik>) in.readObject();

				for (Korisnik k : korisniciUFileu) {
					System.out.println(k);
				}

			} catch (ClassNotFoundException e) {

				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {

			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		kreirajNovogKorisnikaBtnEvent = new KreirajNovogKorisnikaBtnEvent(scenaPrva.getEmailTextFld());
	}

	public static Controller getInstance() {

		if (instance == null) {

			instance = new Controller();
			return instance;
		}

		return instance;
	}

	public ArrayList<Korisnik> getKorisniciUFileu() {
		return korisniciUFileu;
	}

	public void setKorisniciUFileu(ArrayList<Korisnik> korisniciUFileu) {
		this.korisniciUFileu = korisniciUFileu;
	}

	public PosaljiBtnEvent getPosaljiBtnEvent() {
		return posaljiBtnEvent;
	}

	public void setPosaljiBtnEvent(PosaljiBtnEvent posaljiBtnEvent) {
		this.posaljiBtnEvent = posaljiBtnEvent;
	}

	public NovaPorukaBtnEvent getNovaPorukaBtnEvent() {
		return novaPorukaBtnEvent;
	}

	public void setNovaPorukaBtnEvent(NovaPorukaBtnEvent novaPorukaBtnEvent) {
		this.novaPorukaBtnEvent = novaPorukaBtnEvent;
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

	public PregledPorukaBtnEvent getPregledPorukaBtnEvent() {
		return pregledPorukaBtnEvent;
	}

	public void setPregledPorukaBtnEvent(PregledPorukaBtnEvent pregledPorukaBtnEvent) {
		this.pregledPorukaBtnEvent = pregledPorukaBtnEvent;
	}

}
