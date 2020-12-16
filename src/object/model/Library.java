package object.model;

import java.util.ArrayList;
import java.util.List;

public class Library {
	
	private String Libelle;
	private List<Livre> livres;
	
	
	public Library(String libelle) {
		Libelle = libelle;
		this.livres = new ArrayList<Livre>();
	}


	public String getLibelle() {
		return Libelle;
	}


	public void setLibelle(String libelle) {
		Libelle = libelle;
	}


	public List<Livre> getLivres() {
		return livres;
	}


	public void addLivres(Livre livre) {
		this.livres.add(livre);
	}
	
	public void removeLivres(int index) {
		this.livres.remove(index);
	}
	
	
}
