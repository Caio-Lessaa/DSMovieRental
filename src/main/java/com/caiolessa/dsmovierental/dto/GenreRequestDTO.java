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
public class GenreRequestDTO {
    private Long id;
    private String name;

    public GenreRequestDTO(Genre entity) {
        id = entity.getId();
        name = entity.getName();
    }
}
