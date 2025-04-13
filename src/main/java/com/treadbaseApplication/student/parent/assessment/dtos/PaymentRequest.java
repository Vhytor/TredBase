package com.treadbaseApplication.student.parent.assessment.dtos;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class PaymentRequest {
    private Long parentId;
    private Long studentId;
    private BigDecimal paymentAmount;

    public void setParentId(Long parentId){
        this.parentId = parentId;
    }
    public Long getParentId(){
        return parentId;
    }
    public void setStudentId(Long studentId){
        this.studentId = studentId;
    }
    public Long getStudentId(){
        return studentId;
    }
    public void setPaymentAmount(BigDecimal paymentAmount){
        this.paymentAmount = paymentAmount;
    }
    public BigDecimal getPaymentAmount(){
        return paymentAmount;
    }
}
