package br.com.aulraflix.aluraflix.config.validacao;

import lombok.Getter;

@Getter
public class ErroDeFormulario {
	
	private String campo;
	private String erro;
	
	public ErroDeFormulario(String campo, String erro) {
		this.campo = campo;
		this.erro = erro;
	}
	
		
}
