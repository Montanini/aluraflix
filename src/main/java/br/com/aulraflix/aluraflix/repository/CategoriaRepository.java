package br.com.aulraflix.aluraflix.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.aulraflix.aluraflix.modelo.Categoria;

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {

}
