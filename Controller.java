package Controller;
import java.util.ArrayList;

import Listeners.ModelListenable;
import Listeners.ViewListenable;
import Model.lecturer;
import Model.lecturer.degreeType;
import Model.College;
import Model.Program;


import View.View;

public class Controller implements ModelListenable, ViewListenable {
	private Program theModel;
	private View theView;


	public Controller(Program o, View v) {
		theModel = o;
		theView = v;

		theModel.registerListener(this);
		theView.registerListener(this);
	}

	@Override
	public String ViewAsksToSortByName(String s) {
		if(s.equals("Lecturers")) {
			theModel.sortLecturerByName();return theModel.LecturerToString();}
		if(s.equals("Colleges")) {
			theModel.sortCollegesByName();return theModel.CollegeToString();}
		return null;
	}


	@Override
	public String ViewAsksToSortByID() {
		theModel.sortLecturerByID();return theModel.LecturerToString();}

	@Override
	public void ViewWantToAddPLecturer(String name, int id, degreeType type, String specialization, int salaryPerMonth, int numOfYears,String committe) {
		lecturer a = new lecturer(name, id, type, specialization,salaryPerMonth,numOfYears,committe);
		theModel.permanentecturer.add(a);
	}
	@Override
	public void ViewWantToAddOLecturer(String name, int id, degreeType type, String specialization, int salaryPerDay) {
		lecturer a = new lecturer(name, id, type, specialization,salaryPerDay);
		theModel.outsiderLecturer.add(a);
	}

	@Override
	public void ViewWantToAddCollege(String name, ArrayList<lecturer> lecturer) {
		College t = new College(name, lecturer);
		theModel.college.add(t);

	}


	@Override
	public String ViewWantsAllColleges() {
		return theModel.CollegeToString();		
	}

	@Override
	public String ViewWantsAllLecturers() {
		return theModel.LecturerToString();		
	}


	@Override
	public String ViewWantsAllUnions() {
		return theModel.AssociationToString();	
	}

	@Override
	public void ViewAskToStartTheOlympic() {
		theModel.start();

	}
	


	@Override
	public lecturer ViewAsksLecturerByName(String name) {
		for(lecturer a : theModel.permanentecturer)
			if (a.getName().equals(name)) 
				return a;
		for(lecturer a : theModel.outsiderLecturer)
			if (a.getName().equals(name)) 
				return a;
		return null;
	}

	@Override
	public String ViewWantsTheWinners() {
		System.out.println();
	if (theModel.permanentecturer.size() > theModel.outsiderLecturer.size()) {
		return "permanent union";
				}
	else if(theModel.permanentecturer.size() < theModel.outsiderLecturer.size()) {
		return "outsider union";
	}
	else 
		return "Both groups same size";
	
	
	}


	@Override
	public lecturer ViewAsksPLecturerByName(String name) {
		for(lecturer a : theModel.permanentecturer)
			if (a.getName().equals(name)) 
				return a;
		return null;
	}

	@Override
	public lecturer ViewAsksOLecturerByName(String name) {
		for(lecturer a : theModel.outsiderLecturer)
			if (a.getName().equals(name)) 
				return a;
		return null;
	}




	@Override
	public void ViewWantToEditPunion(String name, ArrayList<lecturer> lecturer) {
		lecturer l;
		l=ViewAsksPLecturerByName(name);
		theModel.Union.get(0).setChairman(l);
		theModel.Union.get(0).setLecturer(lecturer);
		
	}

	@Override
	public void ViewWantToEditOunion(String name, ArrayList<lecturer> lecturer) {
		lecturer l;
		l=ViewAsksPLecturerByName(name);
		theModel.Union.get(1).setChairman(l);
		theModel.Union.get(1).setLecturer(lecturer);
		
	}




}