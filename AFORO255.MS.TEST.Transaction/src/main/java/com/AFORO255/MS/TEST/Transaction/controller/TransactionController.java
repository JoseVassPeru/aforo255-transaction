package com.AFORO255.MS.TEST.Transaction.controller;

import com.AFORO255.MS.TEST.Transaction.model.entity.Operation;
import com.AFORO255.MS.TEST.Transaction.service.IOperationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TransactionController {

    @Autowired
    private IOperationService operationService;

    @GetMapping("/operation/{idInvoice}")
    public ResponseEntity<?> obtenerByInvoiceId(@PathVariable Integer idInvoice){
        Iterable<Operation> iOperation = operationService.findByInvoiceId(idInvoice);
        return ResponseEntity.ok(iOperation);
    }
    @GetMapping("/listar")
    public List<Operation> listar(){
        return (List<Operation>) operationService.findAll();
    }

}
