package com.treadbaseApplication.student.parent.assessment.repositories;

import com.treadbaseApplication.student.parent.assessment.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student,Long> {

}
