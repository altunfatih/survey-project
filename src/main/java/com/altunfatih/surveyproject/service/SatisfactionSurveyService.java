package com.altunfatih.surveyproject.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.altunfatih.surveyproject.entity.SatisfactionSurvey;
import com.altunfatih.surveyproject.repository.SatisfactionSurveyRepository;

@Service
public class SatisfactionSurveyService {
	@Autowired
	private SatisfactionSurveyRepository satisfactionSurveyRepository;
	
	public SatisfactionSurvey addSatisfactionSurvey(SatisfactionSurvey satisfaction) {
		return satisfactionSurveyRepository.save(satisfaction);
	}
	
	public List<SatisfactionSurvey> findAllSatisfactionSurvey() {
		return satisfactionSurveyRepository.findAll();
	}
		
	public void deleteSatisfactionSurveyById(Long satisfactionSurveyId) {
		satisfactionSurveyRepository.deleteById(satisfactionSurveyId);
	}
}
