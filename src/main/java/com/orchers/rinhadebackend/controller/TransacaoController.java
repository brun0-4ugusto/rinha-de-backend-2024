package com.orchers.rinhadebackend.controller;

import com.orchers.rinhadebackend.controller.dto.request.TransacaoDTORequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TransacaoController {

    public ResponseEntity<?> postTransacao(@RequestBody TransacaoDTORequest body){

        return ResponseEntity.ok().build();
    }

}
