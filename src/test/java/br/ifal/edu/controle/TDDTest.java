package br.ifal.edu.controle;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import br.ifal.edu.construtor.CriadorDeLeilao;
import br.ifal.edu.construtor.CriadorDeUsuario;
import br.ifal.edu.modelo.Leilao;
import br.ifal.edu.modelo.Produto;
import br.ifal.edu.modelo.Usuario;

public class TDDTest {

	private CriadorDeUsuario criadorDeUsuario;
	private CriadorDeLeilao criadorDeLeilao;
	private Leilao leilao;
	private Avaliador avaliador;

	@Test
	public void LeilaoDeveFuncionarComUsuariosELancesDiferentes(){

		criadorDeLeilao = new CriadorDeLeilao();
		criadorDeUsuario = new CriadorDeUsuario();

		leilao = criadorDeLeilao.para(new Produto("M"))
				.lance(criadorDeUsuario.Com("Anderson", "mail@email.com").constroi(),300.0)
				.lance(criadorDeUsuario.Com("Rafael","mail2@gmail.com").constroi(), 400.0)
				.lance(criadorDeUsuario.Com("JP", "email3@hotmail.com").constroi(), 250.0)
				.lance(criadorDeUsuario.Com("AJ", "email5@hotmail.com").constroi(), 500.0)
				.lance(criadorDeUsuario.Com("Paulo", "email8@gmail.com").constroi(), 600.0)
				.constroi();

		avaliador = new Avaliador();

		boolean validadeObtida = avaliador.validarLeilao(leilao);
		boolean validadeEsperada = true;

		assertEquals(validadeEsperada, validadeObtida);


	}

	@Test
	public void LeilaoNaoDeveFuncionarCom5LancesDoMesmoUsuario() {

		criadorDeLeilao = new CriadorDeLeilao();
		criadorDeUsuario = new CriadorDeUsuario();
		Usuario usuario = criadorDeUsuario.Com("Anderson", "email@gmail.com").constroi();

		leilao = criadorDeLeilao.para(new Produto("M"))
				.lance(usuario,300.0)
				.lance(usuario, 400.0)
				.lance(usuario, 250.0)
				.lance(usuario, 500.0)
				.lance(usuario, 600.0)
				.lance(usuario, 750.0)
				.constroi();

		avaliador = new Avaliador();


		boolean validadeObtida = avaliador.validarLeilao(leilao);
		boolean validadeEsperada = false;

		assertEquals(validadeEsperada, validadeObtida);

	}

	@Test
	public void LeilaoDeveFuncionarCom3LancesPorUsuario() {

		criadorDeLeilao = new CriadorDeLeilao();
		criadorDeUsuario = new CriadorDeUsuario();
		Usuario usuario = criadorDeUsuario.Com("Anderson", "email@gmail.com").constroi();
		Usuario usuario2 = criadorDeUsuario.Com("Anderson", "email@gmail.com").constroi();
		avaliador = new Avaliador();

		leilao = criadorDeLeilao.para(new Produto("M"))
				.lance(usuario,300.0)
				.lance(usuario, 400.0)
				.lance(usuario, 250.0)
				.lance(usuario2, 500.0)
				.lance(usuario2, 600.0)
				.lance(usuario2, 750.0)
				.constroi();


		boolean validadeObtida = avaliador.validarLeilao(leilao);
		boolean validadeEsperada = true;

		assertEquals(validadeEsperada, validadeObtida);

	}

	public void LeilaoDeveFuncionarSemLance() {

		criadorDeLeilao = new CriadorDeLeilao();
		criadorDeUsuario = new CriadorDeUsuario();
		avaliador = new Avaliador();

		leilao = criadorDeLeilao.para(new Produto("M"))
		.constroi();
		
		boolean validadeObtida = avaliador.validarLeilao(leilao);
		boolean validadeEsperada = true;

		assertEquals(validadeEsperada, validadeObtida);
	}

}
