package com.caiolessa.dsmovierental.dto;

import com.caiolessa.dsmovierental.entities.Movie;
import com.caiolessa.dsmovierental.entities.Rental;
import com.caiolessa.dsmovierental.entities.RentalItem;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class MovieDTO {
    private Long id;
    private String title;
    private String synopsis;
    private Integer releaseYear;
    private Double rentPrice;
    private String imgUrl;
    private GenreDTO genre;
    private List<RentalItemDTO> rentals;

    public MovieDTO(Movie entity) {
        id = entity.getId();
        title = entity.getTitle();
        synopsis = entity.getSynopsis();
        releaseYear = getReleaseYear();
        rentPrice = entity.getRentPrice();
        imgUrl = entity.getImgUrl();
        genre = new GenreDTO(entity.getGenre());
        for(RentalItem rental : entity.getRentals()) {
            rentals.add(new RentalItemDTO(rental));
        }
    }
}
