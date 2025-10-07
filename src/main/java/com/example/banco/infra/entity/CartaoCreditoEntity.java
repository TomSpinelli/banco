package com.example.banco.infra.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "cartoes_credito")
public class CartaoCreditoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String numero;
    private Double limite;

    @Column(name = "cliente_id")
    private Long clienteId;

    public CartaoCreditoEntity() {}

    public CartaoCreditoEntity(Long id, String numero, Double limite, Long clienteId) {
        this.id = id;
        this.numero = numero;
        this.limite = limite;
        this.clienteId = clienteId;
    }

    public Long getId() { return id; }
    public String getNumero() { return numero; }
    public Double getLimite() { return limite; }
    public Long getClienteId() { return clienteId; }
}
