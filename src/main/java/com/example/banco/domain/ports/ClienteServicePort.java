package com.example.banco.domain.ports;

import com.example.banco.domain.model.Cliente;

import java.util.List;

public interface ClienteServicePort {
    Cliente criarCliente(Cliente cliente);

    List<Cliente> listarClientes();

    void deletarCliente(Long id);
}
