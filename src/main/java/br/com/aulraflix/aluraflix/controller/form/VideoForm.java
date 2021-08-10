package br.com.aulraflix.aluraflix.controller.form;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import br.com.aulraflix.aluraflix.modelo.Video;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class VideoForm {
	
	@NotNull @NotEmpty @NotBlank
	private String titulo;
	
	@NotNull @NotEmpty
	private String descricao;
	
	@NotNull @NotEmpty
	private String url;
	
	public Video converter() {
		
		return new Video(titulo, descricao, url);
	}

}
