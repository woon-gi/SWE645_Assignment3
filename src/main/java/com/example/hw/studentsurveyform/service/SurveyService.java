package com.example.hw.studentsurveyform.service;

import org.springframework.stereotype.Service;
import com.example.hw.studentsurveyform.model.Survey;
import com.example.hw.studentsurveyform.repository.SurveyRepository;

import java.util.List;
import java.util.Optional;

@Service
public class SurveyService {
    private final SurveyRepository surveyRepository;

    public SurveyService(SurveyRepository surveyRepository) {
        this.surveyRepository = surveyRepository;
    }

    public List<Survey> getAllSurveys() {
        return surveyRepository.findAll();
    }

    public Survey saveSurvey(Survey survey) {
        return surveyRepository.save(survey);
    }

    public void deleteSurveyById(Long id) {
        surveyRepository.deleteById(id);
    }

    public Survey updateSurvey(Survey survey) {
        Optional<Survey> optionalSurvey = surveyRepository.findById(survey.getId());
        if (optionalSurvey.isPresent()) {
            Survey existingSurvey = optionalSurvey.get();
            // Update fields 
            existingSurvey.setFirstName(survey.getFirstName());
            existingSurvey.setLastName(survey.getLastName());
            existingSurvey.setEmail(survey.getEmail());
            existingSurvey.setStreetAddress(survey.getStreetAddress());
            existingSurvey.setCity(survey.getCity());
            existingSurvey.setState(survey.getState());
            existingSurvey.setZip(survey.getZip());
            existingSurvey.setPhoneNumber(survey.getPhoneNumber());
            existingSurvey.setDateOfSurvey(survey.getDateOfSurvey());
            existingSurvey.setLikedMost(survey.getLikedMost());
            existingSurvey.setInterestedIn(survey.getInterestedIn());
            existingSurvey.setLikelihood(survey.getLikelihood());

            return surveyRepository.save(existingSurvey);
        } else {
            throw new RuntimeException("Survey not found with ID" + survey.getId());
        }
    }

    // New method to search surveys by name
    public List<Survey> getAllSurveysByName(String name) {
        return surveyRepository.findByFirstNameContainingIgnoreCase(name);
    }
}
