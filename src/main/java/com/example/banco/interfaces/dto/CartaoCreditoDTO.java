package com.example.banco.interfaces.dto;

public record CartaoCreditoDTO (
         Long id,
         String numero,
         Double limite,
         Long clienteId
        ) {
}