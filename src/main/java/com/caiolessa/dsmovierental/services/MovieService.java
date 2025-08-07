package com.caiolessa.dsmovierental.services;

import com.caiolessa.dsmovierental.dto.MovieRequestDTO;
import com.caiolessa.dsmovierental.dto.MovieResponseDTO;
import com.caiolessa.dsmovierental.entities.Movie;
import com.caiolessa.dsmovierental.repositories.GenreRepository;
import com.caiolessa.dsmovierental.repositories.MovieRepository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class MovieService {
    private MovieRepository movieRepository;
    private GenreRepository genreRepository;

    public MovieService(MovieRepository movieRepository, GenreRepository genreRepository) {
        this.movieRepository = movieRepository;
        this.genreRepository = genreRepository;
    }

    @Transactional
    public MovieRequestDTO insert(MovieRequestDTO dto) {
        Movie entity = new Movie();
        entity.setTitle(dto.getTitle());
        entity.setSynopsis(dto.getSynopsis());
        entity.setReleaseYear(dto.getReleaseYear());
        entity.setRentPrice(dto.getRentPrice());
        entity.setImgUrl(dto.getImgUrl());
        entity.setGenre(genreRepository.getReferenceById(dto.getGenre().getId()));
        entity = movieRepository.save(entity);
        return new MovieRequestDTO(entity);
    }

    @Transactional(readOnly = true)
    public Page<MovieRequestDTO> findAll(Pageable pageable) {
        Page<Movie> result = movieRepository.findAll(pageable);
        return result.map(MovieRequestDTO::new);
    }

    @Transactional(readOnly = true)
    public MovieResponseDTO findById(Long id) {
        Movie entity = movieRepository.getReferenceById(id);
        return new MovieResponseDTO(entity);
    }
}
