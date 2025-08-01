package com.caiolessa.dsmovierental.dto;

import com.caiolessa.dsmovierental.entities.Rental;
import com.caiolessa.dsmovierental.entities.RentalItem;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class RentalDTO {
    private Long id;
    private Instant moment;
    private Double total;
    private List<RentalItemDTO> items;
    private ClientDTO client;

    public RentalDTO(Rental entity) {
        id = entity.getId();
        moment = entity.getMoment();
        total = entity.getTotal();
        for(RentalItem item : entity.getItems()){
            items.add(new RentalItemDTO(item));
        }
        client = new ClientDTO(entity.getClient());
    }
}
