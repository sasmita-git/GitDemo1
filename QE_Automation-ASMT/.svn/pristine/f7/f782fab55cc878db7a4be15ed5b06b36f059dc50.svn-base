package com.automation.asmt.utils;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class APIPojoClass {
	
	APIPojoClass(String SessionKey, int ApplicationID, UserData userData) {
		this.SessionKey = SessionKey;
		this.ApplicationID = ApplicationID;
		this.userData = userData;
	}
	
	@JsonProperty("SessionKey")
	private String SessionKey;
	
	@JsonProperty("ApplicationID")
	private int ApplicationID;
	
	@JsonProperty("UserData")
	private UserData userData;
	
	private List<SecurityAnswers> securityAnswers;
	
	
	public void setUserData(UserData userData) {
		this.userData = userData;
	}
	
	public void setSessionKey(String sessionKey) {
		SessionKey = sessionKey;
	}
	public void setApplicationID(int applicationID) {
		ApplicationID = applicationID;
	}

}
