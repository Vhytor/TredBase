package com.treadbaseApplication.student.parent.assessment.services.serviceImpl;

import com.treadbaseApplication.student.parent.assessment.dtos.PaymentRequest;
import com.treadbaseApplication.student.parent.assessment.dtos.PaymentResponse;
import com.treadbaseApplication.student.parent.assessment.model.Parent;
import com.treadbaseApplication.student.parent.assessment.model.Student;
import com.treadbaseApplication.student.parent.assessment.repositories.ParentRepository;
import com.treadbaseApplication.student.parent.assessment.repositories.StudentRepository;
import com.treadbaseApplication.student.parent.assessment.services.PaymentService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.HashMap;
import java.util.Map;

@Service
public class PaymentServiceImpl implements PaymentService {
    @Autowired
    private ParentRepository parentRepository;
    @Autowired
    private StudentRepository studentRepository;

    @Override
    @Transactional
    public PaymentResponse processPayment(PaymentRequest paymentRequest) {
        Parent parent = parentRepository.findById(paymentRequest.getParentId())
                .orElseThrow(()-> new RuntimeException("Parent not found"));
        Student student = studentRepository.findById(paymentRequest.getStudentId())
                .orElseThrow(()-> new RuntimeException("Student not found"));
        BigDecimal dynamicRate = new BigDecimal("0.1");
        BigDecimal adjustedAmount = paymentRequest.getPaymentAmount()
                .multiply(dynamicRate.add(BigDecimal.ONE))
                .setScale(2, RoundingMode.HALF_UP);

        Map<Long,BigDecimal> updatedBalances = new HashMap<>();

        if (student.getParents().size() > 1 ){
            BigDecimal splitAmount = adjustedAmount.divide(
                    BigDecimal.valueOf(student.getParents().size()),
                    2,
                    RoundingMode.HALF_UP
            );
            for (Parent parents : student.getParents()){
                parents.setBalance(parents.getBalance().subtract(splitAmount));
                parentRepository.save(parents);
                updatedBalances.put(parents.getParentId(),parents.getBalance());
            }
        }else{
            parent.setBalance(parent.getBalance().subtract(adjustedAmount));
            parentRepository.save(parent);
            updatedBalances.put(parent.getParentId(),parent.getBalance());
        }
        student.setBalance(student.getBalance().add(paymentRequest.getPaymentAmount()));
        studentRepository.save(student);
        return new PaymentResponse(
                "Payment processed successfully",
                student.getStudentId(),
                student.getBalance(),
                updatedBalances
        );
    }
}
