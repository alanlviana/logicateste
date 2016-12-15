package com.alanlviana.logicateste;

import java.util.List;

import org.junit.Test;

import junit.framework.Assert;

public class VerificadorPolindromoTest {

	@Test(expected=IllegalArgumentException.class)
	public void deveFalharComStringNula(){
		new VerificadorPalindromo(null);
	}	
	
	@Test(expected=IllegalArgumentException.class)
	public void deveFalharComStringVazia(){
		new VerificadorPalindromo("");
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void deveFalharComStringComCaracterEspecial(){
		new VerificadorPalindromo("teste@");
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void deveFalharComStringComCaracterNumeros(){
		new VerificadorPalindromo("teste123");
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void deveFalharComInicioInversaoMaiorQueFinal(){
		VerificadorPalindromo verificador = new VerificadorPalindromo("teste");
		verificador.adicionarVerificacao(3, 2, 1, 3);
	}
	@Test(expected=IllegalArgumentException.class)
	public void deveFalharComFinalInversaoMaiorTamanhoDaString(){
		VerificadorPalindromo verificador = new VerificadorPalindromo("teste");
		verificador.adicionarVerificacao(3, 20, 1, 3);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void deveFalharComInicioVerificacaoMaiorQueFinal(){
		VerificadorPalindromo verificador = new VerificadorPalindromo("teste");
		verificador.adicionarVerificacao(1, 3, 4, 1);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void deveFalharComFinalVerificacaoMaiorTamanhoDaString(){
		VerificadorPalindromo verificador = new VerificadorPalindromo("teste");
		verificador.adicionarVerificacao(1, 2, 1, 20);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void deveFalharComIndiceZero(){
		VerificadorPalindromo verificador = new VerificadorPalindromo("teste");
		verificador.adicionarVerificacao(0, 0, 0, 0);
	}		
	
	@Test(expected=IllegalStateException.class)
	public void deveFalharComVerificacoesVazia(){
		VerificadorPalindromo verificador = new VerificadorPalindromo("abcde");
		verificador.retornarResultados();
	}
	
	@Test
	public void deveInverterCorretamente(){
		VerificadorPalindromo verificador = new VerificadorPalindromo("abcde");
		
		Assert.assertEquals("acbde", verificador.inverterPalavra(1, 2));
		Assert.assertEquals("bacde", verificador.inverterPalavra(0, 1));
		Assert.assertEquals("cbade", verificador.inverterPalavra(0, 2));
		Assert.assertEquals("adcbe", verificador.inverterPalavra(1, 3));
		
		VerificadorPalindromo verificador2 = new VerificadorPalindromo("ababa");
		Assert.assertEquals("aabba", verificador2.inverterPalavra(1, 2));
		Assert.assertEquals("baaba", verificador2.inverterPalavra(0, 1));
		Assert.assertEquals("ababa", verificador2.inverterPalavra(0, 2));
		Assert.assertEquals("ababa", verificador2.inverterPalavra(1, 3));
		
	}
	
	@Test
	public void deveTestarPolindromoCorretamente(){
		VerificadorPalindromo verificador = new VerificadorPalindromo("ababa");
		
		Assert.assertTrue(verificador.isPolindromo("aabba", 2, 3));
		Assert.assertFalse(verificador.isPolindromo("baaba", 2, 3));
		Assert.assertTrue(verificador.isPolindromo("ababa", 2, 4));
		Assert.assertTrue(verificador.isPolindromo("ababa", 0, 4));		
		
	}		
	
	
	@Test
	public void devePassarComValoresCorretos1(){
		VerificadorPalindromo verificador = new VerificadorPalindromo("ababa");
		verificador.adicionarVerificacao(2, 3 , 3, 4);
		verificador.adicionarVerificacao(1, 2 , 3, 4);
		verificador.adicionarVerificacao(1, 3 , 3, 5);
		verificador.adicionarVerificacao(2, 4 , 1, 5);
		
		List<String> retorno = verificador.retornarResultados();
		
		Assert.assertEquals(VerificadorPalindromo.YES, retorno.get(0));
		Assert.assertEquals(VerificadorPalindromo.NO, retorno.get(1)); 
		Assert.assertEquals(VerificadorPalindromo.YES, retorno.get(2)); 
		Assert.assertEquals(VerificadorPalindromo.YES, retorno.get(3)); 
		
		
	}
	
	
	
	
}
