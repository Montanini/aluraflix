package br.com.aulraflix.aluraflix.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.aulraflix.aluraflix.controller.dto.CategoriaDto;
import br.com.aulraflix.aluraflix.modelo.Categoria;
import br.com.aulraflix.aluraflix.repository.CategoriaRepository;

@RestController
@RequestMapping("/categorias")
public class CategoriaController {
	
	@Autowired
	private CategoriaRepository categoriaRepository;
	
	@GetMapping
	public List<CategoriaDto> listar() {
		
		List<Categoria> listaCategorias = categoriaRepository.findAll();
		
		return CategoriaDto.converter(listaCategorias);
	}

}
