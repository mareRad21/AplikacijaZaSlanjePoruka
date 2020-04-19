package model;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.TextArea;
import view.TabelaPregledOdabranihPoruka;

public class PrikaziTextPorukeBtnEvent implements EventHandler<javafx.event.ActionEvent>   {
	
	private TabelaPregledOdabranihPoruka tabelaSaPorukama;
	private TextArea ispisPoruke;
	
	public PrikaziTextPorukeBtnEvent(TabelaPregledOdabranihPoruka tabelaSaPorukama,TextArea ispisPoruke) {
		this.tabelaSaPorukama = tabelaSaPorukama;
		this.ispisPoruke = ispisPoruke;
	}
	
	@Override
	public void handle(ActionEvent event) {
		Poruka izabranaPoruka = tabelaSaPorukama.getSelectionModel().getSelectedItem();
		ispisPoruke.setText(izabranaPoruka.getTextPoruke());
	}
	
}
