package com.alanlviana.logicateste;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class ViagemCaseTest {

	
	@Test(expected=IllegalArgumentException.class)
	public void deveFalharComQuantidadeDeCidadeMenorQue3(){
		new ViagemCase(2, "1");
	}	
	
	@Test(expected=IllegalArgumentException.class)
	public void deveFalharComQuantidadeDeRotasMenorQue1(){
		new ViagemCase(3, "");
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void deveQuantidadeDeRotasLancadasDeveSerCompativelComQuantidadeCidade(){
		new ViagemCase(3, "1 1 1");
	}
	
	@Test
	public void devePassarComValoresValidos(){
		ViagemCase viagem = new ViagemCase(4, "2 2 2");
		
		assertEquals(8, viagem.getResultado());
	}
		
	
}
