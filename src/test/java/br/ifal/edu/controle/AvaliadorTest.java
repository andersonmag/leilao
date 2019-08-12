package br.ifal.edu.controle;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;

import br.ifal.edu.modelo.Lance;
import br.ifal.edu.modelo.Leilao;
import br.ifal.edu.modelo.Usuario;

public class AvaliadorTest {
	
	@Test
	public void avaliadorDeveFuncionarComLancesEmOrdemAleatoria() {
		
		Usuario usuario = new Usuario("Usuario1");
    	Usuario usuario1 = new Usuario("Usuario2");
    	Usuario usuario2 = new Usuario("Usuario3");
    	
    	Leilao leilao = new Leilao();
    	
    	leilao.propoe(new Lance(usuario, 300.0));
    	leilao.propoe(new Lance(usuario1, 400.0));
    	leilao.propoe(new Lance(usuario2, 250.0));
    	
    	Avaliador avaliador = new Avaliador();
    	avaliador.avalia(leilao);
    	double maiorLanceObtido = avaliador.getMaiorLance();
    	double maiorLanceEsperado = 400;
    	
    	double menorLanceObtido = avaliador.getMenorLance();
    	double menorLanceEsperado = 250;
    	
    	assertEquals(maiorLanceEsperado, maiorLanceObtido, 0.001);
    	assertEquals(menorLanceEsperado, menorLanceObtido, 0.001);
    	
	}
	
	@Test
	public void avaliadorDeveFuncionarComLancesEmOrdemCrescente() {

		Usuario usuario = new Usuario("Usuario1");
    	Usuario usuario1 = new Usuario("Usuario2");
    	Usuario usuario2 = new Usuario("Usuario3");
    	
    	Leilao leilao = new Leilao();
    	
    	leilao.propoe(new Lance(usuario, 250.0));
    	leilao.propoe(new Lance(usuario1, 300.0));
    	leilao.propoe(new Lance(usuario2, 400.0));
    	
    	Avaliador avaliador = new Avaliador();
    	avaliador.avalia(leilao);
    	double maiorLanceObtido = avaliador.getMaiorLance();
    	double maiorLanceEsperado = 400;
    	
    	double menorLanceObtido = avaliador.getMenorLance();
    	double menorLanceEsperado = 250;
    	
    	assertEquals(maiorLanceEsperado, maiorLanceObtido, 0.001);
    	assertEquals(menorLanceEsperado, menorLanceObtido, 0.001);
    	
	}

	@Test
	public void avaliadorDeveFuncionarComLancesEmOrdemDecrescente() {

		Usuario usuario = new Usuario("Usuario1");
    	Usuario usuario1 = new Usuario("Usuario2");
    	Usuario usuario2 = new Usuario("Usuario3");
    	
    	Leilao leilao = new Leilao();
    	
    	leilao.propoe(new Lance(usuario, 400.0));
    	leilao.propoe(new Lance(usuario1, 300.0));
    	leilao.propoe(new Lance(usuario2, 250.0));
    	
    	Avaliador avaliador = new Avaliador();
    	avaliador.avalia(leilao);
    	double maiorLanceObtido = avaliador.getMaiorLance();
    	double maiorLanceEsperado = 400;
    	
    	double menorLanceObtido = avaliador.getMenorLance();
    	double menorLanceEsperado = 250;
    	
    	assertEquals(maiorLanceEsperado, maiorLanceObtido, 0.001);
    	assertEquals(menorLanceEsperado, menorLanceObtido, 0.001);
    	
	}
	
	@Test
	public void top3DeveFuncionarComLancesComQuantidadeIgualA4() {
		
		Usuario usuario = new Usuario("Usuario1");
    	Usuario usuario1 = new Usuario("Usuario2");
    	Usuario usuario2 = new Usuario("Usuario3");
    	Usuario usuario3 = new Usuario("Usuario3");
    	
    	Leilao leilao = new Leilao();
    	
    	leilao.propoe(new Lance(usuario, 300.0));
    	leilao.propoe(new Lance(usuario1, 400.0));
    	leilao.propoe(new Lance(usuario2, 250.0));
    	leilao.propoe(new Lance(usuario3, 500.0));
 
    	Avaliador avaliador = new Avaliador();
    	avaliador.setTop3Lances(leilao);
    	List<Lance> top3 = avaliador.getTop3MaioresLances();
    	double primeiroLanceObtido = top3.get(0).getValor();
    	double segundoLanceObtido = top3.get(1).getValor();
    	double terceiroLanceObtido = top3.get(2).getValor();

    	double primeiroLanceEsperado = 500.0;
    	double segundoLanceEsperado = 400.0;
    	double terceiroLanceEsperado = 300.0;
    	int tamanhoTop3Esperado = 3;
    	int tamanhoTop3Obtido = top3.size();
    	
    	assertEquals(primeiroLanceEsperado,primeiroLanceObtido, 0.1);
    	assertEquals(segundoLanceEsperado, segundoLanceObtido, 0.1);
    	assertEquals(terceiroLanceEsperado,terceiroLanceObtido, 0.1);
    	assertEquals(tamanhoTop3Esperado, tamanhoTop3Obtido);
	
	}
	
	@Test
	public void top3DeveFuncionarComQuantidadeDeLancesIgualA1() {
		
		Usuario usuario = new Usuario("Usuario1");
    	
    	Leilao leilao = new Leilao();
    	
    	leilao.propoe(new Lance(usuario, 250.0));
 
    	Avaliador avaliador = new Avaliador();
    	avaliador.setTop3Lances(leilao);
    	List<Lance> top3 = avaliador.getTop3MaioresLances();
    	double primeiroLanceObtido = top3.get(0).getValor();

    	double primeiroLanceEsperado = 250.0;
    	int tamanhoTop3Esperado = 3;
    	int tamanhoTop3Obtido = top3.size();
    	
    	assertEquals(primeiroLanceEsperado,primeiroLanceObtido, 0.1);
    	assertEquals(tamanhoTop3Esperado, tamanhoTop3Obtido);
	
	}
	@Test
	public void top3DeveFuncionarComQuantidadeDeLancesIgualA2() {
		
		Usuario usuario = new Usuario("Usuario1");
    	Usuario usuario1 = new Usuario("Usuario2");
    	
    	Leilao leilao = new Leilao();
    	
    	leilao.propoe(new Lance(usuario, 250.0));
    	leilao.propoe(new Lance(usuario1, 300.0));
 
    	Avaliador avaliador = new Avaliador();
    	avaliador.setTop3Lances(leilao);
    	List<Lance> top3 = avaliador.getTop3MaioresLances();
    	double primeiroLanceObtido = top3.get(0).getValor();
    	double segundoLanceObtido = top3.get(1).getValor();

    	double primeiroLanceEsperado = 300.0;
    	double segundoLanceEsperado = 250.0;
    	int tamanhoTop3Esperado = 3;
    	int tamanhoTop3Obtido = top3.size();
    	
    	assertEquals(primeiroLanceEsperado,primeiroLanceObtido, 0.1);
    	assertEquals(segundoLanceEsperado, segundoLanceObtido, 0.1);
    	assertEquals(tamanhoTop3Esperado, tamanhoTop3Obtido);
	
	}
	
	@Test
	public void top3DeveFuncionarComQuantidadeDeLancesIgualA0() {
    	
    	Leilao leilao = new Leilao();
 
    	Avaliador avaliador = new Avaliador();
    	avaliador.setTop3Lances(leilao);
    	List<Lance> top3 = avaliador.getTop3MaioresLances();

    	int tamanhoTop3Esperado = 3;
    	int tamanhoTop3Obtido = top3.size();

    	assertEquals(tamanhoTop3Esperado, tamanhoTop3Obtido);
	
	}
	
	@Test
	public void top3DeveFuncionarComQuantidadeDeLancesIguais() {
		
		Usuario usuario = new Usuario("Usuario1");
    	Usuario usuario1 = new Usuario("Usuario2");
    	Usuario usuario2 = new Usuario("Usuario2");
    	
    	Leilao leilao = new Leilao();
    	
    	leilao.propoe(new Lance(usuario, 300.0));
    	leilao.propoe(new Lance(usuario1, 300.0));
    	leilao.propoe(new Lance(usuario2, 300.0));
 
    	Avaliador avaliador = new Avaliador();
    	avaliador.setTop3Lances(leilao);
    	List<Lance> top3 = avaliador.getTop3MaioresLances();
    	double primeiroLanceObtido = top3.get(0).getValor();
    	double segundoLanceObtido = top3.get(1).getValor();
    	double terceiroLanceObtido = top3.get(2).getValor();

    	double primeiroLanceEsperado = 300.0;
    	double segundoLanceEsperado = 300.0;
    	double terceiroLanceEsperado = 300.0;
    	int tamanhoTop3Esperado = 3;
    	int tamanhoTop3Obtido = top3.size();
    	
    	assertEquals(primeiroLanceEsperado,primeiroLanceObtido, 0.1);
    	assertEquals(segundoLanceEsperado, segundoLanceObtido, 0.1);
    	assertEquals(terceiroLanceEsperado, terceiroLanceObtido, 0.1);
    	assertEquals(tamanhoTop3Esperado, tamanhoTop3Obtido);
	
	}
	
	@Test
	public void top3DeveFuncionarComLancesEmOrdemDecrescente() {
		
		Usuario usuario = new Usuario("Usuario1");
    	Usuario usuario1 = new Usuario("Usuario2");
    	Usuario usuario2 = new Usuario("Usuario3");
    	
    	Leilao leilao = new Leilao();
    	
    	leilao.propoe(new Lance(usuario, 400.0));
    	leilao.propoe(new Lance(usuario1, 300));
    	leilao.propoe(new Lance(usuario2, 250.0));
 
    	Avaliador avaliador = new Avaliador();
    	avaliador.setTop3Lances(leilao);
    	List<Lance> top3 = avaliador.getTop3MaioresLances();
    	double primeiroLanceObtido = top3.get(0).getValor();
    	double segundoLanceObtido = top3.get(1).getValor();
    	double terceiroLanceObtido = top3.get(2).getValor();

    	double primeiroLanceEsperado = 400.0;
    	double segundoLanceEsperado = 300.0;
    	double terceiroLanceEsperado = 250.0;
    	int tamanhoTop3Esperado = 3;
    	int tamanhoTop3Obtido = top3.size();
    	
    	assertEquals(primeiroLanceEsperado,primeiroLanceObtido, 0.1);
    	assertEquals(segundoLanceEsperado, segundoLanceObtido, 0.1);
    	assertEquals(terceiroLanceEsperado,terceiroLanceObtido, 0.1);
    	assertEquals(tamanhoTop3Esperado, tamanhoTop3Obtido);
	
	}
	@Test
	public void top3DeveFuncionarComLancesEmOrdemCrescente() {
		
		Usuario usuario = new Usuario("Usuario1");
    	Usuario usuario1 = new Usuario("Usuario2");
    	Usuario usuario2 = new Usuario("Usuario3");
    	
    	Leilao leilao = new Leilao();
    	
    	leilao.propoe(new Lance(usuario, 250.0));
    	leilao.propoe(new Lance(usuario1, 300));
    	leilao.propoe(new Lance(usuario2, 400.0));
 
    	Avaliador avaliador = new Avaliador();
    	avaliador.setTop3Lances(leilao);
    	List<Lance> top3 = avaliador.getTop3MaioresLances();
    	double primeiroLanceObtido = top3.get(0).getValor();
    	double segundoLanceObtido = top3.get(1).getValor();
    	double terceiroLanceObtido = top3.get(2).getValor();

    	double primeiroLanceEsperado = 400.0;
    	double segundoLanceEsperado = 300.0;
    	double terceiroLanceEsperado = 250.0;
    	int tamanhoTop3Esperado = 3;
    	int tamanhoTop3Obtido = top3.size();
    	
    	assertEquals(primeiroLanceEsperado,primeiroLanceObtido, 0.1);
    	assertEquals(segundoLanceEsperado, segundoLanceObtido, 0.1);
    	assertEquals(terceiroLanceEsperado,terceiroLanceObtido, 0.1);
    	assertEquals(tamanhoTop3Esperado, tamanhoTop3Obtido);
	
	}
	@Test
	public void top3DeveFuncionarComLancesEmOrdemAleatoria() {
		
		Usuario usuario = new Usuario("Usuario1");
    	Usuario usuario1 = new Usuario("Usuario2");
    	Usuario usuario2 = new Usuario("Usuario3");
    	
    	Leilao leilao = new Leilao();
    	
    	leilao.propoe(new Lance(usuario, 300.0));
    	leilao.propoe(new Lance(usuario1, 400.0));
    	leilao.propoe(new Lance(usuario2, 250.0));
 
    	Avaliador avaliador = new Avaliador();
    	avaliador.setTop3Lances(leilao);
    	List<Lance> top3 = avaliador.getTop3MaioresLances();
    	double primeiroLanceObtido = top3.get(0).getValor();
    	double segundoLanceObtido = top3.get(1).getValor();
    	double terceiroLanceObtido = top3.get(2).getValor();

    	double primeiroLanceEsperado = 400.0;
    	double segundoLanceEsperado = 300.0;
    	double terceiroLanceEsperado = 250.0;
    	int tamanhoTop3Esperado = 3;
    	int tamanhoTop3Obtido = top3.size();
    	
    	assertEquals(primeiroLanceEsperado,primeiroLanceObtido, 0.1);
    	assertEquals(segundoLanceEsperado, segundoLanceObtido, 0.1);
    	assertEquals(terceiroLanceEsperado,terceiroLanceObtido, 0.1);
    	assertEquals(tamanhoTop3Esperado, tamanhoTop3Obtido);
	
	}


	
	
	
}
