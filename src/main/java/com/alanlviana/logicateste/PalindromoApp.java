package com.alanlviana.logicateste;

import java.util.Scanner;

public class PalindromoApp {

	public static void main(String[] args) {

		try (Scanner scanner = new Scanner(System.in)) {

			String palavra = scanner.nextLine();
			int quantidadeVerificacoes = scanner.nextInt();

			VerificadorPalindromo verificador = new VerificadorPalindromo(palavra);

			for (int cont = 0; cont < quantidadeVerificacoes; cont++) {
				int i = scanner.nextInt();
				int j = scanner.nextInt();
				int k = scanner.nextInt();
				int l = scanner.nextInt();

				verificador.adicionarVerificacao(i, j, k, l);

			}

			for (String resultado : verificador.retornarResultados()) {
				System.out.println(resultado);
			}

		}

	}

}
