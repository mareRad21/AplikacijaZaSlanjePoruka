package model;

import controller.Controller;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Alert.AlertType;
import view.Scena2;
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

		ObservableList<Poruka> odlaznePoruke = FXCollections.observableArrayList();

		ObservableList<Poruka> dolaznePoruke = FXCollections.observableArrayList();

		if (combo.getSelectionModel().getSelectedItem().equals("Odlazne")) {

			if (!Controller.getInstance().getKorisnik().getPoslatePoruke().isEmpty()) {
				for (Poruka poruka : Controller.getInstance().getScenaDruga().getKorisnik().getPoslatePoruke()) {

					odlaznePoruke.add(poruka);
					System.out.println("puni poruke");
				}
				tabelaOdabranihPoruka.setItems(odlaznePoruke);
				System.out.println("pozvan odlazni action event");
				System.out.println(Controller.getInstance().getKorisnik());

			}
			else {
				Alert alert = new Alert(AlertType.INFORMATION);
				alert.setContentText("Nema tih poruka");
				alert.show();
			}
		}

		if (combo.getSelectionModel().getSelectedItem().equals("Dolazne")) {

			if (!Controller.getInstance().getKorisnik().getPrimljenePoruke().isEmpty()) {
				for (Poruka poruka : Controller.getInstance().getScenaDruga().getKorisnik().getPrimljenePoruke()) {

					dolaznePoruke.add(poruka);
					System.out.println("puni poruke");

				}

				tabelaOdabranihPoruka.setItems(dolaznePoruke);
				System.out.println("pozvan dolazni action event");
				System.out.println(Controller.getInstance().getKorisnik());
			}
			else {
				Alert alert = new Alert(AlertType.INFORMATION);
				alert.setContentText("Nema tih poruka");
				alert.show();
			}
		}

	}

}
