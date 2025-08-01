package com.caiolessa.dsmovierental.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class RentalItem {
    @EmbeddedId
    private RentalItemPK id = new RentalItemPK();
    private Integer quantity;
    private Double price;

    @MapsId("rental")
    @ManyToOne
    @JoinColumn(name = "rental_id_fk")
    private Rental rental;

    @MapsId("movie")
    @ManyToOne
    @JoinColumn(name = "movie_id_fk")
    private Movie movie;
}
