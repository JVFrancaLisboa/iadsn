package com.iadsn.repository;

import com.iadsn.entities.MembroEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MembroRepository extends JpaRepository<MembroEntity, Long> {

    @Query("SELECT m FROM MembroEntity m WHERE m.arquivado = true")
    List<MembroEntity> findMembrosArquivados();

    @Query("SELECT m FROM MembroEntity m WHERE m.arquivado = false")
    List<MembroEntity> findMembrosDesarquivados();
}
