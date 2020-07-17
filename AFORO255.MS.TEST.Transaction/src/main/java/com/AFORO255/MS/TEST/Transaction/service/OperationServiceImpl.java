package com.AFORO255.MS.TEST.Transaction.service;

import com.AFORO255.MS.TEST.Transaction.model.entity.Operation;
import com.AFORO255.MS.TEST.Transaction.model.repository.IOperationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OperationServiceImpl implements IOperationService{

    @Autowired
    private IOperationRepository iOperationRepository;

    @Override
    public Operation save(Operation operation) {
        return iOperationRepository.save(operation);
    }

    @Override
    public Iterable<Operation> findByInvoiceId(Integer idInvoice) {
        return iOperationRepository.findByInvoiceId(idInvoice);
    }

    @Override
    public Iterable<Operation> findAll() {
        return iOperationRepository.findAll();
    }
}
