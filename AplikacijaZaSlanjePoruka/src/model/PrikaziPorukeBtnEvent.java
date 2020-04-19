package model;

import controller.Controller;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ComboBox;
import view.TabelaPregledOdabranihPoruka;

public class PrikaziPorukeBtnEvent implements EventHandler<javafx.event.ActionEvent> {

	private ComboBox<String> combo;

	private TabelaPregledOdabranihPoruka tabelaOdabranihPoruka;

	public PrikaziPorukeBtnEvent(ComboBox<String> combo, TabelaPregledOdabranihPoruka tabelaOdabranihPoruka) {

		this.combo = combo;
		this.tabelaOdabranihPoruka = tabelaOdabranihPoruka;

	}

	@Override
	public void handle(ActionEvent arg0) {

		// dve razlicite ObservableList-e koje ce se u zavisnosti od izbora u
		// comboBox-u napuniti objektima tipa poruka i kasnije upotrebiti u metodi
		// setItems() za prikaz u TableView
		ObservableList<Poruka> odlaznePoruke = FXCollections.observableArrayList();

		ObservableList<Poruka> dolaznePoruke = FXCollections.observableArrayList();

		if (combo.getSelectionModel().getSelectedItem().equals("Odlazne")) {

			if (!Controller.getInstance().getKorisnik().getPoslatePoruke().isEmpty()) {
				for (Poruka poruka : Controller.getInstance().getScenaDruga().getKorisnik().getPoslatePoruke()) {

					odlaznePoruke.add(poruka);
				}
				tabelaOdabranihPoruka.setItems(odlaznePoruke);

			}
			// ako nema poruka pojavljuje se alert
			else {
				Alert alert = new Alert(AlertType.INFORMATION);
				alert.setContentText("Nema odlaznih poruka");
				alert.show();
			}
		}

		if (combo.getSelectionModel().getSelectedItem().equals("Dolazne")) {

			if (!Controller.getInstance().getKorisnik().getPrimljenePoruke().isEmpty()) {
				for (Poruka poruka : Controller.getInstance().getScenaDruga().getKorisnik().getPrimljenePoruke()) {

					dolaznePoruke.add(poruka);

				}

				tabelaOdabranihPoruka.setItems(dolaznePoruke);
			}
			// ako nema poruka pojavljuje se alert
			else {
				Alert alert = new Alert(AlertType.INFORMATION);
				alert.setContentText("Nema dolaznih poruka");
				alert.show();
			}
		}

	}

}
