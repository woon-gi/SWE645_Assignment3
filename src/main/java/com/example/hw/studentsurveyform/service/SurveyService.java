package com.example.hw.studentsurveyform.service;

import org.springframework.stereotype.Service;
import com.example.hw.studentsurveyform.model.Survey;
import com.example.hw.studentsurveyform.repository.SurveyRepository;

import java.util.List;
import java.util.Optional;

@Service
public class SurveyService {
    public SurveyRepository surveyRepository;

    public SurveyService(SurveyRepository surveyRepository) {
        this.surveyRepository = surveyRepository;
    }

    public List<Survey> getAllSurveys() {
        return surveyRepository.findAll();
    }

    public Survey saveSurvey(Survey survey) {
        return surveyRepository.save(survey);
    }
}
