package com.alanlviana.logicateste;

import java.util.ArrayList;
import java.util.List;

public class VerificadorPalindromo {

	public static final String YES = "Yes";
	public static final String NO = "No";
	public static final int QUANTIDADE_MAXIMA_VERIFICACOES = 333333;
	
	private final String palavra;
	private List<Verificacao> verificacoes = new ArrayList<Verificacao>();
	
	public VerificadorPalindromo(String palavra){
				
		if (palavra == null || "".equals(palavra)){
			throw new IllegalArgumentException("Palavra não pode ser vazia ou nula.");
		}
		
		if ((palavra.length() > 1000000)){
			throw new IllegalArgumentException("Palavra ser maior que 1000000.");
		}
		
		if (!palavra.matches("[a-z]+")){
			throw new IllegalArgumentException("A palavra deve ter somente caracteres [a-z].");
		}
		
		this.palavra = palavra;
		
	}
	
	public void adicionarVerificacao(int inicioInversao, int finalInversao, int inicioVerificacao, int finalVerificacao){
		
		Verificacao verificacao = new Verificacao(palavra,inicioInversao, finalInversao, inicioVerificacao, finalVerificacao);
		verificacoes.add(verificacao);
		
	}
	
	public List<String> retornarResultados(){
		if (verificacoes.size() < 1 || verificacoes.size() > QUANTIDADE_MAXIMA_VERIFICACOES){
			throw new IllegalStateException("A quantidade de verificações deve estar entre 1 e "+QUANTIDADE_MAXIMA_VERIFICACOES+".");
		}
		
		
		List<String> retorno = new ArrayList<String>();
		
		for(Verificacao verificacao : verificacoes){
			retorno.add(getResultado(verificacao));
		}
		
		
		return retorno;
	}
	
	
	public String getResultado(Verificacao verificacao){
	
		
		String palavraInvertida = inverterPalavra(verificacao.getInicioInversao(), verificacao.getFinalInversao());
		
		String retorno = null;
		if (isPolindromo(palavraInvertida, verificacao.getInicioVerificacao(), verificacao.getFinalVerificacao())){
			retorno = YES;
		}else{
			retorno = NO;
		}
		
		return retorno;
		
	}
	
	public boolean isPolindromo(String palavra, int inicioVerificacao, int finalVerificacao){
		
		String stringVerificada = palavra.substring(inicioVerificacao,finalVerificacao+1);
		StringBuffer sb = new StringBuffer(stringVerificada).reverse();
	
		return stringVerificada.equals(sb.toString());
	}
	
	public String inverterPalavra(int inicioInversao,int finalInversao){

		
		StringBuffer parteInvertida = new StringBuffer(palavra.substring(inicioInversao, finalInversao+1)).reverse();
		
		
		StringBuffer resultado = new StringBuffer(palavra).delete(inicioInversao, finalInversao+1);
		
		resultado = resultado.insert(inicioInversao, parteInvertida);
	
		return resultado.toString();
	}
	
}


class Verificacao{
	
	private int inicioInversao;
	private int finalInversao;
	private int inicioVerificacao;
	private int finalVerificacao;
	
	public Verificacao(String palavra,int inicioInversao, int finalInversao, int inicioVerificacao, int finalVerificacao) {
		
	
		
		if (inicioInversao > finalInversao){
			throw new IllegalArgumentException("Inicio da Inversão não deve ser maior que Final.");
		}
		
		if (finalInversao > palavra.length()){
			throw new IllegalArgumentException("Final da inversão não deve ser maior que tamanho da Palavra.");
		}

		if (inicioVerificacao > finalVerificacao){
			throw new IllegalArgumentException("Inicio da verificacao não deve ser maior que Final.");
		}		
		
		if (finalVerificacao > palavra.length()){
			throw new IllegalArgumentException("Final da verificacao não deve ser maior que tamanho da Palavra.");
		}
		
		// Subtrair 1, no java o indice começa em zero
		inicioInversao--;
		finalInversao--;
		inicioVerificacao--;
		finalVerificacao--;
		
		if (inicioInversao <  0 || finalInversao < 0 || inicioVerificacao < 0 || finalVerificacao < 0){
			throw new IllegalArgumentException("O indice não pode ser menor que 1.");
		}
		
		
		this.inicioInversao = inicioInversao;
		this.finalInversao = finalInversao;
		this.inicioVerificacao = inicioVerificacao;
		this.finalVerificacao = finalVerificacao;
	}

	public int getInicioInversao() {
		return inicioInversao;
	}

	public int getFinalInversao() {
		return finalInversao;
	}

	public int getInicioVerificacao() {
		return inicioVerificacao;
	}

	public int getFinalVerificacao() {
		return finalVerificacao;
	}	
	
	
	
}
