package com.alanlviana.logicateste;

import org.junit.Assert;
import org.junit.Test;

public class ContadorMeiasTest {

	@Test
	public void deveRetornar3Pares(){
		
		String quantidadeMeias = "9";
		String tamanhosMeias = "10 20 20 10 10 30 50 10 20";
		
		ContadorMeias contador = new ContadorMeias(quantidadeMeias, tamanhosMeias);
		
		int quantidadePares = contador.retornarQuantidadePares();
		
		Assert.assertEquals(3, quantidadePares);
		
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void deveFalharComQuantidadeMaiorQue100(){
		
		String quantidadeMeias = "101";
		String tamanhosMeias = "10 20 20 10 10 30 50 10 20";
		
		ContadorMeias contador = new ContadorMeias(quantidadeMeias, tamanhosMeias);
		
		contador.retornarQuantidadePares();
		
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void deveFalharComTamanhoMaiorQue100(){
		
		String quantidadeMeias = "9";
		// Primeiro item tem tamanho maior que 100
		String tamanhosMeias = "101 20 20 10 10 30 50 10 20";
		
		ContadorMeias contador = new ContadorMeias(quantidadeMeias, tamanhosMeias);
		
		contador.retornarQuantidadePares();
		
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void deveFalharComQuantidadeNaoEsperada(){

		// Quantidade 8 para 9 itens
		String quantidadeMeias = "8";
		String tamanhosMeias = "10 20 20 10 10 30 50 10 20";
		
		ContadorMeias contador = new ContadorMeias(quantidadeMeias, tamanhosMeias);
		
		contador.retornarQuantidadePares();
		
	}	
	
	@Test
	public void deveRetornar0(){
		
		String quantidadeMeias = "9";
		String tamanhosMeias = "1 2 3 4 5 6 7 8 9";
		
		ContadorMeias contador = new ContadorMeias(quantidadeMeias, tamanhosMeias);
		
		int quantidadePares = contador.retornarQuantidadePares();
		Assert.assertEquals(0, quantidadePares);
		
	}	
	
}
