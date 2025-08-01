package com.caiolessa.dsmovierental.dto;

import com.caiolessa.dsmovierental.entities.Client;
import com.caiolessa.dsmovierental.entities.Rental;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ClientDTO {
    private Long id;
    private String name;
    private String email;
    private String cpf;
    private List<RentalDTO> rentals;

    public ClientDTO(Client entity) {
        id = entity.getId();
        name = entity.getName();
        email = entity.getEmail();
        cpf = entity.getCpf();
        for(Rental rental : entity.getRentals()) {
            rentals.add(new RentalDTO(rental));
        }
    }
}
