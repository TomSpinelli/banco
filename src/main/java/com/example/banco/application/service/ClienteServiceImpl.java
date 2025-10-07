package com.example.banco.application.service;


import com.example.banco.domain.model.CartaoCredito;
import com.example.banco.domain.model.Cliente;
import com.example.banco.domain.ports.ClienteRepositoryPort;
import com.example.banco.domain.ports.ClienteServicePort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteServiceImpl implements ClienteServicePort {

    private final ClienteRepositoryPort clienteRepository;
    private final CartaoServiceImpl cartaoService;

    public ClienteServiceImpl(ClienteRepositoryPort clienteRepository,CartaoServiceImpl cartaoService) {
        this.clienteRepository = clienteRepository;
        this.cartaoService = cartaoService;
    }

    @Override
    public Cliente criarCliente(Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    @Override
    public List<Cliente> listarClientes() {
        return clienteRepository.findAll();
    }

    @Override
    public void deletarCliente(Long id) {
        Optional<Cliente> cliente = clienteRepository.findById(id);
        if (!cliente.isPresent()) {
            throw new RuntimeException("Cliente bnao encontrado id " + id);
        }

        List<CartaoCredito> cartoes = cartaoService.findByClienteId(cliente.get().getId());
        if(cartoes.isEmpty()){
            clienteRepository.deleteById(id);
        }else{
            throw new RuntimeException("Cliente não pode ser deletado pois possui cartões");
        }

    }

}
