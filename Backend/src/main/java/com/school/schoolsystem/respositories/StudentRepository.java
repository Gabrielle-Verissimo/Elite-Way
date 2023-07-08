package com.school.schoolsystem.respositories;

import com.school.schoolsystem.models.CoordinatorModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface StudentRepository extends JpaRepository<CoordinatorModel, UUID> {
}
