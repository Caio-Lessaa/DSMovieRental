package com.caiolessa.dsmovierental.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Rental {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Instant moment;
    private Double total;

    @OneToMany(mappedBy = "id.rental")
    private List<RentalItem> items;

    @ManyToOne
    private Client client;
}
