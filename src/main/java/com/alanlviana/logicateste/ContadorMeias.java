package com.alanlviana.logicateste;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;

public class ContadorMeias {

	@SuppressWarnings("unused")
	private String quantidadeMeias;
	private List<String> listaMeias;

	public ContadorMeias(String quantidadeMeias, String tamanhosMeias) {
		
		List<String> listaMeias = Arrays.asList(tamanhosMeias.split(" "));

		int qtdMeias = Integer.valueOf(quantidadeMeias);

		if (qtdMeias != listaMeias.size()) {
			throw new IllegalArgumentException("A quantidade de meias esperada é diferente da recebida.");
		}

		if ((qtdMeias < 1) || (qtdMeias > 100)) {
			throw new IllegalArgumentException("Quantidade de meias deve estar entre 1 e 100");
		}

		for (String tamanho : listaMeias) {
			int tamanhoInt = Integer.valueOf(tamanho);

			if ((tamanhoInt < 1) || (tamanhoInt > 100)) {
				throw new IllegalArgumentException("Tamanho da meia deve estar entre 1 e 100");
			}
		}
		
		this.quantidadeMeias = quantidadeMeias;
		this.listaMeias = listaMeias;		

	}

	public Integer retornarQuantidadePares() {
		LinkedHashMap<String, Integer> contagemAgrupada = new LinkedHashMap<String, Integer>();

		for (String tamanho : listaMeias) {
			if (contagemAgrupada.containsKey(tamanho)) {
				contagemAgrupada.put(tamanho, contagemAgrupada.get(tamanho) + 1);
			} else {
				contagemAgrupada.put(tamanho, 1);
			}
		}

		int quantidadePares = 0;

		for (String tamanho : contagemAgrupada.keySet()) {
			quantidadePares += contagemAgrupada.get(tamanho) / 2;
		}
		return quantidadePares;
	}

}
