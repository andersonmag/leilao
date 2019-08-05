package br.ifal.edu.controle;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import br.ifal.edu.modelo.Lance;
import br.ifal.edu.modelo.Leilao;
import br.ifal.edu.modelo.Usuario;

public class AvaliadorTest {
	
	@Test
	public void teste() {
		
		Usuario usuario = new Usuario("Usuario1");
    	Usuario usuario1 = new Usuario("Usuario2");
    	Usuario usuario2 = new Usuario("Usuario3");
    	
    	Leilao leilao = new Leilao();
    	
    	leilao.propoe(new Lance(usuario, 400.0));
    	leilao.propoe(new Lance(usuario1, 300.0));
    	leilao.propoe(new Lance(usuario2, 250.0));
    	
    	Avaliador avaliador = new Avaliador();
    	avaliador.avalia(leilao);
    	double maiorValorObtido = avaliador.getMaiorLance();
    	double maiorValorEsperado = 400;
    	
    	assertEquals(maiorValorEsperado, maiorValorObtido, 0.001);
    	
	}

}
