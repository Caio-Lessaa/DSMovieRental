package com.caiolessa.dsmovierental.services;

import com.caiolessa.dsmovierental.dto.GenreRequestDTO;
import com.caiolessa.dsmovierental.dto.GenreResponseDTO;
import com.caiolessa.dsmovierental.entities.Genre;
import com.caiolessa.dsmovierental.repositories.GenreRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class GenreService {
    private GenreRepository genreRepository;

    public GenreService(GenreRepository genreRepository) {
        this.genreRepository = genreRepository;
    }

    @Transactional
    public GenreRequestDTO insert(GenreRequestDTO dto) {
        Genre entity = new Genre();
        copyProperties(dto, entity);
        entity = genreRepository.save(entity);
        return new GenreRequestDTO(entity);
    }

    @Transactional(readOnly = true)
    public Page<GenreResponseDTO> findAll(Pageable pageable) {
        Page<Genre> result = genreRepository.findAll(pageable);
        return result.map(GenreResponseDTO::new);
    }

    public void copyProperties(GenreRequestDTO dto, Genre entity) {
        entity.setName(dto.getName());
    }
}
