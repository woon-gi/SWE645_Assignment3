package com.example.hw.studentsurveyform.model;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.hw.studentsurveyform.model.Survey;
import com.example.hw.studentsurveyform.service.SurveyService;

@RestController
@RequestMapping("/api/surveys")
public class SurveyController {
    private final SurveyService surveyService;

    public SurveyController(SurveyService surveyService) {
        super();
        this.surveyService = surveyService;
    }

    // get all surveys
    @GetMapping
    public List<Survey> getAllSurveys() {
        return surveyService.getAllSurveys();
    }

    // create a survey
    @PostMapping("/create")
    public ResponseEntity<Survey> createSurvey(@RequestBody Survey survey) {
        return new ResponseEntity<Survey>(surveyService.saveSurvey(survey), HttpStatus.CREATED);
    }
}
