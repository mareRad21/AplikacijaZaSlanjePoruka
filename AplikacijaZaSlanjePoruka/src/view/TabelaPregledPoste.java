package view;

import java.util.Date;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import model.Poruka;

public class TabelaPregledPoste extends TableView<Poruka> {
	
	public ObservableList<Poruka> data = FXCollections.observableArrayList();
	
	TableColumn<Poruka, String> kolona1 = new TableColumn<Poruka, String>("Primalac");
	TableColumn<Poruka, String> kolona2 = new TableColumn<Poruka, String>("Posiljalac");
	TableColumn<Poruka, Date> kolona3 = new TableColumn<Poruka, Date>("Datum slanja");
}
