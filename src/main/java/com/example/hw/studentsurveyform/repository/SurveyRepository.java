package com.example.hw.studentsurveyform.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.hw.studentsurveyform.model.Survey;

public interface SurveyRepository extends JpaRepository<Survey, Long> {
    List<Survey> findByFirstNameContainingIgnoreCase(String firstName);
}
