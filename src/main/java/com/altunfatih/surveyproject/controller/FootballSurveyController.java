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

import com.altunfatih.surveyproject.entity.FootballSurvey;
import com.altunfatih.surveyproject.service.FootballSurveyService;

@RestController
@RequestMapping("/api/football")
public class FootballSurveyController {
	@Autowired
	private FootballSurveyService footballSurveyService;
	
	@PostMapping("/save")
	public ResponseEntity<FootballSurvey> addFootballSurvey(@RequestBody FootballSurvey footballSurvey) {
		FootballSurvey addfootballSurvey = footballSurveyService.addFootballSurvey(footballSurvey);
		
		return new ResponseEntity<FootballSurvey>(addfootballSurvey, HttpStatus.CREATED);
	}
	
	@GetMapping("/all")
    public ResponseEntity<List<FootballSurvey>> getAllFootballSurvey(){
        List<FootballSurvey> allFootballSurvey = footballSurveyService.findAllFootballSurvey();
        
        return new ResponseEntity<List<FootballSurvey>>(allFootballSurvey, HttpStatus.OK);
    }
	
	@DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteFootballSurveyById(@PathVariable("id") Long id){
        footballSurveyService.deleteFootballSurveyById(id);
        
        return new ResponseEntity<Void>(HttpStatus.ACCEPTED);
    }
}
