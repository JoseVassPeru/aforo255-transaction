package com.AFORO255.MS.TEST.Transaction.service;

import com.AFORO255.MS.TEST.Transaction.model.entity.Operation;

public interface IOperationService {
    public Operation save(Operation operation);
    public Iterable<Operation> findByInvoiceId(Integer idInvoice);
    public Iterable<Operation> findAll();
}
