package com.caiolessa.dsmovierental.dto;

import com.caiolessa.dsmovierental.entities.Genre;
import com.caiolessa.dsmovierental.entities.Movie;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class GenreResponseDTO {
    private Long id;
    private String name;
    private List<MovieResponseDTO> movies = new ArrayList<>();

    public GenreResponseDTO(Genre entity) {
        id = entity.getId();
        name = entity.getName();
        for(Movie movieEntity : entity.getMovies()) {
            MovieResponseDTO movieDto = new MovieResponseDTO(movieEntity);
            movies.add(movieDto);
        }
    }
}
