package com.school.schoolsystem.controllers;

import com.school.schoolsystem.dtos.CoordinatorRecordDto;
import com.school.schoolsystem.models.CoordinatorModel;
import com.school.schoolsystem.services.CoordinatorService;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CoordinatorController {

    @Autowired
    CoordinatorService coordinatorService;

    @PostMapping("/coordenador/cadastrar-estudante")
    public ResponseEntity<CoordinatorModel> registerStudent(@RequestBody @Valid CoordinatorRecordDto coordinatorRecordDto) {
        var studentModel = new CoordinatorModel();
        BeanUtils.copyProperties(coordinatorRecordDto, studentModel);
        return ResponseEntity.status(HttpStatus.CREATED).body(coordinatorService.save(studentModel));
    }

    @GetMapping("/coordenador/estudantes")
    public ResponseEntity<List<CoordinatorModel>> listAllStudents() {
        return ResponseEntity.status(HttpStatus.OK).body(coordinatorService.findAll());
    }

}
