package com.caiolessa.dsmovierental.repositories;

import com.caiolessa.dsmovierental.entities.RentalItem;
import com.caiolessa.dsmovierental.entities.RentalItemPK;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RentalItemRepository extends JpaRepository<RentalItem, RentalItemPK> {
}
