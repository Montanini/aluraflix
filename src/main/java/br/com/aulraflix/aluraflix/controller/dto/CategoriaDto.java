package br.com.aulraflix.aluraflix.controller.dto;

import java.util.List;
import java.util.stream.Collectors;

import br.com.aulraflix.aluraflix.modelo.Categoria;
import lombok.Getter;

@Getter
public class CategoriaDto {
	
	private String titulo;
	private Long id;
	
	public CategoriaDto(Categoria categoria) {
		this.titulo = categoria.getTitulo();
		this.id = categoria.getId();
	}

	public static List<CategoriaDto> converter(List<Categoria> listaCategorias) {
		return listaCategorias.stream().map(CategoriaDto::new).collect(Collectors.toList());
	}
}
