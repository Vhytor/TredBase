package com.treadbaseApplication.student.parent.assessment.controller;

import com.treadbaseApplication.student.parent.assessment.dtos.PaymentRequest;
import com.treadbaseApplication.student.parent.assessment.dtos.PaymentResponse;
import com.treadbaseApplication.student.parent.assessment.services.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/payments")
public class PaymentController {
    @Autowired
    private PaymentService paymentService;

    @PostMapping
    public ResponseEntity<?> processPayment(@RequestBody PaymentRequest paymentRequest){
        PaymentResponse paymentResponse = paymentService.processPayment(paymentRequest);
        return ResponseEntity.ok(paymentResponse);
    }
}
