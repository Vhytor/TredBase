package com.treadbaseApplication.student.parent.assessment.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Data
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long paymentId;
    private Long parentId;
    private Long studentId;
    private BigDecimal originalAmount;
    private BigDecimal adjustedAmount;
    private LocalDateTime timestamp;
}
