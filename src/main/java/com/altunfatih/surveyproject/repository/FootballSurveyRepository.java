package com.altunfatih.surveyproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.altunfatih.surveyproject.entity.FootballSurvey;

public interface FootballSurveyRepository extends JpaRepository<FootballSurvey, Long> {
}
