package br.ifal.edu.modelo;

import java.util.ArrayList;

public class Leilao {
	
	private ArrayList<Lance> lances;
	private Produto produto;

	public Leilao() {
		this.lances = new ArrayList<Lance>();
	}
	
	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public ArrayList<Lance> getLances() {
		return lances;
	}

	public void setLances(ArrayList<Lance> lances) {
		this.lances = lances;
	}
	
	public void propoe(Lance lance) {
		lances.add(lance);
	}
	

}
