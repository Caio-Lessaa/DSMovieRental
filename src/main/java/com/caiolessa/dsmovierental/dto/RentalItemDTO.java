package com.caiolessa.dsmovierental.dto;

import com.caiolessa.dsmovierental.entities.RentalItem;
import com.caiolessa.dsmovierental.entities.RentalItemPK;

public class RentalItemDTO {
    private RentalItemPK id = new RentalItemPK();
    private Integer quantity;
    private Double price;
    private RentalDTO rental;
    private MovieDTO movie;

    public RentalItemDTO(RentalItem entity) {
        id = entity.getId();
        quantity = entity.getQuantity();
        price = entity.getPrice();
        rental = new RentalDTO(entity.getRental());
        movie = new MovieDTO(entity.getMovie());
    }
}
