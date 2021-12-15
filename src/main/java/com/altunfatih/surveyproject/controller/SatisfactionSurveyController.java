package com.altunfatih.surveyproject.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.altunfatih.surveyproject.entity.SatisfactionSurvey;
import com.altunfatih.surveyproject.service.SatisfactionSurveyService;

@RestController
@RequestMapping("/api/satisfaction")
public class SatisfactionSurveyController {
	@Autowired
	private SatisfactionSurveyService satisfactionSurveyService;
	
	@PostMapping("/save")
	public ResponseEntity<SatisfactionSurvey> addSatisfactionSurvey(@RequestBody SatisfactionSurvey satisfactionSurvey) {
		SatisfactionSurvey addSatisfactionSurvey = satisfactionSurveyService.addSatisfactionSurvey(satisfactionSurvey);
		
		return new ResponseEntity<SatisfactionSurvey>(addSatisfactionSurvey, HttpStatus.CREATED);
	}
	
	@GetMapping("/all")
    public ResponseEntity<List<SatisfactionSurvey>> getAllSatisfactionSurvey(){
        List<SatisfactionSurvey> allSatisfactionSurvey = satisfactionSurveyService.findAllSatisfactionSurvey();
        
        return new ResponseEntity<List<SatisfactionSurvey>>(allSatisfactionSurvey, HttpStatus.OK);
    }
	
	@DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteSatisfactionSurveyById(@PathVariable("id") Long id){
		satisfactionSurveyService.deleteSatisfactionSurveyById(id);
        
        return new ResponseEntity<Void>(HttpStatus.ACCEPTED);
    }
}
