package controller;

import model.Korisnik;
import view.Scena1;
import view.Scena2;
import view.Scena3;

public class Controller {

	private static Controller instance = null;

	private Scena1 scena1;
	private Scena2 scena2;
	private Scena3 scena3;

	private Controller() {
		scena1=new Scena1();
		scena2=new Scena2();
		scena3=new Scena3();
		
	}

	public static Controller getInstance() {

		if (instance == null) {

			instance = new Controller();
			return instance;
		}

		return instance;
	}

	public Scena1 getScena1() {
		return scena1;
	}

	public void setScena1(Scena1 scena1) {
		this.scena1 = scena1;
	}

	public Scena2 getScena2() {
		return scena2;
	}

	public void setScena2(Scena2 scena2) {
		this.scena2 = scena2;
	}

	public Scena3 getScena3() {
		return scena3;
	}

	public void setScena3(Scena3 scena3) {
		this.scena3 = scena3;
	}
	
	
}
