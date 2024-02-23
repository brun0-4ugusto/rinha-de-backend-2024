package com.orchers.rinhadebackend.controller;

import com.orchers.rinhadebackend.controller.dto.request.TransacaoDTORequest;
import com.orchers.rinhadebackend.service.TransacaoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TransacaoController {

    private final TransacaoService service;

    public TransacaoController(TransacaoService service) {
        this.service = service;
    }

    @PostMapping("/clientes/{id}/transacoes")
    public ResponseEntity<?> postTransacao(@PathVariable Integer id, @RequestBody TransacaoDTORequest body) {
        if (id > 5 || id < 1)
            return ResponseEntity.notFound().build();

        switch (body.tipo()) {
            case "c":
                return ResponseEntity.ok(service.executeCreditOperation(body, id));
            case "d":
                try {
                    return ResponseEntity.ok(service.executeDebitOperation(body, id));
                } catch (Exception e) {
                    return ResponseEntity.unprocessableEntity().build();
                }
            default:
                return ResponseEntity.unprocessableEntity().build();
        }
    }

}
