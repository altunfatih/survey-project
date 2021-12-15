package com.altunfatih.surveyproject.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.altunfatih.surveyproject.entity.FootballSurvey;
import com.altunfatih.surveyproject.entity.Survey;
import com.altunfatih.surveyproject.repository.FootballSurveyRepository;

@Service
public class FootballSurveyService {
	@Autowired
	private FootballSurveyRepository footballSurveyRepository;
	
	public FootballSurvey addFootballSurvey(FootballSurvey footballSurvey) {
		return footballSurveyRepository.save(footballSurvey);
	}
	
	public List<FootballSurvey> findAllFootballSurvey() {
		return footballSurveyRepository.findAll();
	}
		
	public void deleteFootballSurveyById(Long footballSurveyId) {
		footballSurveyRepository.deleteById(footballSurveyId);
	}
}
