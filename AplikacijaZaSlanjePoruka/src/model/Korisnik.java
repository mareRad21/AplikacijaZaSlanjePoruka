package model;

import java.io.Serializable;
import java.util.ArrayList;

public class Korisnik  implements Serializable{

	
	private String email;

	private ArrayList<Poruka> primljenePoruke;
	private ArrayList<Poruka> poslatePoruke;
	
	public Korisnik (String email) {
		this.email=email;
		this.primljenePoruke= new ArrayList<>();
		this.poslatePoruke= new ArrayList<>();
		
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public ArrayList<Poruka> getPrimljenePoruke() {
		return primljenePoruke;
	}

	public void setPrimljenePoruke(ArrayList<Poruka> primljenePoruke) {
		this.primljenePoruke = primljenePoruke;
	}

	public ArrayList<Poruka> getPoslatePoruke() {
		return poslatePoruke;
	}

	public void setPoslatePoruke(ArrayList<Poruka> poslatePoruke) {
		this.poslatePoruke = poslatePoruke;
	}
	@Override
	public String toString() {
		
		return email;
	}
}
