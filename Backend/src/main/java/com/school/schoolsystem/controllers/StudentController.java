package com.school.schoolsystem.controllers;

import com.school.schoolsystem.dtos.StudentRecordDto;
import com.school.schoolsystem.models.StudentModel;
import com.school.schoolsystem.services.StudentService;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
public class StudentController {

    @Autowired
    StudentService studentService;
 //page={page}&pageSize={size}
    @GetMapping("/students")
    public ResponseEntity<Page<StudentModel>> getAllStudents(
            @RequestParam(value = "page", defaultValue = "0", required = false) int page,
            @RequestParam(value = "qntElem", defaultValue = "10", required = false) int qntElem
    ){
        Pageable pageable = PageRequest.of(page, qntElem);
        Page<StudentModel> students = studentService.findAll(pageable);
        if(!students.isEmpty()) {
            for(StudentModel student : students) {
                UUID id = student.getIdStudent();
                student.add(linkTo(methodOn(StudentController.class).getOneStudent(id)).withSelfRel());
            }
        }

        return ResponseEntity.status(HttpStatus.OK).body(students);
    }
    @GetMapping("/students/{id}")
    public ResponseEntity<Object> getOneStudent(@PathVariable(value = "id") UUID id){
        Optional<StudentModel> student = studentService.findById(id);
        if (student.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Student not found.");
        }
        int page = 0;
        int qntElem = 10;
        student.get().add(linkTo(methodOn(StudentController.class).getAllStudents(page, qntElem)).withRel("Students List"));
        return ResponseEntity.status(HttpStatus.OK).body(student.get());
    }
    @PostMapping("/register-student")
    public ResponseEntity<StudentModel> registerStudent(@RequestBody @Valid StudentRecordDto studentRecordDto) {
        var studentModel = new StudentModel();
        BeanUtils.copyProperties(studentRecordDto, studentModel);
        return ResponseEntity.status(HttpStatus.CREATED).body(studentService.save(studentModel));
    }

    @PutMapping("/students/{id}")
    public ResponseEntity<Object> updateStudent(@PathVariable(value = "id") UUID id,
                                                    @RequestBody @Valid StudentRecordDto studentRecordDto){
        Optional<StudentModel> student = studentService.findById(id);
        if (student.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Student not found.");
        }
        var studentModel = student.get();
        BeanUtils.copyProperties(studentRecordDto, studentModel);
        return ResponseEntity.status(HttpStatus.OK).body(studentService.save(studentModel));
    }
    @DeleteMapping("/students/{id}")
    public ResponseEntity<Object> deleteStudent(@PathVariable(value = "id") UUID id){
        Optional<StudentModel> student = studentService.findById(id);
        if (student.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Student not found.");
        }
        studentService.delete(student.get());
        return ResponseEntity.status(HttpStatus.OK).body("Student deleted successfully.");
    }

}
