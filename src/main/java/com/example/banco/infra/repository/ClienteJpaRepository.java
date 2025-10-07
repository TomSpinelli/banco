package com.example.banco.infra.repository;

import com.example.banco.infra.entity.ClienteEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteJpaRepository extends JpaRepository<ClienteEntity,Long> {
}
