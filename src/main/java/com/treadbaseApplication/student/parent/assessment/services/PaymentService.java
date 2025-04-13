package com.treadbaseApplication.student.parent.assessment.services;

import com.treadbaseApplication.student.parent.assessment.dtos.PaymentRequest;
import com.treadbaseApplication.student.parent.assessment.dtos.PaymentResponse;

public interface PaymentService {
    PaymentResponse processPayment(PaymentRequest paymentRequest);
}
