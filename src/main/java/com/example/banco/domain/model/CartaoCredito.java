package com.example.banco.domain.model;

public class CartaoCredito {

    private Long id;
    private String numero;
    private Double limite;
    private Long clienteId;

    public CartaoCredito(Long id, String numero, Double limite, Long clienteId) {
        this.id = id;
        this.numero = numero;
        this.limite = limite;
        this.clienteId = clienteId;
    }

    public CartaoCredito(String numero, Double limite, Long clienteId) {
        this(null, numero, limite, clienteId);
    }

    public CartaoCredito() {

    }

    public Long getId() {
        return id;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public Double getLimite() {
        return limite;
    }

    public void setLimite(Double limite) {
        this.limite = limite;
    }

    public Long getClienteId() {
        return clienteId;
    }

    public void setClienteId(Long clienteId) {
        this.clienteId = clienteId;
    }


}
