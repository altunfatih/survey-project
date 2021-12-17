package com.altunfatih.surveyproject.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.altunfatih.surveyproject.entity.FootballSurvey;
import com.altunfatih.surveyproject.service.FootballSurveyService;

@Controller
@RequestMapping("/api/footballsurvey")
public class FootballSurveyController {
	@Autowired
	private FootballSurveyService footballSurveyService;
	
	@GetMapping("/list")
	public String getAllListFootballSurvey(Model model) {
		List<FootballSurvey> allFootballSurvey = footballSurveyService.findAllFootballSurvey();
		model.addAttribute("listFootballSurvey", allFootballSurvey);

		return "football_survey_list";
	}

	@GetMapping("/new")
	public String showFootballSurveyNewForm(Model model) {
		model.addAttribute("footballsurvey", new FootballSurvey());

		return "football_survey_form";
	}

	@PostMapping("/save")
	public String saveFootballSurvey(FootballSurvey footballSurvey) {
		footballSurveyService.addFootballSurvey(footballSurvey);

		return "redirect:/api/footballsurvey/list";
	}

	@GetMapping("/delete/{id}")
	public String deleteFootballSurveyForm(@PathVariable("id") Long id, Model model) {
		footballSurveyService.deleteFootballSurveyById(id);

		return "redirect:/api/footballsurvey/list";
	}
}
