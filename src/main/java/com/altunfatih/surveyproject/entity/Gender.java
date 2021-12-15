package com.altunfatih.surveyproject.entity;

public enum Gender {
	Male(1), Female(2);
	
	private int code;
	
	Gender(int code) {
		this.code = code;
	}
	
	public int getCode() {
		return code;
	}
}
