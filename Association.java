package Model;

import java.util.ArrayList;


public class Association {
	
	private lecturer chairman;
	private ArrayList<lecturer> l = new ArrayList<lecturer>();
	
	public Association(lecturer chairman , ArrayList<lecturer> l) {
		this.setChairman(chairman);
		this.l =l;
	}

	public String print() {
		String str = "";
		str+=l.size() + " Lecturers:\n";
		for(lecturer a : l) {
			str+= a.print()+"\n";
		}
		return  "Chairman : "+ chairman.print() + "\n" + str ;
	}

	public ArrayList<lecturer> getLecturer() {
		return l;
	}
	public void setLecturer(ArrayList<lecturer> l) {
		this.l = l;
	}
	public lecturer getChairman() {
		return chairman;
	}

	public void setChairman(lecturer chairman) {
		this.chairman = chairman;
	}
	 
	public int getSize() {
		return l.size();
	}
	
}
