package com.school.schoolsystem.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;
import java.util.UUID;
import org.springframework.hateoas.RepresentationModel;
@Entity
@Table(name = "STUDENT")
@Getter
@Setter
public class StudentModel extends RepresentationModel<StudentModel> implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID idStudent;
    private String name;
    private String yearsOld;
    private String schoolEnrollment;
    private String course;

}
