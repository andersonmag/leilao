package br.ifal.edu.controle;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import br.ifal.edu.construtor.CriadorDeLeilao;
import br.ifal.edu.construtor.CriadorDeUsuario;
import br.ifal.edu.modelo.Lance;
import br.ifal.edu.modelo.Leilao;
import br.ifal.edu.modelo.Produto;

public class AvaliadorTest {

	private Avaliador avaliador;
	private Leilao leilao;
	private CriadorDeLeilao criadorDeLeilao;
	private CriadorDeUsuario criadorDeUsuario;

	@Before
	public void inicializacao() {

		criadorDeUsuario = new CriadorDeUsuario();
		avaliador = new Avaliador();
		criadorDeLeilao = new CriadorDeLeilao();

	}

	@Test
	public void avaliadorDeveFuncionarComLancesEmOrdemAleatoria() {

		leilao = criadorDeLeilao.para(new Produto("Naruto"))
				.lance(criadorDeUsuario.Com("Anderson", "email@email.com").constroi(), 300.0)
				.lance(criadorDeUsuario.Com("Anderson", "email@email.com").constroi(), 400.0)
				.lance(criadorDeUsuario.Com("Anderson", "email@email.com").constroi(), 250.0)
				.constroi();

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

		leilao = criadorDeLeilao.para(new Produto("Naruto"))
				.lance(criadorDeUsuario.Com("Anderson", "email@email.com").constroi(), 250.0)
				.lance(criadorDeUsuario.Com("Anderson", "email@email.com").constroi(), 300.0)
				.lance(criadorDeUsuario.Com("Anderson", "email@email.com").constroi(), 400.0)
				.constroi();

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

		leilao = criadorDeLeilao.para(new Produto("Naruto"))
				.lance(criadorDeUsuario.Com("Anderson", "email@email.com").constroi(), 400.0)
				.lance(criadorDeUsuario.Com("Anderson", "email@email.com").constroi(), 300.0)
				.lance(criadorDeUsuario.Com("Anderson", "email@email.com").constroi(), 250.0)
				.constroi();

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

		leilao = criadorDeLeilao.para(new Produto("Naruto"))
				.lance(criadorDeUsuario.Com("Anderson", "email@email.com").constroi(), 300.0)
				.lance(criadorDeUsuario.Com("Anderson", "email@email.com").constroi(), 400.0)
				.lance(criadorDeUsuario.Com("Anderson", "email@email.com").constroi(), 250.0)
				.lance(criadorDeUsuario.Com("Anderson","email@email.com").constroi(), 500.0)
				.constroi();

		avaliador.setTop3Lances(leilao);
		List<Lance> top3 = avaliador.getTop3MaioresLances();
		double primeiroLanceObtido = top3.get(0).getValor();
		double segundoLanceObtido = top3.get(1).getValor();
		double terceiroLanceObtido = top3.get(2).getValor();

		double primeiroLanceEsperado = 500.0;
		double segundoLanceEsperado = 400.0;
		double terceiroLanceEsperado = 300.0;
		int tamanhoTop3Esperado = 4;
		int tamanhoTop3Obtido = top3.size();

		assertEquals(primeiroLanceEsperado,primeiroLanceObtido, 0.1);
		assertEquals(segundoLanceEsperado, segundoLanceObtido, 0.1);
		assertEquals(terceiroLanceEsperado,terceiroLanceObtido, 0.1);
		assertEquals(tamanhoTop3Esperado, tamanhoTop3Obtido);

	}

	@Test
	public void top3DeveFuncionarComQuantidadeDeLancesIgualA1() {

		leilao = criadorDeLeilao.para(new Produto("Naruto"))
				.lance(criadorDeUsuario.Com("Anderson", "email@email.com").constroi(), 250.0)
				.constroi();

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

		leilao = criadorDeLeilao.para(new Produto("Naruto"))
				.lance(criadorDeUsuario.Com("Anderson", "email@email.com").constroi(), 300.0)
				.lance(criadorDeUsuario.Com("Anderson", "email@email.com").constroi(), 250.0)
				.constroi();
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

		leilao = criadorDeLeilao.para(new Produto("Naruto"))
				.constroi();

		avaliador.setTop3Lances(leilao);
		List<Lance> top3 = avaliador.getTop3MaioresLances();

		int tamanhoTop3Esperado = 0;
		int tamanhoTop3Obtido = top3.size();

		assertEquals(tamanhoTop3Esperado, tamanhoTop3Obtido);

	}

	@Test
	public void top3DeveFuncionarComQuantidadeDeLancesIguais() {

		leilao = criadorDeLeilao.para(new Produto("Naruto"))
				.lance(criadorDeUsuario.Com("Anderson", "email@email.com").constroi(), 300.0)
				.lance(criadorDeUsuario.Com("Anderson", "email@email.com").constroi(), 300.0)
				.lance(criadorDeUsuario.Com("Anderson", "email@email.com").constroi(), 300.0)
				.constroi();

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

		leilao = criadorDeLeilao.para(new Produto("Naruto"))
				.lance(criadorDeUsuario.Com("Anderson", "email@email.com").constroi(), 400.0)
				.lance(criadorDeUsuario.Com("Anderson", "email@email.com").constroi(), 300.0)
				.lance(criadorDeUsuario.Com("Anderson", "email@email.com").constroi(), 250.0)
				.constroi();

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

		leilao = criadorDeLeilao.para(new Produto("Naruto"))
				.lance(criadorDeUsuario.Com("Anderson", "email@email.com").constroi(), 250.0)
				.lance(criadorDeUsuario.Com("Anderson", "email@email.com").constroi(), 300.0)
				.lance(criadorDeUsuario.Com("Anderson", "email@email.com").constroi(), 400.0)
				.constroi();

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

		leilao = criadorDeLeilao.para(new Produto("Naruto"))
				.lance(criadorDeUsuario.Com("Anderson", "email@email.com").constroi(), 300.0)
				.lance(criadorDeUsuario.Com("Anderson", "email@email.com").constroi(), 400.0)
				.lance(criadorDeUsuario.Com("Anderson", "email@email.com").constroi(), 250.0)
				.constroi();

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
