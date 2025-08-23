package com.deliverytech.delivery.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.deliverytech.delivery.dto.ClienteDTO;
import com.deliverytech.delivery.service.ClienteServiceImpl;

import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;



@CrossOrigin(origins = "*")
@RestController
@Controller
@RequestMapping("/api/clientes")

@ApiResponses({
        @ApiResponse(responseCode = "201", description = "Cliente criado com sucesso"),
        @ApiResponse(responseCode = "400", description = "Dados inválidos"),
        @ApiResponse(responseCode = "409", description = "Cliente já existe")
})
public class ClienteController {
    @Autowired
    private final ClienteServiceImpl clienteService;

    public ClienteController(ClienteServiceImpl clienteService) {
        this.clienteService = clienteService;
    }

    @GetMapping("/listar")
    public List<ClienteDTO> listClientes() {
        return clienteService.findAll();
    }

    @GetMapping("/{id}")
    public ClienteDTO findById(Long id){
        return null;//clienteService.findById(id);
    }

    @PostMapping("/cadastrar")
    public ResponseEntity<Long> cadastrarCliente(@RequestBody ClienteDTO clienteDTO) {
        Long id = clienteService.cadastrarCliente(clienteDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(id);
    }
}
