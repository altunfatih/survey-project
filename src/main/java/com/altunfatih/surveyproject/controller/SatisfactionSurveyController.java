package com.altunfatih.surveyproject.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.altunfatih.surveyproject.entity.SatisfactionSurvey;
import com.altunfatih.surveyproject.service.SatisfactionSurveyService;

@Controller
@RequestMapping("/api/satisfactionsurvey")
public class SatisfactionSurveyController {
	@Autowired
	private SatisfactionSurveyService satisfactionSurveyService;
	
	@GetMapping("/list")
	public String getAllListSatisfactionSurvey(Model model) {
		List<SatisfactionSurvey> allSatisfactionSurvey = satisfactionSurveyService.findAllSatisfactionSurvey();
		model.addAttribute("listSatisfactionSurvey", allSatisfactionSurvey);

		return "satisfaction_survey_list";
	}

	@GetMapping("/new")
	public String showSatisfactionSurveyNewForm(Model model) {
		model.addAttribute("satisfactionsurvey", new SatisfactionSurvey());

		return "satisfaction_survey_form";
	}

	@PostMapping("/save")
	public String saveSatisfactionSurvey(SatisfactionSurvey satisfactionSurvey) {
		satisfactionSurveyService.addSatisfactionSurvey(satisfactionSurvey);

		return "redirect:/api/satisfactionsurvey/list";
	}

	@GetMapping("/delete/{id}")
	public String deleteSatisfactionSurveyForm(@PathVariable("id") Long id, Model model) {
		satisfactionSurveyService.deleteSatisfactionSurveyById(id);

		return "redirect:/api/satisfactionsurvey/list";
	}
}
