package com.example.banco.application.service;

import com.example.banco.domain.model.CartaoCredito;
import com.example.banco.domain.ports.CartaoRepositoryPort;
import com.example.banco.domain.ports.CartaoServicePort;
import com.example.banco.domain.ports.ClienteRepositoryPort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartaoServiceImpl implements CartaoServicePort {

    private final CartaoRepositoryPort cartaoRepository;
    private final ClienteRepositoryPort clienteRepository;

    public CartaoServiceImpl(CartaoRepositoryPort cartaoRepository, ClienteRepositoryPort clienteRepository) {
        this.cartaoRepository = cartaoRepository;
        this.clienteRepository = clienteRepository;
    }

    @Override
    public CartaoCredito criarCartao(CartaoCredito cartao) {
        // Validação: cliente deve existir
        clienteRepository.findById(cartao.getClienteId())
                .orElseThrow(() -> new IllegalArgumentException("Cliente não encontrado."));
        return cartaoRepository.save(cartao);
    }

    @Override
    public List<CartaoCredito> listarCartoes() {
        return cartaoRepository.findAll();
    }

    @Override
    public List<CartaoCredito> findByClienteId(Long clienteId) {
        return cartaoRepository.findByclienteId(clienteId);
    }
}
