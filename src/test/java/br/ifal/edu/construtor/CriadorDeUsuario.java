package br.ifal.edu.construtor;
import br.ifal.edu.modelo.Usuario;

public class CriadorDeUsuario {
	
	private Usuario usuario;
	
	public CriadorDeUsuario(){}


	public CriadorDeUsuario Com(String nome, String email) {
		this.usuario = new Usuario(nome, email);
		return this;
	}
	
	public Usuario constroi() {
		return usuario;
	}

}
