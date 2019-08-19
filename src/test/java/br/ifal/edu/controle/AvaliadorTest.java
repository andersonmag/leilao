package br.ifal.edu.controle;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import br.ifal.edu.modelo.Lance;
import br.ifal.edu.modelo.Leilao;
import br.ifal.edu.modelo.Usuario;

public class AvaliadorTest {
	
	private Usuario usuario;
	private Usuario usuario1;
	private Usuario usuario2;
	private Usuario usuario3;
	private Avaliador avaliador;
	private Leilao leilao;
	
	@Before
	public void inicializacao() {
		
		usuario = new Usuario("Usuario1");
    	usuario1 = new Usuario("Usuario2");
    	usuario2 = new Usuario("Usuario3");
    	usuario3 = new Usuario("Usuario4");
    	avaliador = new Avaliador();
    	leilao = new Leilao();
    	
	}
	
	@Test
	public void avaliadorDeveFuncionarComLancesEmOrdemAleatoria() {

    	leilao.propoe(new Lance(usuario, 300.0));
    	leilao.propoe(new Lance(usuario1, 400.0));
    	leilao.propoe(new Lance(usuario2, 250.0));
    	
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
    	
    	leilao.propoe(new Lance(usuario, 250.0));
    	leilao.propoe(new Lance(usuario1, 300.0));
    	leilao.propoe(new Lance(usuario2, 400.0));
    	
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
    	
    	leilao.propoe(new Lance(usuario, 400.0));
    	leilao.propoe(new Lance(usuario1, 300.0));
    	leilao.propoe(new Lance(usuario2, 250.0));
    	
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
    	
    	leilao.propoe(new Lance(usuario, 300.0));
    	leilao.propoe(new Lance(usuario1, 400.0));
    	leilao.propoe(new Lance(usuario2, 250.0));
    	leilao.propoe(new Lance(usuario3, 500.0));
 
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
    	
    	leilao.propoe(new Lance(usuario, 250.0));

    	avaliador.setTop3Lances(leilao);
    	List<Lance> top3 = avaliador.getTop3MaioresLances();
    	double primeiroLanceObtido = top3.get(0).getValor();

    	double primeiroLanceEsperado = 250.0;
    	int tamanhoTop3Esperado = 1;
    	int tamanhoTop3Obtido = top3.size();
    	
    	assertEquals(primeiroLanceEsperado,primeiroLanceObtido, 0.1);
    	assertEquals(tamanhoTop3Esperado, tamanhoTop3Obtido);
	
	}
	@Test
	public void top3DeveFuncionarComQuantidadeDeLancesIgualA2() {
    	
    	leilao.propoe(new Lance(usuario, 250.0));
    	leilao.propoe(new Lance(usuario1, 300.0));

    	avaliador.setTop3Lances(leilao);
    	List<Lance> top3 = avaliador.getTop3MaioresLances();
    	double primeiroLanceObtido = top3.get(0).getValor();
    	double segundoLanceObtido = top3.get(1).getValor();

    	double primeiroLanceEsperado = 300.0;
    	double segundoLanceEsperado = 250.0;
    	int tamanhoTop3Esperado = 2;
    	int tamanhoTop3Obtido = top3.size();
    	
    	assertEquals(primeiroLanceEsperado,primeiroLanceObtido, 0.1);
    	assertEquals(segundoLanceEsperado, segundoLanceObtido, 0.1);
    	assertEquals(tamanhoTop3Esperado, tamanhoTop3Obtido);
	
	}
	
	@Test
	public void top3DeveFuncionarComQuantidadeDeLancesIgualA0() {
		
    	avaliador.setTop3Lances(leilao);
    	List<Lance> top3 = avaliador.getTop3MaioresLances();

    	int tamanhoTop3Esperado = 0;
    	int tamanhoTop3Obtido = top3.size();

    	assertEquals(tamanhoTop3Esperado, tamanhoTop3Obtido);
	
	}
	
	@Test
	public void top3DeveFuncionarComQuantidadeDeLancesIguais() {
    	
    	leilao.propoe(new Lance(usuario, 300.0));
    	leilao.propoe(new Lance(usuario1, 300.0));
    	leilao.propoe(new Lance(usuario2, 300.0));
 
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
    	
    	leilao.propoe(new Lance(usuario, 400.0));
    	leilao.propoe(new Lance(usuario1, 300));
    	leilao.propoe(new Lance(usuario2, 250.0));

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
    	
    	leilao.propoe(new Lance(usuario, 250.0));
    	leilao.propoe(new Lance(usuario1, 300));
    	leilao.propoe(new Lance(usuario2, 400.0));
 
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
    	
    	leilao.propoe(new Lance(usuario, 300.0));
    	leilao.propoe(new Lance(usuario1, 400.0));
    	leilao.propoe(new Lance(usuario2, 250.0));
 
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
