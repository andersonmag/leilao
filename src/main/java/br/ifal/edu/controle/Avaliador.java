package br.ifal.edu.controle;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import br.ifal.edu.modelo.Lance;
import br.ifal.edu.modelo.Leilao;

public class Avaliador {

	private double maiorDeTodos = Double.NEGATIVE_INFINITY;
	private double menorDeTodos = Double.POSITIVE_INFINITY;
	private List<Lance> top3MaioresLances;

	public void avalia(Leilao leilao ) {
		for (Lance lance : leilao.getLances()) {
			if(lance.getValor() > maiorDeTodos) {
				maiorDeTodos = lance.getValor();
			}if(lance.getValor() < menorDeTodos) {
				menorDeTodos = lance.getValor();
			}
		} 
	}

	public void setTop3Lances(Leilao leilao) {
		top3MaioresLances = new ArrayList<Lance>(leilao.getLances());
		Collections.sort(top3MaioresLances,new Comparator<Lance>() {
			public int compare(Lance o1, Lance o2) {

				if(o1.getValor() < o2.getValor()) return 1;
				if(o1.getValor() > o2.getValor()) return -1;
				return 0;
			}
		});
		switch (top3MaioresLances.size()) {
		case 0:
			top3MaioresLances = top3MaioresLances.subList(0, 0);

			break;
		case 1:
			top3MaioresLances = top3MaioresLances.subList(0, 1);
			
			break;
		case 2:
			top3MaioresLances = top3MaioresLances.subList(0, 2);
			
			break;
		default:
			top3MaioresLances = top3MaioresLances.subList(0, 3);
			
			break;
		}
		
//		top3MaioresLances.subList(0, top3MaioresLances.size() > 3 ? 3 : top3MaioresLances.size());
		
	}

	public double getMaiorLance() {
		return maiorDeTodos;
	}

	public double getMenorLance() {
		return menorDeTodos;
	}

	public List<Lance> getTop3MaioresLances() {
		return top3MaioresLances;
	}

}
