package com.example.banco.interfaces.restController;

import com.example.banco.application.service.CartaoServiceImpl;
import com.example.banco.domain.model.CartaoCredito;
import com.example.banco.interfaces.dto.CartaoCreditoDTO;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cartao")
public class CartaoController {

    CartaoServiceImpl cartaoService;

    public CartaoController(CartaoServiceImpl cartaoService) {
        this.cartaoService = cartaoService;
    }

    @GetMapping
    public ResponseEntity<List<CartaoCredito>> listarCartoes(){
        return ResponseEntity.ok(cartaoService.listarCartoes());
    }

    @PostMapping
    public CartaoCredito salvarCartao(@Valid @RequestBody CartaoCreditoDTO cartaoDTO) {
        var cartao = new CartaoCredito();
        BeanUtils.copyProperties(cartaoDTO, cartao);
        return cartaoService.criarCartao(cartao);
    }

}
