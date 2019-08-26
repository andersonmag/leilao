package br.ifal.edu.construtor;

import br.ifal.edu.modelo.Lance;
import br.ifal.edu.modelo.Leilao;
import br.ifal.edu.modelo.Produto;
import br.ifal.edu.modelo.Usuario;

public class CriadorDeLeilao {
	
	private Leilao leilao;
	
	public CriadorDeLeilao() {}

	public CriadorDeLeilao para(Produto produto) {
		this.leilao = new Leilao(produto);
		return this;
	}
	
	public CriadorDeLeilao lance(Usuario usuario, double valor) {
		leilao.propoe(new Lance(usuario, valor));
		return this;
	}
	public Leilao constroi() {
		return leilao;
	}
}
