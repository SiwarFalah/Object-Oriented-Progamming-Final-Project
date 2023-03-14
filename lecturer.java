package Model;

import java.util.Comparator;

public class lecturer {
private String name;
private int id;
public enum degreeType {BA, MA, Dr,Pr};
private degreeType type;

public String specialization;
public String committe;
public int salary;


public lecturer(String name,int id, degreeType type, String specialization, int SalaryPerDay) {
	setName(name);
	setId(id);
	setType(type);
	setSpecialization(specialization);
	setSalaryPerHour(SalaryPerDay);

}

public lecturer(String name, int id, degreeType type, String specialization, int salaryPerMonth, int numOfYears,String committe) {
	setName(name);
	setId(id);
	setType(type);
	setSpecialization(specialization);
	setSalaryPerMonth(salaryPerMonth,numOfYears);
	
}
public String getName() {
	return name;
}

public void setName(String name) {
	this.name = name;
}

public int getId() {
	return id;
}

public void setId(int id) {
	this.id = id;
}

public degreeType getType() {
	return type;
}

public void setType(degreeType type) {
	this.type = type;
}

public String getSpecialization() {
	return specialization;
}

public void setSpecialization(String specialization) {
	this.specialization = specialization;
}

public void setSalaryPerHour(int SalaryPerDay) {
	this.salary = SalaryPerDay;
}

public void setSalaryPerMonth(int salaryPerMonth, int numOfYears) {
	if(numOfYears > 3)
		this.salary=(int) (salaryPerMonth*1.20);
	else 
		this.salary=salaryPerMonth;
	
}
public static Comparator<lecturer> getCompByName()
{   
 Comparator<lecturer> comp = new Comparator<lecturer>(){
     @Override
     public int compare(lecturer a1, lecturer a2)
     {
         return a1.name.compareTo(a2.name);
     }        
 };
 return comp;
}  
public static Comparator<lecturer> getCompByID()
{   
 Comparator<lecturer> comp = new Comparator<lecturer>(){
     @Override
     public int compare(lecturer a1, lecturer a2)
     {
         return a1.id>a2.id?1:-1;
     }        
 };
 return comp;
}  

public String print() {
	return "lecturer [name=" + name + ", id=" + id + ", type=" + type + ", specialization=" + specialization+ " ]" ;
}













}