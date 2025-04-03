package com.example.hw.studentsurveyform.model;

import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.Map;


import com.example.hw.studentsurveyform.model.Survey;
import com.example.hw.studentsurveyform.service.SurveyService;

@RestController
@RequestMapping("/api/surveys")
public class SurveyController {
    private final SurveyService surveyService;

    public SurveyController(SurveyService surveyService) {
        this.surveyService = surveyService;
    }

    // Get all surveys
    @GetMapping
    public List<Survey> getAllSurveys() {
        return surveyService.getAllSurveys();
    }

    // Create a survey
    @PostMapping("/create")
    public ResponseEntity<Survey> createSurvey(@RequestBody Survey survey) {
        return new ResponseEntity<>(surveyService.saveSurvey(survey), HttpStatus.CREATED);
    }

    // Search surveys by name
    @GetMapping("/search")
    public List<Survey> getAllSurveysByName(@RequestParam String name) {
        return surveyService.getAllSurveysByName(name);
    }

    // Update a survey
    @PutMapping("/update")
    public ResponseEntity<Survey> updateSurvey(@RequestBody Survey survey) {
        return new ResponseEntity<>(surveyService.updateSurvey(survey), HttpStatus.OK);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<Void> deleteSurvey(@RequestBody Map<String, Long> payload) {
        Long surveyId = payload.get("id");
        surveyService.deleteSurveyById(surveyId);
        return ResponseEntity.ok().build();
    }

}
