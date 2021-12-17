package com.altunfatih.surveyproject.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.altunfatih.surveyproject.entity.Pollster;
import com.altunfatih.surveyproject.service.PollsterService;

@Controller
@RequestMapping("/api/pollster")
public class PollsterController {
	@Autowired
	private PollsterService pollsterService;

	@GetMapping("/list")
	public String getAllListPollster(Model model) {
		List<Pollster> allPollster = pollsterService.findAllPollster();
		model.addAttribute("listPollsters", allPollster);

		return "pollster_list";
	}

	@GetMapping("/new")
	public String showPollsterNewForm(Model model) {
		model.addAttribute("pollster", new Pollster());

		return "pollster_form";
	}

	@PostMapping("/save")
	public String savePollster(Pollster pollster) {
		pollsterService.addPollster(pollster);

		return "redirect:/api/pollster/list";
	}

	@GetMapping("/delete/{id}")
	public String deletePollsterForm(@PathVariable("id") Long id, Model model) {
		pollsterService.deletePollsterById(id);

		return "redirect:/api/pollster/list";
	}
}
