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

import com.altunfatih.surveyproject.entity.Pollster;
import com.altunfatih.surveyproject.service.PollsterService;

@RestController
@RequestMapping("/api/pollster")
public class PollsterController {
	@Autowired
	private PollsterService pollsterService;
	
	@PostMapping("/save")
	public ResponseEntity<Pollster> addPollster(@RequestBody Pollster pollster) {
		Pollster addPollster = pollsterService.addPollster(pollster);
		
		return new ResponseEntity<Pollster>(addPollster, HttpStatus.CREATED);
	}
	
	@GetMapping("/all")
    public ResponseEntity<List<Pollster>> getAllPollster(){
        List<Pollster> allPollster = pollsterService.findAllPollster();
        
        return new ResponseEntity<List<Pollster>>(allPollster, HttpStatus.OK);
    }
	
	@DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deletePollsterById(@PathVariable("id") Long id){
		pollsterService.deletePollsterById(id);
        
        return new ResponseEntity<Void>(HttpStatus.ACCEPTED);
    }
}
