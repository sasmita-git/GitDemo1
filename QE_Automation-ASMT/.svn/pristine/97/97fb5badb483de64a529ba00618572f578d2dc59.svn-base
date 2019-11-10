package com.automation.asmt.utils;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import com.ascendlearning.automation.ui.config.PropertiesRepository;
import com.jayway.restassured.RestAssured;
import com.jayway.restassured.response.Response;

public class UserCreationUtils {


	private UserData userData;
	private List<SecurityAnswers> securityAnswers = new ArrayList<SecurityAnswers>();
	private static List<ResponseDetails> responseDetailsList = new ArrayList<ResponseDetails>();
	BufferedWriter bufferedWriter = null;
	FileWriter fileWriter = null;
	ResponsePojo responsePojo;

	public String getUserDetails() throws Exception {
		String userId = null;
		try {

			UserCreationUtils userCreationUtils = new UserCreationUtils();
			ResponsePojo responsePojo = null;
			String line = null;
			File file = new File("D:\\userDetails.txt");
			PrintWriter pw = null;
			ResponseDetails responseDetails = null;
			/*if (file.exists()) {
				file.delete();
				file.createNewFile();
			} else {
				file.createNewFile();
			}*/


			responseDetails = new ResponseDetails();
			/*
			 * fileWriter = new FileWriter(file, true); bufferedWriter = new
			 * BufferedWriter(fileWriter);
			 */
			UserData userData = userCreationUtils.setUserDataDetails();
			APIPojoClass pojo = new APIPojoClass(null, 1, userData);
			String url = PropertiesRepository.getString("user.creation.url");
			
			Response response = RestAssured.given().contentType("application/json").body(pojo).post(url);
			responsePojo = response.getBody().as(ResponsePojo.class);

			if (response.getStatusCode() == 200) {
				responseDetails.setUsername(responsePojo.getCreateProfileResult().getUsername());
				responseDetails.setPassword(responsePojo.getCreateProfileResult().getPassword());
				responseDetails.setInstitutionID(responsePojo.getCreateProfileResult().getInstitutionID());
				responseDetailsList.add(responseDetails);
				System.out.println("User Details --> " + responsePojo.getCreateProfileResult().getUsername());
				userId = responsePojo.getCreateProfileResult().getUsername();
			} else {
				System.out.println("Response code is not 200");
			}
		
			
	/*		pw = new PrintWriter(new FileOutputStream(file, true));
			int size = responseDetailsList.size();

			for (int index = 0; index < size; index++) {
				ResponseDetails responseDetailsValue = responseDetailsList.get(index);
				pw.write("UuserName: " + responseDetailsValue.getUsername() + "\n" + "Password: "
						+ responseDetailsValue.getPassword() + "\n" + "InstitutionID: "
						+ responseDetailsValue.getInstitutionID() + "\n");
			}
			pw.close();*/
			System.out.println("Completed");
		
		} catch(Exception e) {
			System.out.println("Error while creating user");
		}
		return userId;
	}
	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws Exception {
		UserCreationUtils userCreationUtils = new UserCreationUtils();
		System.out.println(userCreationUtils.getUserDetails());
	}
	

	public UserData setUserDataDetails() {
		userData = new UserData();
		String todayAsString = new SimpleDateFormat("ddMMyyyy").format(new Date());
		String userName = ("AU_ASMT" + todayAsString + (int) (Math.random() * 999));
		//String userName = ("AU_ASMT_TEAS_User4");
		
		userData.setFirstName("Automation");
		userData.setMiddleName("MI");
		userData.setLastName("User");
		userData.setEmail(userName + "@ascendlearning.com");
		userData.setPassword("Test123");
		userData.setStreet("41 Madison Avenue");
		userData.setStreet2("");
		userData.setStreet3("");
		userData.setCity("NewYork");
		userData.setStateID("NY");
		userData.setZip("10010");
		userData.setCountryID(1);
		userData.setPhone("(123) 456-7899");
		userData.setApplicationID(1);
		userData.setRoleID(2);
		userData.setInstitutionID(7717);
		userData.setCredentials("");
		userData.setStudentID("");
		userData.setIsNonDegreeSeeking(false);
		userData.setIsOptInCommunication(true);
		userData.setAccommodationFactor("1");
		
		
		// private RaceIDs[] RaceIDs;
		userData.setLanguageID(0);
		userData.setGender("M");
		String expDate = "/Date(" + convertDateToEpochFormat() + "-0000)/";
		userData.setExpectedGraduationDate(expDate);
		userData.setUsername(userName);
		userData.setDateOfBirth("/Date(967746600000-0000)/");

		SecurityAnswers firstQuestion = new SecurityAnswers(29, "hm");
		SecurityAnswers secondQuestion = new SecurityAnswers(30, "hm");
		SecurityAnswers thirdQuestion = new SecurityAnswers(31, "hm");

		securityAnswers.add(firstQuestion);
		securityAnswers.add(secondQuestion);
		securityAnswers.add(thirdQuestion);

		userData.setSecurityAnswers(securityAnswers);

		int[] RaceIDs = new int[1];
		RaceIDs[0] = 3;

		userData.setRaceIDs(RaceIDs);

		return userData;
	}

	public static String convertDateToEpochFormat() {
		String gdDate = null;
		try {
			SimpleDateFormat dateFormat = new SimpleDateFormat("MMM dd yyyy HH:mm:ss.SSS zzz");
			Calendar cal = Calendar.getInstance();
			cal.add(Calendar.YEAR, 5);
			Date date = cal.getTime();
			String expectedDate = dateFormat.format(date);
			Date epochDate = dateFormat.parse(expectedDate);
			long epochDateFormat = epochDate.getTime();
			gdDate = String.valueOf(epochDateFormat);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return gdDate;
	}
	
	public String getUserDetailsNonPilotuser() throws Exception {
		String userId = null;
		try {

			UserCreationUtils userCreationUtils = new UserCreationUtils();
			ResponsePojo responsePojo = null;
			String line = null;
			File file = new File("D:\\userDetails.txt");
			PrintWriter pw = null;
			ResponseDetails responseDetails = null;
			/*if (file.exists()) {
				file.delete();
				file.createNewFile();
			} else {
				file.createNewFile();
			}*/


			responseDetails = new ResponseDetails();
			/*
			 * fileWriter = new FileWriter(file, true); bufferedWriter = new
			 * BufferedWriter(fileWriter);
			 */
			UserData userData = userCreationUtils.setUserDataDetailsNonPilotUser();
			APIPojoClass pojo = new APIPojoClass(null, 1, userData);
			String url = PropertiesRepository.getString("user.creation.url");
			
			Response response = RestAssured.given().contentType("application/json").body(pojo).post(url);
			responsePojo = response.getBody().as(ResponsePojo.class);

			if (response.getStatusCode() == 200) {
				responseDetails.setUsername(responsePojo.getCreateProfileResult().getUsername());
				responseDetails.setPassword(responsePojo.getCreateProfileResult().getPassword());
				responseDetails.setInstitutionID(responsePojo.getCreateProfileResult().getInstitutionID());
				responseDetailsList.add(responseDetails);
				System.out.println("User Details --> " + responsePojo.getCreateProfileResult().getUsername());
				userId = responsePojo.getCreateProfileResult().getUsername();
			} else {
				System.out.println("Response code is not 200");
			}
		
			
	/*		pw = new PrintWriter(new FileOutputStream(file, true));
			int size = responseDetailsList.size();

			for (int index = 0; index < size; index++) {
				ResponseDetails responseDetailsValue = responseDetailsList.get(index);
				pw.write("UuserName: " + responseDetailsValue.getUsername() + "\n" + "Password: "
						+ responseDetailsValue.getPassword() + "\n" + "InstitutionID: "
						+ responseDetailsValue.getInstitutionID() + "\n");
			}
			pw.close();*/
			System.out.println("Completed");
		
		} catch(Exception e) {
			System.out.println("Error while creating user");
		}
		return userId;
	}
	
	public UserData setUserDataDetailsNonPilotUser() {
		userData = new UserData();
		String todayAsString = new SimpleDateFormat("ddMMyyyy").format(new Date());
		String userName = ("AU_ASMT" + todayAsString + (int) (Math.random() * 999));

		//New field added by Dev on 15th May 2019
		userData.setAccommodationFactor("1");
		
		userData.setFirstName("Automation");
		userData.setMiddleName("MI");
		userData.setLastName("User");
		userData.setEmail(userName + "@ascendlearning.com");
		userData.setPassword("Test@1234");
		userData.setStreet("41 Madison Avenue");
		userData.setStreet2("");
		userData.setStreet3("");
		userData.setCity("NewYork");
		userData.setStateID("NY");
		userData.setZip("10010");
		userData.setCountryID(1);
		userData.setPhone("+19173563546");
		userData.setApplicationID(1);
		userData.setRoleID(2);
		userData.setInstitutionID(7717);
		userData.setCredentials("");
		userData.setStudentID("");
		userData.setIsNonDegreeSeeking(false);
		userData.setIsOptInCommunication(true);
		// private RaceIDs[] RaceIDs;
		userData.setLanguageID(0);
		userData.setGender("M");
		String expDate = "/Date(" + convertDateToEpochFormat() + "-0000)/";
		userData.setExpectedGraduationDate(expDate);
		userData.setUsername(userName);
		userData.setDateOfBirth("/Date(967746600000-0000)/");

		SecurityAnswers firstQuestion = new SecurityAnswers(29, "hm");
		SecurityAnswers secondQuestion = new SecurityAnswers(30, "hm");
		SecurityAnswers thirdQuestion = new SecurityAnswers(31, "hm");

		securityAnswers.add(firstQuestion);
		securityAnswers.add(secondQuestion);
		securityAnswers.add(thirdQuestion);

		userData.setSecurityAnswers(securityAnswers);

		int[] RaceIDs = new int[1];
		RaceIDs[0] = 3;

		userData.setRaceIDs(RaceIDs);

		return userData;
	}

}
