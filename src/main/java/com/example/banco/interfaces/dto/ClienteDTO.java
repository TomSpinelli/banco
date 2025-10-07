package com.example.banco.interfaces.dto;

import java.util.List;

public record ClienteDTO(
        Long id,
        String nome,
        String email,
        List<CartaoCreditoDTO> cartoesCredito) {
}
