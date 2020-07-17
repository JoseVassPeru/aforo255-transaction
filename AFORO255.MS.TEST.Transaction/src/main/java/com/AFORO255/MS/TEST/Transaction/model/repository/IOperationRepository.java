package com.AFORO255.MS.TEST.Transaction.model.repository;

import com.AFORO255.MS.TEST.Transaction.model.entity.Operation;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

public interface IOperationRepository extends MongoRepository<Operation, String> {
    //listar todos los pagos de una factura
    @Query("{'idInvoice' :?0}")
    public Iterable<Operation> findByInvoiceId(Integer idInvoice);
}
