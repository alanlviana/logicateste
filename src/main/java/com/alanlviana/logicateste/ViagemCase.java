package com.alanlviana.logicateste;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ViagemCase {

	
	private int quantidadeCidade;
	private List<Integer> rotas = new ArrayList<>();
	
	public ViagemCase(int quantidadeCidade, String strRotas){
		
		if (quantidadeCidade < 3 || quantidadeCidade > 100){
			throw new IllegalArgumentException("A quantidade de cidade deve estar entre 3 e 100");
		}
		
		List<String> strList = Arrays.asList(strRotas.split(" "));
		for(String strQtdRota : strList) {
			Integer valorRota = Integer.parseInt(strQtdRota);
			
			if (valorRota < 1 || valorRota > 1000){
				throw new IllegalArgumentException("A quantidade de rotas entre cidades deve estar entre 1 e 1000");
			}
			
			rotas.add(valorRota);
		}
		
		if (quantidadeCidade - 1 != rotas.size() ){
			throw new IllegalArgumentException("A quantidade de rotas entre cidades deve igual a número de cidade menos 1.");
		}
		
	}
	
	public int getResultado(){
		
		int produto = 1;
		
		for (Integer rota : rotas){
			produto = produto * rota;
		}
		
		return produto;
		
	}
	
	
	
}
