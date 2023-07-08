package com.school.schoolsystem.services;

import com.school.schoolsystem.models.CoordinatorModel;
import com.school.schoolsystem.respositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CoordinatorService {
    @Autowired
    StudentRepository studentRepository;

    public CoordinatorModel save(CoordinatorModel coordinatorModel) {
        return studentRepository.save(coordinatorModel);
    }

    public List<CoordinatorModel> findAll() {
        return  studentRepository.findAll();
    }
}
