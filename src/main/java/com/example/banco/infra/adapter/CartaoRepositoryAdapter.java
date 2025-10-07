package com.example.banco.infra.adapter;

import com.example.banco.domain.model.CartaoCredito;
import com.example.banco.domain.ports.CartaoRepositoryPort;
import com.example.banco.infra.entity.CartaoCreditoEntity;
import com.example.banco.infra.repository.CartaoCreditoJpaRepository;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class CartaoRepositoryAdapter implements CartaoRepositoryPort {

    private final CartaoCreditoJpaRepository cartaoJpaRepository;

    public CartaoRepositoryAdapter(CartaoCreditoJpaRepository cartaoJpaRepository) {
        this.cartaoJpaRepository = cartaoJpaRepository;
    }

    @Override
    public CartaoCredito save(CartaoCredito cartao) {
        CartaoCreditoEntity entity = new CartaoCreditoEntity(
                cartao.getId(),
                cartao.getNumero(),
                cartao.getLimite(),
                cartao.getClienteId()
        );
        return toDomain(cartaoJpaRepository.save(entity));
    }

    @Override
    public List<CartaoCredito> findAll() {
        return cartaoJpaRepository.findAll()
                .stream()
                .map(this::toDomain)
                .collect(Collectors.toList());
    }

    @Override
    public List<CartaoCredito> findByclienteId(Long clienteId) {
        return cartaoJpaRepository.findByClienteId(clienteId)
                .stream()
                .map(this::toDomain)
                .collect(Collectors.toList());
    }


    private CartaoCredito toDomain(CartaoCreditoEntity entity) {
        return new CartaoCredito(
                entity.getId(),
                entity.getNumero(),
                entity.getLimite(),
                entity.getClienteId()
        );
    }
}
