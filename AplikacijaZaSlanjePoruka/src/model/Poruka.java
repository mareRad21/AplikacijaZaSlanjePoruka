package model;

import java.io.Serializable;
import java.util.Date;

public class Poruka implements Serializable{

	
	
	String primalac;
	String posiljalac;
	Date datumSlanjaPoruke;
	String naslovPoruke;
	String textPoruke;
	
	public Poruka(String primalac , String posiljalac , Date datumSlanjaPoruke , String naslovPoruke , String textPoruke) {
		
		this.primalac= primalac;
		this.posiljalac= posiljalac;
		this.datumSlanjaPoruke= datumSlanjaPoruke;
		this.naslovPoruke= naslovPoruke;
		this.textPoruke= textPoruke;
		
	}

	public String getPrimalac() {
		return primalac;
	}

	public void setPrimalac(String primalac) {
		this.primalac = primalac;
	}

	public String getPosiljalac() {
		return posiljalac;
	}

	public void setPosiljalac(String posiljalac) {
		this.posiljalac = posiljalac;
	}

	public Date getDatumSlanjaPoruke() {
		return datumSlanjaPoruke;
	}

	public void setDatumSlanjaPoruke(Date datumSlanjaPoruke) {
		this.datumSlanjaPoruke = datumSlanjaPoruke;
	}

	public String getNaslovPoruke() {
		return naslovPoruke;
	}

	public void setNaslovPoruke(String naslovPoruke) {
		this.naslovPoruke = naslovPoruke;
	}

	public String getTextPoruke() {
		return textPoruke;
	}

	public void setTextPoruke(String textPoruke) {
		this.textPoruke = textPoruke;
	}
	
	
}
