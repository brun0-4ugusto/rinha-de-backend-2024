package com.orchers.rinhadebackend.controller;

import com.orchers.rinhadebackend.controller.dto.response.ExtratoDTOResponse;
import com.orchers.rinhadebackend.service.ExtratoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ExtratoController {

    private final ExtratoService service;

    public ExtratoController(ExtratoService service) {
        this.service = service;
    }

    @GetMapping("/clientes/{id}/extrato")
    public ResponseEntity<ExtratoDTOResponse> getExtrato(@PathVariable Integer id) {
        if (id > 5 || id < 1) {
            return ResponseEntity.notFound().build();
        }
        try {
            return ResponseEntity.ok(service.getExtrato(id));
        } catch (Exception e) {
            return ResponseEntity.unprocessableEntity().build();
        }
    }
}
