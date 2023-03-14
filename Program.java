package Model;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Scanner;

import Listeners.ModelListenable;
import Model.lecturer.degreeType;
import Model.lecturer;

public class Program {
	
	private ArrayList<ModelListenable> allListeners;
	public ArrayList<lecturer> permanentecturer= new ArrayList<lecturer> ();
	public ArrayList<lecturer> outsiderLecturer= new ArrayList<lecturer>();
	public ArrayList<College> college= new ArrayList<College>();
	public ArrayList<Association> Union= new ArrayList<Association>();
	
	Scanner s = new Scanner(System.in);
	public Program() {
		allListeners = new ArrayList<ModelListenable>();

	}
	public void registerListener(ModelListenable l) {
		allListeners.add(l);
	}
	public void sortLecturerByName() {
		permanentecturer.sort(lecturer.getCompByName());
		outsiderLecturer.sort(lecturer.getCompByName());
	}
	public void sortLecturerByID() {
		permanentecturer.sort(lecturer.getCompByID());
		outsiderLecturer.sort(lecturer.getCompByID());
	}
	public void sortCollegesByName() {
		college.sort(College.getCompByName());
	}
	public ArrayList<lecturer> getPermanentUnion() {
		return permanentecturer;
	}

	public ArrayList<lecturer> getOutsiderLecturer() {
		return outsiderLecturer;
	}

	public String LecturerToString() {
		String str = "Permanents\n ";
		for (lecturer a : permanentecturer) {
			str+=a.print()+"\n";
		}
		
		str+= ("\nOutsiders\n");
		for (lecturer a : outsiderLecturer) {
			str+=a.print()+"\n";
		}
		return str;
	}
	public String CollegeToString() {
		String str = " ";
		for (College a : college) {
			str+=a.toString()+"\n";
		}
		return str;
	}
	public String AssociationToString() {
		String str = " ";
		for (Association a : Union) {
			str+=a.print()+"\n";
		}
		return str;
	}

	
	public void start() {
			
	this.permanentecturer.add(new lecturer("Efrat", 548967123,degreeType.valueOf("MA"),"data_base",12000,4,"exceptional"));
	this.permanentecturer.add(new lecturer("Arnon",273468891,degreeType.valueOf("MA"),"algorithm",10000,2,"teaching_committe"));
	this.permanentecturer.add(new lecturer("Sara", 654321987,degreeType.valueOf("Dr"),"deep_learning",14000,15,"Learning_improvemnt_committee"));
	this.permanentecturer.add(new lecturer("Liam", 120478963,degreeType.valueOf("BA"),"Software_development",21000,6,"exceptional"));
	this.permanentecturer.add(new lecturer("David", 204789651,degreeType.valueOf("Pr"),"Computer_security",12000,8,"teaching_committe"));
	this.permanentecturer.add(new lecturer("Sophia", 325468791,degreeType.valueOf("BA"),"Design",12000,10,"exceptional"));
	this.permanentecturer.add(new lecturer("Aya", 325228791,degreeType.valueOf("BA"),"Design",12000,10,"exceptional"));
	this.permanentecturer.add(new lecturer("Jack", 355468791,degreeType.valueOf("BA"),"Linux",15000,19,"exceptional"));
	this.permanentecturer.add(new lecturer("Mike", 155468791,degreeType.valueOf("MA"),"IA",5000,2,"exceptional"));
	this.permanentecturer.add(new lecturer("Sima", 327668791,degreeType.valueOf("BA"),"C",12000,10,"exceptional"));
	this.outsiderLecturer.add(new lecturer("Emma",512436759, degreeType.valueOf("Dr"), "Web_development",600));
	this.outsiderLecturer.add(new lecturer("Rachel",111168975, degreeType.valueOf("MA"), "Computer_security",600));
	this.outsiderLecturer.add(new lecturer("Mia",201456785, degreeType.valueOf("BA"), "Web_development",600));
	this.outsiderLecturer.add(new lecturer("Lucas",564782145, degreeType.valueOf("Pr"), "python",700));
	this.outsiderLecturer.add(new lecturer("Monica",391546789, degreeType.valueOf("MA"), "Java",400));
	this.outsiderLecturer.add(new lecturer("kuku",765446789, degreeType.valueOf("MA"), "C#",450));
	this.outsiderLecturer.add(new lecturer("Will",671546789, degreeType.valueOf("MA"), "JavaScript",600));
	
	ArrayList<lecturer> a = new ArrayList<lecturer>();
	a.add(this.permanentecturer.get(0));a.add(this.permanentecturer.get(1));a.add(this.outsiderLecturer.get(0));a.add(this.outsiderLecturer.get(1));
	this.college.add(new College("Afeka",a));

	a = new ArrayList<lecturer>();
	a.add(this.permanentecturer.get(2));a.add(this.permanentecturer.get(3));
	this.college.add(new College("yaffo-telaviv",a));

	a = new ArrayList<lecturer>();
	a.add(this.permanentecturer.get(4));a.add(this.outsiderLecturer.get(2));
	this.college.add(new College("ort-braude",a));

	a = new ArrayList<lecturer>();
	a.add(this.outsiderLecturer.get(3));a.add(this.permanentecturer.get(5));
	this.college.add(new College("Bosses", a));

	a = new ArrayList<lecturer>();
	a.add(this.outsiderLecturer.get(4));a.add(this.outsiderLecturer.get(5));a.add(this.permanentecturer.get(6));a.add(this.permanentecturer.get(7));
	this.college.add(new College("Champions", a));

	a = new ArrayList<lecturer>();
	a.add(this.permanentecturer.get(8));a.add(this.permanentecturer.get(9));
	this.college.add(new College("Force",a));
	this.Union.add(new Association(permanentecturer.get(0), permanentecturer));
	this.Union.add(new Association(outsiderLecturer.get(0), outsiderLecturer));
	
	 try{
         FileOutputStream writeData = new FileOutputStream("lecturersData.ser");
         ObjectOutputStream writeStream = new ObjectOutputStream(writeData);

         writeStream.writeObject(Union);
         writeStream.flush();
         writeStream.close();

     }catch (IOException e) {
         e.printStackTrace();
     }

     try{
         FileInputStream readData = new FileInputStream("lecturersData.ser");
         ObjectInputStream readStream = new ObjectInputStream(readData);

         ArrayList Association = (ArrayList<Association>) readStream.readObject();
         readStream.close();

         System.out.println(Association.toString());
     }catch (IOException | ClassNotFoundException e) {
         e.printStackTrace();
     }
 }

	
			
			

}
