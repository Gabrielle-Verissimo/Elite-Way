package com.school.schoolsystem.services;

import com.school.schoolsystem.models.StudentModel;
import com.school.schoolsystem.respositories.StudentRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class StudentService {
    @Autowired
    StudentRepository studentRepository;

    public Page<StudentModel> findAll(Pageable pageable) {
        return studentRepository.findAll(pageable);
    }

    public Optional<StudentModel> findById(UUID id) {
        return studentRepository.findById(id);
    }
    public Optional<StudentModel> findBySchoolEnrollment(String schoolEnrollment) {
        return studentRepository.findBySchoolEnrollment(schoolEnrollment);
    }
    @Transactional
    public StudentModel save(StudentModel studentModel) {
        return studentRepository.save(studentModel);
    }
    @Transactional
    public void delete(StudentModel studentModel) {
        studentRepository.delete(studentModel);
    }
}
