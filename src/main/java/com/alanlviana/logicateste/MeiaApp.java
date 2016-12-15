package com.alanlviana.logicateste;

import java.util.Scanner;

public class MeiaApp {

	public static void main(String[] args) {

		try (Scanner scanner = new Scanner(System.in)) {

			String quantidadeMeias = scanner.nextLine();
			String tamanhosMeias = scanner.nextLine();

			ContadorMeias contador = new ContadorMeias(quantidadeMeias, tamanhosMeias);

			Integer quantidadePares = contador.retornarQuantidadePares();

			System.out.println(quantidadePares);
		}
	}

}
