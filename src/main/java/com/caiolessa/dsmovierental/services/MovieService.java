package com.caiolessa.dsmovierental.services;

import com.caiolessa.dsmovierental.dto.MovieDTO;
import com.caiolessa.dsmovierental.entities.Movie;
import com.caiolessa.dsmovierental.repositories.GenreRepository;
import com.caiolessa.dsmovierental.repositories.MovieRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class MovieService {
    private MovieRepository movieRepository;
    private GenreRepository genreRepository;

    public MovieService(MovieRepository movieRepository, GenreRepository genreRepository) {
        this.movieRepository = movieRepository;
        this.genreRepository = genreRepository;
    }

    public MovieDTO insert(MovieDTO dto) {
        Movie entity = new Movie();
        entity.setTitle(dto.getTitle());
        entity.setSynopsis(dto.getSynopsis());
        entity.setReleaseYear(dto.getReleaseYear());
        entity.setRentPrice(dto.getRentPrice());
        entity.setImgUrl(dto.getImgUrl());
        entity.setGenre(genreRepository.getReferenceById(dto.getGenre().getId()));
        entity = movieRepository.save(entity);
        return new MovieDTO(entity);
    }
}
