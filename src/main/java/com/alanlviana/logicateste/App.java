package com.alanlviana.logicateste;

import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {

		try (Scanner scanner = new Scanner(System.in)) {

			System.out.println("Deseja executar qual exercício?");
			System.out.println("1) Problema das meias");
			System.out.println("2) Problema da Viagem");
			System.out.println("3) Problema do Palíndromo");
			
			int opcao = scanner.nextInt();
			
			switch (opcao){
				case 1:{
					MeiaApp.main(args);
					break;
				}
				case 2:{
					ViagemApp.main(args);
					break;
				}
				case 3:{
					PalindromoApp.main(args);
					break;
				}		
				default:{
					System.out.println("Opção inválida.");
					break;
				}
				
			}
			
			

			

			
		}

	}
}
