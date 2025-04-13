package com.treadbaseApplication.student.parent.assessment.dtos;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Map;

@Data
public class PaymentResponse {
    private String message;
    private Long studentId;
    private BigDecimal updatedStudentBalance;
    private Map<Long, BigDecimal> updatedParentBalances;

    public PaymentResponse(String message,
                           Long studentId,
                           BigDecimal updatedStudentBalance,
                           Map<Long,BigDecimal> updatedParentBalances){
        this.message = message;
        this.studentId = studentId;
        this.updatedStudentBalance = updatedStudentBalance;
        this.updatedParentBalances = updatedParentBalances;

    }
    public String getMessage(){
        return message;
    }
    public void setMessage(String message){
        this.message = message;
    }

    public Long getStudentId(){
        return studentId;
    }
    public void setStudentId(Long studentId){
        this.studentId = studentId;
    }

    public BigDecimal getUpdatedStudentBalance(){
        return updatedStudentBalance;
    }
    public void setUpdatedStudentBalance(BigDecimal updatedStudentBalance){
        this.updatedStudentBalance = updatedStudentBalance;
    }

    public void setUpdatedParentBalances(Map<Long, BigDecimal> updatedParentBalances) {
        this.updatedParentBalances = updatedParentBalances;
    }

    public Map<Long, BigDecimal> getUpdatedParentBalances() {
        return updatedParentBalances;
    }
}
