import java.io.Serializable;
import java.util.ArrayList;

public class User extends User_Abstract implements Serializable {
	//User variables
	private String username;
	private String password;
	private String first_name;
	private String last_name;
	
	//arraylist of the courses that are full
	public static ArrayList<Courses> coursefull =new ArrayList<Courses>();
	
	//arraylist of the courses that are not full
	public static ArrayList<Courses> notfull =new ArrayList<Courses>();
	
	//default constructor
	public User() {
		
	}
	
	//getters and setters 
	
	public String getusername() {
		return username;	
	}
	
	public String getpassword() {
		return password;	
	}
	
	public String getfirst_name() {
		return first_name;
	}
	
	public String getlast_name() {
		return last_name;	
	}
	
	public void setusername(String a) {
		username=a;	
	}
	
	public void setpassword(String a) {
		password=a;	
	}
	
	public void setfirst_name(String a) {
		first_name=a;	
	}
	
	public void setlast_name(String a) {
		last_name=a;	
	}
	
	
//view course information for an arraylist of Courses objects
	public void view_course(ArrayList<Courses> course) {
		for(int i=0; i<course.size();i++) {
			System.out.println(course.get(i).getcourse_name()+" "+
		course.get(i).getcourse_id()+" "+
		course.get(i).getcourse_instructor()+" "+
		course.get(i).getcourse_section());
		}
	}
	
//find which courses are full, which courses are not 	
	public void full() {
		for(int i=0; i<Courseinfo.courseinfo.size();i++) {
			if(Courseinfo.courseinfo.get(i).getcourse_current_num().equals(Courseinfo.courseinfo.get(i).getcourse_max())) {
				if(!coursefull.contains(Courseinfo.courseinfo.get(i)))
					coursefull.add(Courseinfo.courseinfo.get(i));
					}
				else if(!notfull.contains(Courseinfo.courseinfo.get(i)))
				notfull.add(Courseinfo.courseinfo.get(i));	
			}
		}
	
//locate index of the desired course in the courseinfo ArrayList
	public int findcourse(String name1, String id1, String section1) {
			int i=0;
			while (i<Courseinfo.courseinfo.size()) {
			if(Courseinfo.courseinfo.get(i).getcourse_name().equals(name1)&&
				Courseinfo.courseinfo.get(i).getcourse_id().equals(id1)&&
					Courseinfo.courseinfo.get(i).getcourse_section().equals(section1))
				return i+1;
			i++;
				}
			return 0;
		}
	
	

}
