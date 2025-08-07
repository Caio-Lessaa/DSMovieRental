package com.caiolessa.dsmovierental.dto;

import com.caiolessa.dsmovierental.entities.Genre;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class GenreDTO {
    private Long id;
    private String name;
    private List<MovieRequestDTO> movies = new ArrayList<>();

    public GenreDTO(Genre entity) {
        id = entity.getId();
        name = entity.getName();
    }
}
