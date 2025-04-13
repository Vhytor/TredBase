package com.treadbaseApplication.student.parent.assessment.repositories;

import com.treadbaseApplication.student.parent.assessment.model.Parent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ParentRepository extends JpaRepository<Parent,Long> {
}
