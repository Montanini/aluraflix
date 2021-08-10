package br.com.aulraflix.aluraflix.controller;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.aulraflix.aluraflix.controller.dto.VideoDto;
import br.com.aulraflix.aluraflix.controller.form.AtualizacaoVideoForm;
import br.com.aulraflix.aluraflix.controller.form.VideoForm;
import br.com.aulraflix.aluraflix.modelo.Video;
import br.com.aulraflix.aluraflix.repository.VideoRepository;

@RestController
@RequestMapping("/videos")
public class VideosController {

	@Autowired
	private VideoRepository videoRepository;

	@GetMapping
	public List<VideoDto> lista() {

		List<Video> videos = videoRepository.findAll();

		return VideoDto.converter(videos);

	}

	@GetMapping("/{videoId}")
	public ResponseEntity<VideoDto> buscar(@PathVariable Long videoId) {

		Optional<Video> video = videoRepository.findById(videoId);
		if (video.isPresent()) {

			return ResponseEntity.ok(new VideoDto(video.get())); // videos.orElse(null);
		}

		return ResponseEntity.notFound().build();

	}

	@PostMapping
	public ResponseEntity<VideoDto> cadastrar(@RequestBody @Valid VideoForm form, UriComponentsBuilder uriBuilder) {

		Video video = form.converter();
		videoRepository.save(video);

		URI uri = uriBuilder.path("/videos/{id}").buildAndExpand(video.getId()).toUri();
		return ResponseEntity.created(uri).body(new VideoDto(video));
	}

	@PutMapping("/{videoId}")
	@Transactional
	public ResponseEntity<VideoDto> atualizar(@PathVariable Long videoId,
			@RequestBody @Valid AtualizacaoVideoForm form) {
		Optional<Video> optional = videoRepository.findById(videoId);
		if (optional.isPresent()) {
			Video video = form.atualizar(videoId, videoRepository);
			return ResponseEntity.ok(new VideoDto(video));
		}
		return ResponseEntity.notFound().build();
	}

	@DeleteMapping("/{videoId}")
	@Transactional
	public ResponseEntity<?> remover(@PathVariable Long videoId) {
		Optional<Video> optional = videoRepository.findById(videoId);
		if (optional.isPresent()) {
			videoRepository.deleteById(videoId);
			return ResponseEntity.ok().build();
		}
		return ResponseEntity.notFound().build();
	}

}
