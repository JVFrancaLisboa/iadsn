package com.iadsn.repository;

import com.iadsn.entities.GastoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GastoRepository extends JpaRepository<GastoEntity, Long> {
}
