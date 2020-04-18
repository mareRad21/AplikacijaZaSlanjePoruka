package model;

import java.io.Serializable;
import java.util.ArrayList;

public class Korisnik  implements Serializable{

	
	private String email;

	private ArrayList<Poruka> primljenePoruke= new ArrayList<>();
	private ArrayList<Poruka> poslatePoruke= new ArrayList<>();
	
	public Korisnik (String email) {
		this.email=email;
		
		
		
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
	
	@Override
	public int hashCode() {
		
		int zbirKaraktera=0;
		String ee = this.email.trim();
		char [] nizChara= ee.toCharArray();
		for(int i = 0 ; i <nizChara.length ; i++) {
			zbirKaraktera+=nizChara[i] * (i+1);
			
		}
		
		return zbirKaraktera;
	}
	
	
	
	@Override
	public boolean equals(Object obj) {
		
		return this.hashCode()==obj.hashCode();

	}
	
}
