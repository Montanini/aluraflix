package br.com.aulraflix.aluraflix.controller.form;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import br.com.aulraflix.aluraflix.modelo.Video;
import br.com.aulraflix.aluraflix.repository.VideoRepository;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AtualizacaoVideoForm {
	
	@NotNull @NotEmpty @NotBlank
	private String titulo;
	
	@NotNull @NotEmpty
	private String descricao;

	public Video atualizar(Long videoId, VideoRepository videoRepository) {
		
		Video video = videoRepository.getById(videoId);
		
		video.setTitulo(this.titulo);
		video.setDescricao(this.descricao);
		
		return video;
	}

}
