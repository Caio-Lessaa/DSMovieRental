package com.caiolessa.dsmovierental.dto;

import com.caiolessa.dsmovierental.entities.Movie;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class MovieResponseDTO {
    private Long id;
    private String title;
    private String synopsis;
    private Integer releaseYear;
    private Double rentPrice;
    private String imgUrl;
    private String genre;

    public MovieResponseDTO(Movie entity) {
        id = entity.getId();
        title = entity.getTitle();
        synopsis = entity.getSynopsis();
        releaseYear = entity.getReleaseYear();
        rentPrice = entity.getRentPrice();
        imgUrl = entity.getImgUrl();
        genre = entity.getGenre().getName();
    }
}
