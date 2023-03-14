package Listeners;


import Model.lecturer.degreeType;

import Model.lecturer;

import java.util.ArrayList;

public interface ViewListenable {


	String ViewWantsTheWinners();
	lecturer ViewAsksLecturerByName(String name);
	lecturer ViewAsksPLecturerByName(String name);
	lecturer ViewAsksOLecturerByName(String name);
	String ViewAsksToSortByName(String source);
	String ViewAsksToSortByID();
	String ViewWantsAllUnions();
	String ViewWantsAllColleges();
	String ViewWantsAllLecturers();
	void ViewWantToAddPLecturer(String name, int id, degreeType type, String specialization, int salaryPerMonth, int numOfYears,String committe);
	void ViewWantToAddOLecturer(String name, int id, degreeType type, String specialization, int salaryPerDay);
	void ViewWantToEditPunion(String name, ArrayList<lecturer> lecturer);
	void ViewWantToEditOunion(String name, ArrayList<lecturer> lecturer);
	void ViewAskToStartTheOlympic();
	void ViewWantToAddCollege(String name, ArrayList<lecturer> lecturer);

}
