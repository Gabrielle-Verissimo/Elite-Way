package com.school.schoolsystem.respositories;

import com.school.schoolsystem.models.StudentModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface StudentRepository extends JpaRepository<StudentModel, UUID> {
    Optional<StudentModel> findBySchoolEnrollment(String schoolEnrollment);
}
