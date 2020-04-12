package view;

import java.util.ArrayList;
import java.util.Date;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import model.Korisnik;
import model.Poruka;

public class TabelaPregledOdabranihPoruka extends TableView<Poruka> {
	
	public ObservableList<Poruka> data = FXCollections.observableArrayList();
	
	TableColumn kolona1 = new TableColumn("Primalac");
	TableColumn kolona2 = new TableColumn("Posiljalac");
	TableColumn kolona3 = new TableColumn("Datum slanja");
	TableColumn kolona4 = new TableColumn("Naslov");
	
	public TabelaPregledOdabranihPoruka(ArrayList<Poruka> listaPoruka) {
		
		
		getColumns().addAll(kolona1,kolona2,kolona3,kolona4);
		kolona1.prefWidthProperty().bind(this.widthProperty().multiply(0.3));
		kolona2.prefWidthProperty().bind(this.widthProperty().multiply(0.3));
		kolona3.prefWidthProperty().bind(this.widthProperty().multiply(0.2));
		kolona4.prefWidthProperty().bind(this.widthProperty().multiply(0.2));
		
		for(Poruka poruka :listaPoruka) {
	
		kolona1.setCellValueFactory(new PropertyValueFactory<Poruka, String>("primalacSimpleString"));
		
		kolona2.setCellValueFactory(new PropertyValueFactory<Poruka, String>("posiljalacSimpleString"));
		
		kolona3.setCellValueFactory(new PropertyValueFactory<Poruka, String>("datumSlanjaPorukaSimpleString"));
		
		kolona4.setCellValueFactory(new PropertyValueFactory<Poruka, String>("naslovPorukeSimpleString"));
		
		data.add(poruka);
		
		}
		setItems(data);
	}
	
	
}
