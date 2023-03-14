package Model;

import java.util.ArrayList;
import java.util.Comparator;

public class College {


	private String collegeName;
	private ArrayList<lecturer> p= new ArrayList<lecturer> ();
	public College(String collegeName, ArrayList<lecturer> p) {
		
		this.collegeName = collegeName;
		this.p = p;
	}
	public void setLecturers(ArrayList<lecturer> lecturer) {
		this.p = lecturer;
	}

	public String getCollegeName() {
		return collegeName;
	}

	public ArrayList<lecturer> getP() {
		return p;
	}

	@Override
	public String toString() {
		String str = "           ";
		str+=p.size() + " Lecturers:\n";
		for(lecturer a : p) {
			str+= a.print()+"\n";
		}
		return "College Name: " + collegeName + str;
	}
	
	public static Comparator<College> getCompByName()
	{   
	 Comparator<College> comp = new Comparator<College>(){
	     @Override
	     public int compare(College t1, College t2)
	     {
	           return t1.collegeName.compareTo(t2.collegeName);
	     }        
	 };
	 return comp;
	}


	

	
}
