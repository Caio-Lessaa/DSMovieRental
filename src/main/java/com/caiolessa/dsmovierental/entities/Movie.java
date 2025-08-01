package com.caiolessa.dsmovierental.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String synopsis;
    private Integer releaseYear;
    private Double rentPrice;
    private String imgUrl;

    @ManyToOne
    private Genre genre;

    @OneToMany(mappedBy = "id.movie")
    private List<RentalItem> rentals;
}
