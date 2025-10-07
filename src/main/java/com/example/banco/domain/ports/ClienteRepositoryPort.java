package com.example.banco.domain.ports;


import com.example.banco.domain.model.Cliente;

import java.util.List;
import java.util.Optional;

public interface ClienteRepositoryPort {
    Cliente save(Cliente cliente);

    List<Cliente> findAll();

    Optional<Cliente> findById(Long id);

    void deleteById(Long id);
}
