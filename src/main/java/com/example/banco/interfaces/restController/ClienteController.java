package com.example.banco.interfaces.restController;

import com.example.banco.application.service.ClienteServiceImpl;
import com.example.banco.domain.model.Cliente;
import com.example.banco.interfaces.dto.ClienteDTO;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    ClienteServiceImpl clienteService;

    public ClienteController(ClienteServiceImpl clienteService) {
        this.clienteService = clienteService;
    }

    @GetMapping
    public ResponseEntity<List<Cliente>> listarTodosClientes(){
        return ResponseEntity.ok(clienteService.listarClientes());
    }

    @PostMapping
    public Cliente salvarCliente(@Valid @RequestBody ClienteDTO clienteDTO) {
        var cliente = new Cliente();
        BeanUtils.copyProperties(clienteDTO, cliente);
        return clienteService.criarCliente(cliente);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarCliente(@PathVariable Long id){
        clienteService.deletarCliente(id);
        return ResponseEntity.ok().build();
    }

}
