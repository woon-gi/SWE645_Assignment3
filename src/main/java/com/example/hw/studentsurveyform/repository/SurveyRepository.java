package com.example.hw.studentsurveyform.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.hw.studentsurveyform.model.Survey;

public interface SurveyRepository extends JpaRepository<Survey, Long> {
    // Custom finder method to search by first name (case-insensitive partial match)
    List<Survey> findByFirstNameContainingIgnoreCase(String firstName);
}
