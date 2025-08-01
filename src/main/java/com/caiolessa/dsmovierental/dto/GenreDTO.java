package com.caiolessa.dsmovierental.dto;

import com.caiolessa.dsmovierental.entities.Genre;
import com.caiolessa.dsmovierental.entities.Movie;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class GenreDTO {
    private Long id;
    private String name;
    private List<MovieDTO> movies;

    public GenreDTO(Genre entity) {
        id = entity.getId();
        name = entity.getName();
        for(Movie movie : entity.getMovies()) {
            movies.add(new MovieDTO(movie));
        }
    }
}
