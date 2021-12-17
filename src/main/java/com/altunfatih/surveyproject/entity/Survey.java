package com.altunfatih.surveyproject.entity;

import java.util.Date;

import javax.persistence.Embeddable;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Embeddable
@MappedSuperclass
public class Survey {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	private String name;
	private String surname;
	
	@Enumerated
	private Gender gender;

	private String date;
	private String statement;
	
	@ManyToOne
	@JoinColumn(name = "pollster_id", referencedColumnName = "id")
	private Pollster pollster;
}
