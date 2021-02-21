
import java.util.ArrayList;
import java.util.Scanner;

public class Student extends User implements Student_Interface{
	//Student ID
	private String ID;
	
	//the index of this student in the ArrayList student_object
	private int index;
	
	//arraylist of  all student objects
	public static ArrayList<Student> student_object=new ArrayList<Student>();

	transient Scanner scanner=new Scanner(System.in);
	
	//default constructor
	public Student() {
		}
	
	//getter
	public String getID() {
		return ID;
	}
	
	//student object constructor
	public Student(String user, String last, String first, String id, String pass) {
		super.setusername(user);
		super.setlast_name(last);
		super.setfirst_name(first);
		ID=id;
		super.setpassword(pass);
	}
	
	//display student menu
	public void student_menu(int a) {
		index=a;
		System.out.println("1.View All Courses"+'\n'+"2.View all courses that are not full"+'\n'+"3.Register in a course"+'\n'+
				"4. Withdraw from a course"+'\n'+"5.View all courses that the current student is registered in"+'\n'+"6.Exit");
			System.out.println("Select the number of the action you want to perform");
			String action=scanner.nextLine();
			if (action.equals("1"))
				super.view_course(Courseinfo.courseinfo);
				if (action.equals("2"))
					notfull();
					if (action.equals("3"))
						register();
						if (action.equals("4"))
							withdraw();
							if (action.equals("5"))
								this.view_course();
								if (action.equals("6"))
									System.exit(0);
				}
		
	
	//display the courses that are not full
	public void notfull() {
		full();
		view_course(User.notfull);
		}
	
	
	//register into a course
	public void register() {
		System.out.println("Register: Enter the information in the following format: course name,section  separated by commas");
		String reg=scanner.nextLine();
		String[] regs=reg.split(",");
		
		
		for(int i=0; i<Courseinfo.courseinfo.size(); i++) {
			if(regs[0].equals(Courseinfo.courseinfo.get(i).getcourse_name()) && regs[1].equals(Courseinfo.courseinfo.get(i).getcourse_section())) {
				Courseinfo.courseinfo.get(i).add_list(Student.student_object.get(index));
			    Courseinfo.courseinfo.get(i).current_num();
			    			  
			}
		}
		}
	
	
	//withdraw from a course
	public void withdraw() {
		System.out.println("Withdraw: Enter the information in the following format: course name,section  separated by commas");
		String reg=scanner.nextLine();
		String[] regs=reg.split(",");
		
		for(int i=0; i<Courseinfo.courseinfo.size(); i++) {
			if(regs[0].equals(Courseinfo.courseinfo.get(i).getcourse_name()) && regs[1].equals(Courseinfo.courseinfo.get(i).getcourse_section())) {
				System.out.println(Student.student_object.get(index).getfirst_name());
				Courseinfo.courseinfo.get(i).delete_list(index);
				Courseinfo.courseinfo.get(i).current_num();
			}
		}
	}
	
	
	//view all the course this student registered in
	public void view_course() {
		int iden=0;
		System.out.println("View Courses:");
		for(int i=0; i<Courseinfo.courseinfo.size(); i++){
			for(int j=0; j<Courseinfo.courseinfo.get(i).getlist().size(); j++) {	
					if(Courseinfo.courseinfo.get(i).getlist().get(j).getfirst_name().equals(Student.student_object.get(index).getfirst_name())&& Courseinfo.courseinfo.get(i).getlist().get(j).getlast_name().equals(Student.student_object.get(index).getlast_name())&&Courseinfo.courseinfo.get(i).getlist().get(j).getID().equals(Student.student_object.get(index).getID())) {
					System.out.println("Course name: "+Courseinfo.courseinfo.get(i).getcourse_name()+" | Course ID: "+Courseinfo.courseinfo.get(i).getcourse_id()
							+" | Course Section: "+Courseinfo.courseinfo.get(i).getcourse_section()+" | Course Instructor: "+Courseinfo.courseinfo.get(i).getcourse_instructor()+
							" | Course Location: "+Courseinfo.courseinfo.get(i).getcourse_location());
					System.out.println();
					iden=1;
					}
			}
		}
		if(iden==0) {
			System.out.println("No course registered.");
			System.out.println();
		}
		}
	

}
	



