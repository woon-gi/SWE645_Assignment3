package com.example.hw.studentsurveyform.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.hw.studentsurveyform.model.Survey;

public interface SurveyRepository extends JpaRepository<Survey, Long> {
}
