package com.iadsn.repository;

import com.iadsn.entities.DizimoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DizimoRepository extends JpaRepository<DizimoEntity, Long> {
}
