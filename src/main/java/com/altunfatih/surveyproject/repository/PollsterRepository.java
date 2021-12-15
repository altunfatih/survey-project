package com.altunfatih.surveyproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.altunfatih.surveyproject.entity.Pollster;

public interface PollsterRepository extends JpaRepository<Pollster, Long> {
}
