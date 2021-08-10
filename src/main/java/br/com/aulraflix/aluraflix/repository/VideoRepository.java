package br.com.aulraflix.aluraflix.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.aulraflix.aluraflix.modelo.Video;

public interface VideoRepository extends JpaRepository<Video, Long> {
	
}
