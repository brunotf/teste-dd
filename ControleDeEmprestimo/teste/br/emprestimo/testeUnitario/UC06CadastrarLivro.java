package br.emprestimo.testeUnitario;

import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import br.emprestimo.modelo.Livro;

public class UC06CadastrarLivro {

	@Test
	public void CT01Obtem_Livro_Com_DadosValidos() {
		try {
			// cenario
			Livro umLivro;
			// acao
			umLivro = ObtemLivro.comDadosValidos();
		} catch (RuntimeException e) {
			// verificacao
			fail("nao deve falhar");
		}
	}

	@Test
	public void CT02verifica_O_estado_Do_Objeto() {
		// cenario
		Livro resultadoEsperado = new Livro();
		resultadoEsperado.setIsbn("121212");
		resultadoEsperado.setTitulo("Engenharia de Software");
		resultadoEsperado.setAutor("Pressman");
		// acao
		Livro resultadoObtido = ObtemLivro.comDadosValidos();
		// verificacao
		assertTrue(resultadoEsperado.equals(resultadoObtido));
	}

	@Test
	public void CT03cadastrar_Livro_Com_ISBN_em_branco() {
		// cenario
		String isbn = "";
		Livro livro = new Livro();
		try {
			// acao
			livro.setIsbn(isbn);
			fail("deveria lançar uma exceção");
		} catch (RuntimeException e) {
			// verificacao
			assertEquals("ISBN invalido", e.getMessage());
		}
	}

	@Test
	public void CT04cadastrar_Livro_Com_ISBN_nulo() {
		// cenario
		String isbn = null;
		Livro livro = new Livro();
		try {
			// acao
			livro.setIsbn(isbn);
			fail("deveria lançar uma exceção");
		} catch (RuntimeException e) {
			// verificacao
			assertEquals("ISBN invalido", e.getMessage());
		}
	}

	@Test
	public void CT05cadastrar_Livro_Com_Titulo_em_branco() {
		// cenario
		String titulo = "";
		Livro livro = new Livro();
		try {
			// acao
			livro.setTitulo(titulo);
			fail("deveria lançar uma exceção");
		} catch (RuntimeException e) {
			// verificacao
			assertEquals("Titulo invalido", e.getMessage());
		}
	}

	@Test
	public void CT06cadastrar_Livro_Com_titulo_nulo() {
		// cenario
		String titulo = null;
		Livro livro = new Livro();
		try {
			// acao
			livro.setTitulo(titulo);
			fail("deveria lançar uma exceção");
		} catch (RuntimeException e) {
			// verificacao
			assertEquals("Titulo invalido", e.getMessage());
		}
	}

}
