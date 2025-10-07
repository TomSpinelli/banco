package com.example.banco.infra.adapter;

import com.example.banco.domain.model.Cliente;
import com.example.banco.domain.ports.ClienteRepositoryPort;

import com.example.banco.infra.entity.ClienteEntity;
import com.example.banco.infra.repository.ClienteJpaRepository;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class ClienteRepositoryAdapter implements ClienteRepositoryPort {

    private final ClienteJpaRepository clienteJpaRepository;

    public ClienteRepositoryAdapter(ClienteJpaRepository clienteJpaRepository) {
        this.clienteJpaRepository = clienteJpaRepository;
    }

    @Override
    public Cliente save(Cliente cliente) {
        ClienteEntity entity = new ClienteEntity(
                cliente.getId(),
                cliente.getNome(),
                cliente.getEmail()
        );
        return toDomain(clienteJpaRepository.save(entity));
    }

    @Override
    public List<Cliente> findAll() {
        return clienteJpaRepository.findAll()
                .stream()
                .map(this::toDomain)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<Cliente> findById(Long id) {
        return clienteJpaRepository.findById(id).map(this::toDomain);
    }

    @Override
    public void deleteById(Long id) {
        clienteJpaRepository.deleteById(id);
    }

    private Cliente toDomain(ClienteEntity entity) {
        return new Cliente(
                entity.getId(),
                entity.getNome(),
                entity.getEmail()
        );
    }
}
