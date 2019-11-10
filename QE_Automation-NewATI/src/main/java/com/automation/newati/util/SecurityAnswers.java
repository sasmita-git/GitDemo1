package com.automation.newati.util;
import com.fasterxml.jackson.annotation.JsonProperty;

public class SecurityAnswers {
	
	SecurityAnswers(int SecurityQuestionID, String Answer) {
		this.SecurityQuestionID = SecurityQuestionID;
		this.Answer = Answer;
	}
	
	@JsonProperty("SecurityQuestionID")
	private int SecurityQuestionID;
	
	
	public void setSecurityQuestionID(int securityQuestionID) {
		SecurityQuestionID = securityQuestionID;
	}
	
	public void setAnswer(String answer) {
		Answer = answer;
	}
	@JsonProperty("Answer")
	private String Answer;
	
	
}
