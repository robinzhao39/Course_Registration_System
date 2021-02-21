import java.util.ArrayList;
import java.io.Serializable;

public class Courses implements Serializable,Comparable<Courses>{
	//Course Object Variables
	private String course_name;
	private String course_id;
	private String course_max;
	private String course_current_num;
	private ArrayList<Student> list= new ArrayList<Student>();
	private String course_instructor;
	private String course_section;
	private String course_location;
	
	//Default constructor
	public Courses() {
		
	}
	
	//finds the current number of student
	public void current_num() {
		course_current_num=Integer.toString(list.size());
		}
	
	//Overriding compareTo method
	public int compareTo(Courses a) {
		if(Integer.parseInt(this.course_current_num)>Integer.parseInt(a.course_current_num)) 
			return 1;
		
		else if(Integer.parseInt(this.course_current_num)<Integer.parseInt(a.course_current_num)) 
				return -1;
		else
			return 0;		
	}
	
	//Constructor for the Object
	public Courses(String x1, String x2, String x3, String x4, String x5, String x6) {
		course_name=x1;
		course_id=x2;
		course_max=x3;
		course_current_num="0";
		list.clear();
		course_instructor=x4;
		course_section=x5;
		course_location=x6;
		
	}
	
	//getters and setters
	
	
	public String getcourse_name() {
		return course_name;
	}
	
	
	public String getcourse_id() {
		return course_id;
	}
	
	public ArrayList<Student> getlist() {
		return list;
	}
	
	public String getcourse_max() {
		return course_max;
	}
	
	
	public String getcourse_current_num() {
		return course_current_num;
	}
	
	public String getcourse_instructor() {
		return course_instructor;
	}
	
	public String getcourse_section() {
		return course_section;
	}
	
	public String getcourse_location() {
		return course_location;
	}
	
	
	public void setcourse_name(String a) {
		course_name=a;
	}
	
	public void setcourse_id(String a) {
		course_id=a;
	}
	
	public void setcourse_max(String a) {
		course_max=a;
	}
	
	public void add_list(Student a) {
		list.add(a);
	}
	
	public void delete_list(int index) {
			list.remove(index);
		}
	
	public void setcourse_current_num(String a) {
		course_current_num=a;
	}
	
	public void setcourse_instructor(String a) {
		course_instructor=a;
	}
	public void setcourse_section(String a) {
		course_section=a;
	}
	public void setcourse_location(String a) {
		course_location=a;
	}
	
	
	

}
