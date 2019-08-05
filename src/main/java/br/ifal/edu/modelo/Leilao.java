package br.ifal.edu.modelo;

import java.util.ArrayList;

public class Leilao {
	
	private ArrayList<Lance> lances;
	
	public Leilao() {
		
		this.lances = new ArrayList<Lance>();
		
	}
	

	public ArrayList<Lance> getLances() {
		return lances;
	}

	public void setLances(ArrayList<Lance> lances) {
		this.lances = lances;
	}
	

}
