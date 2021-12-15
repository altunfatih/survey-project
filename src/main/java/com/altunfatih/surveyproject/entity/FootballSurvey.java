package com.altunfatih.surveyproject.entity;

import javax.persistence.Embeddable;
import javax.persistence.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Embeddable
@Entity
public class FootballSurvey extends Survey {
	private String favoriteTeam;
}
