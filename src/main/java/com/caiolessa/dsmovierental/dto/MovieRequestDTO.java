package com.caiolessa.dsmovierental.dto;

import com.caiolessa.dsmovierental.entities.Movie;
import com.caiolessa.dsmovierental.entities.RentalItem;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class MovieRequestDTO {
    private Long id;
    private String title;
    private String synopsis;
    private Integer releaseYear;
    private Double rentPrice;
    private String imgUrl;
    private GenreRequestDTO genre;
    private List<RentalItemDTO> rentals = new ArrayList<>();

    public MovieRequestDTO(Movie entity) {
        id = entity.getId();
        title = entity.getTitle();
        synopsis = entity.getSynopsis();
        releaseYear = entity.getReleaseYear();
        rentPrice = entity.getRentPrice();
        imgUrl = entity.getImgUrl();
        genre = new GenreRequestDTO(entity.getGenre());
        for(RentalItem rental : entity.getRentals()) {
            rentals.add(new RentalItemDTO(rental));
        }
    }
}
