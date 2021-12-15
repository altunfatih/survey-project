package com.altunfatih.surveyproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.altunfatih.surveyproject.entity.SatisfactionSurvey;

public interface SatisfactionSurveyRepository extends JpaRepository<SatisfactionSurvey, Long> {
}
