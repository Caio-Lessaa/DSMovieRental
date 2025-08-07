package com.caiolessa.dsmovierental.controller;

import com.caiolessa.dsmovierental.dto.MovieRequestDTO;
import com.caiolessa.dsmovierental.dto.MovieResponseDTO;
import com.caiolessa.dsmovierental.services.MovieService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/movies")
public class MovieController {
    private MovieService movieService;

    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @PostMapping
    public ResponseEntity<MovieRequestDTO> insert(@RequestBody MovieRequestDTO dto) {
        dto = movieService.insert(dto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id}").buildAndExpand(dto.getId()).toUri();
        return ResponseEntity.created(uri).body(dto);
    }

    @GetMapping
    public ResponseEntity<Page<MovieRequestDTO>> findAll(Pageable pageable) {
        Page<MovieRequestDTO> result = movieService.findAll(pageable);
        return ResponseEntity.ok(result);
    }

    @GetMapping("/{id}")
    public MovieResponseDTO findById(@PathVariable Long id) {
        return movieService.findById(id);
    }

    @PutMapping("/{id}")
    public MovieRequestDTO update(@RequestBody MovieRequestDTO dto, @PathVariable Long id) {
        return movieService.update(dto, id);
    }
}
