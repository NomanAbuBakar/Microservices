package com.payment.service.controllers;

import com.payment.service.PaymentService;
import com.payment.service.models.TransactionDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/payment")
public class PaymentController {
    @Autowired
    private PaymentService paymentService;

    @PostMapping("/doPayment")
    public ResponseEntity<Long> doPayment(@RequestBody TransactionDetails transactionDetails) {
        return new ResponseEntity<>(
                paymentService.doPayment(transactionDetails), HttpStatus.OK
        );
    }

    @GetMapping("/getPaymentDetailsByOrderId/{orderId}")
    public ResponseEntity<TransactionDetails> getPaymentDetailsByOrderId(@PathVariable String orderId) {
        return new ResponseEntity<>(paymentService.getPaymentDetailsByOrderId(orderId), HttpStatus.OK);
    }

}
