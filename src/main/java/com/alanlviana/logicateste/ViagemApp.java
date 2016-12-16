package com.alanlviana.logicateste;

import java.util.Scanner;

public class ViagemApp {
	
	public static void main(String[] args) {

		try (Scanner scanner = new Scanner(System.in)) {

			int quantidadeTestes = scanner.nextInt();
			
			if (quantidadeTestes < 1 || quantidadeTestes > 1000){
				throw new IllegalArgumentException("A quantidade de testes deve estar entre 1 e 1000");
			}
			
			for (int i = 0; i < quantidadeTestes;i++){
			
				int quantidadeCidades = scanner.nextInt();
				scanner.nextLine();
				String rotas = scanner.nextLine();

				ViagemCase viagem = new ViagemCase(quantidadeCidades, rotas);

				Integer quantidadeRotasPossiveis = viagem.getResultado();

				System.out.println(quantidadeRotasPossiveis);
			}
		}
	}
	
}
