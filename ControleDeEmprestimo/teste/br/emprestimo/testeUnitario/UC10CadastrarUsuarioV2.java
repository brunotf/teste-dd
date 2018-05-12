package br.emprestimo.testeUnitario;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;

import br.emprestimo.modelo.Usuario;

@RunWith(Parameterized.class)
public class UC10CadastrarUsuarioV2 {
	Usuario umUsuario;
	@Parameter
	public String ra;
	@Parameter(1)
	public String nome;
	@Parameter(2)
	public String resultadoEsperado;

	@Before
	public void setup() {
		umUsuario = new Usuario();
	}

	@Parameters
	public static Collection<Object[]> dadosDeTeste() {
		return Arrays.asList(new Object[][] { 
				{ "1111", "Jos� da Silva Pereira", "valido" },
				{ "", "Jos� da Silva Pereira", "RA invalido" }, 
				{ null, "Jos� da Silva Pereira", "RA invalido" },
				{ "1111", "", "Nome invalido" },
				{ "1111", null, "Nome invalido" }, 
			});
	}

	// Este teste sera executado n vezes de acordo com a quantidade de parametros fornecidos
	@Test
	public void CT01UC10ValidaComportamentoDoCadastrarUsuario() {
		// System.out.println("Caso de teste executado : " + resultadoEsperado);
		try {
			umUsuario.setRa(ra);
			umUsuario.setNome(nome);
			assertEquals(ra, umUsuario.getRa());
			assertEquals(nome, umUsuario.getNome());
			assertTrue(resultadoEsperado.equals("valido"));
		} catch (Exception e) {
			assertTrue(resultadoEsperado.equals(e.getMessage()));
		}
	}

}
