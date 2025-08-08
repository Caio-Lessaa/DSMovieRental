package com.caiolessa.dsmovierental.controller;

import com.caiolessa.dsmovierental.dto.GenreRequestDTO;
import com.caiolessa.dsmovierental.dto.GenreResponseDTO;
import com.caiolessa.dsmovierental.services.GenreService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import java.net.URI;

@RestController
@RequestMapping("/genres")
public class GenreController {
    private GenreService genreService;

    public GenreController(GenreService genreService) {
        this.genreService = genreService;
    }

    @PostMapping
    public ResponseEntity<GenreRequestDTO> insert(@RequestBody GenreRequestDTO dto) {
        dto = genreService.insert(dto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id}").buildAndExpand(dto.getId()).toUri();
        return ResponseEntity.created(uri).body(dto);
    }

    @GetMapping
    public ResponseEntity<Page<GenreResponseDTO>> findAll(Pageable pageable) {
        Page<GenreResponseDTO> result = genreService.findAll(pageable);
        return ResponseEntity.ok(result);
    }
}
