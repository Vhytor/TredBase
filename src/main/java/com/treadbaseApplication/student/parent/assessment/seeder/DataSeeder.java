package com.treadbaseApplication.student.parent.assessment.seeder;

import com.treadbaseApplication.student.parent.assessment.model.Parent;
import com.treadbaseApplication.student.parent.assessment.model.Student;
import com.treadbaseApplication.student.parent.assessment.repositories.ParentRepository;
import com.treadbaseApplication.student.parent.assessment.repositories.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.List;

@Component
@RequiredArgsConstructor
public class DataSeeder implements CommandLineRunner {
    @Autowired
    private ParentRepository parentRepository;
    @Autowired
    private StudentRepository studentRepository;

    @Override
    public void run(String... args){
        Parent parentA = new Parent();
        parentA.setParentName("Eni");
        parentA.setBalance(new BigDecimal("500"));

        Parent parentB = new Parent();
        parentB.setParentName("Ani");
        parentB.setBalance(new BigDecimal("300"));

        parentRepository.saveAll(List.of(parentA,parentB));

        Student studentA = new Student();
        studentA.setStudentName("Vic");
        studentA.setBalance(new BigDecimal("150"));
        studentA.getParents().add(parentA);
        studentA.getParents().add(parentB);

        Student studentB = new Student();
        studentB.setStudentName("Chukwuka");
        studentB.setBalance(new BigDecimal("100"));
        studentB.getParents().add(parentA);

        Student studentC = new Student();
        studentC.setStudentName("Ken");
        studentC.setBalance(new BigDecimal("90"));
        studentC.getParents().add(parentB);

        studentRepository.saveAll(List.of(studentA,studentB,studentC));
    }
}
