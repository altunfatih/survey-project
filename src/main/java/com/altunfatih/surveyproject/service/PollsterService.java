package com.altunfatih.surveyproject.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.altunfatih.surveyproject.entity.Pollster;
import com.altunfatih.surveyproject.repository.PollsterRepository;

@Service
public class PollsterService {
	@Autowired
	private PollsterRepository pollsterRepository;
	
	public Pollster addPollster(Pollster pollster) {
		return pollsterRepository.save(pollster);
	}
	
	public List<Pollster> findAllPollster() {
		return pollsterRepository.findAll();
	}
		
	public void deletePollsterById(Long pollsterId) {
		pollsterRepository.deleteById(pollsterId);
	}
}
