package com.school.schoolsystem.dtos;

import jakarta.validation.constraints.NotBlank;
public record StudentRecordDto(@NotBlank String name, @NotBlank String yearsOld, @NotBlank String schoolEnrollment, @NotBlank String course) {
}
