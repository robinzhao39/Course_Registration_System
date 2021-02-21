import java.util.ArrayList;
import java.io.*;
import java.util.Scanner;
import java.util.Collections;

//class for Administrator
public class Admin extends User implements Admin_Interface{
	Scanner scan=new Scanner(System.in);
	
	//default constructor
	public Admin() {
		}
	
	//Display all full courses
	public void coursefull() {
		super.full();
		if(coursefull.size()!=0)
		super.view_course(User.coursefull);
		else
			System.out.println("No course is full");
	}
	
	
	//Administrator Menu
	public void Admin_menu() {
		System.out.println("1. Course Management");
		System.out.println("2. Reports");
		System.out.println("Enter 1 or 2:");
		String answer=scan.nextLine();
		if(answer.equals("1")) {
			System.out.println("1.Create a new course"+'\n'+"2.Delete a course"+'\n'+"3.Edit a course"+'\n'+
				"4.Display information for a given course (by course ID)"+'\n'+"5.Register a student"+'\n'+"6.Exit");
			System.out.println("Select the number of the action you want to perform");
			String action=scan.nextLine();
			if (action.equals("1"))
				create_course();
				if (action.equals("2"))
					delete_course();
					if (action.equals("3"))
						edit_course();
						if (action.equals("4"))
							display_info();
							if (action.equals("5"))
								register_student();
								if (action.equals("6")) {
									
								}
		}
		
			if(answer.equals("2")) {
				System.out.println("1. View all courses"+'\n'+"2. View all courses that are FULL"+'\n'+
						"3. Write to a file the list of course that are full"+'\n'+
						"4. View the names of the students that are registered in a specific course"+'\n'+
						"5. View the list of courses that a given student is registered in"+'\n'+
						"6. Sort the courses based on the current number of students registered"+'\n'+
						"7. Exit");
				System.out.println("Select the number of the action you want to perform");
				String action=scan.nextLine();
				if (action.equals("1"))
					this.view_course(Courseinfo.courseinfo);
					if (action.equals("2"))
						coursefull();
						if (action.equals("3"))
							write_to_file();
							if (action.equals("4"))
								students_in_course();
								if (action.equals("5"))
									course_of_student();
									if (action.equals("6"))
										Collections.sort(Courseinfo.courseinfo);
										if (action.equals("7")) {
											
										}
											
				}
			
			
			
		
	}
	
	//view all courses in a given ArrayList
	public void view_course(ArrayList<Courses> course) {
		
		for(int i=0; i<course.size();i++) {
			System.out.println("Course name: "+course.get(i).getcourse_name()+" | Course ID: "+
					course.get(i).getcourse_id()+" | Course Section: "+
					course.get(i).getcourse_section()+" | Course Maximum Students: "+
					course.get(i).getcourse_max()+" | Course Current Number of Students: "+course.get(i).getcourse_current_num());
				if(course.get(i).getlist().size()==0) {
					System.out.print(" No student registered"+'\n');
					System.out.println();
					
				}
				else {
					for(int j=0;j<course.get(i).getlist().size(); j++) {	
						System.out.println("Student Name:"+course.get(i).getlist().get(j).getfirst_name()+" "+course.get(i).getlist().get(j).getlast_name()+"  ID: "+
								course.get(i).getlist().get(j).getID());
				} 
				}
			}	
	}
	
	//Create course
	public void create_course() {
		System.out.println("Enter course name:");
		String name=scan.nextLine();
		System.out.println("Enter course ID:");
		String id=scan.nextLine();
		System.out.println("Enter maximum students:");
		String max=scan.nextLine();
		System.out.println("Enter course instructor:");
		String instructor=scan.nextLine();
		System.out.println("Enter course section number:");
		String section=scan.nextLine();
		System.out.println("Enter course locaton:");
		String location=scan.nextLine();
		
		Courses newcourse=new Courses(name,id,max,instructor,section,location);
		Courseinfo.courseinfo.add(newcourse);	
		}
	
	//Delete Course	
	public void delete_course() {
		System.out.println("Enter the NAME, ID, SECTION of the course, separated by commas: ");
		String deletecourse=scan.nextLine();
		String[] delete=deletecourse.split(",");
	
		int de=super.findcourse(delete[0], delete[1], delete[2]);
		if(de!=0) {
			Courseinfo.courseinfo.remove(de-1);
			}
		else {
			System.out.println("The course you entered does not exist. Enter 1 to re_enter, anything else to exit: ");
			String answer=scan.nextLine();
			if(answer.equals("1")) {
				delete_course();
			}
			else
				System.exit(0); 
			}
		}
	
	//Edit course information, including course, number of current student, student list by adding or deleting student,course instructor and course location
	public void edit_course() {
		System.out.println("Enter the NAME, ID, SECTION of the course, separated by commas: ");
		String course_edit=scan.nextLine();
		String[] course_edits=course_edit.split(",");
		int in=super.findcourse(course_edits[0], course_edits[1], course_edits[2]);
		int index=in-1;
	
		
		if (in>=0) {
				System.out.println("1. Maximum Students");
				System.out.println("2. Number of Current Students");
				System.out.println("3. List of Student Names");
				System.out.println("4. Course Instructor");
				System.out.println("5. Course Location");
				System.out.println("Select the information you want to edit, enter the corresponding number:");
		
				String edit=scan.nextLine();
					if (edit.equals("1")) {
						System.out.println("Change Maximum Students To:(Enter a number) ");
						Courseinfo.courseinfo.get(index).setcourse_max(scan.nextLine());
					}
				
					if (edit.equals("2")) {
						System.out.println("Change Number of Current Students To: (Enter a number) ");
						Courseinfo.courseinfo.get(index).setcourse_current_num(scan.nextLine());
					}
			
					if (edit.equals("3")) {
						System.out.println("Change List of Student names: ");
						System.out.println("Add student or Delete student? Enter 1 for add, anything else for delete: ");
						String response=scan.nextLine();
						if(response.equals("1")) {
							System.out.println("Enter a student name in the following format: firstname,lastname ");
							String reg=scan.nextLine();
							String[] regs=reg.split(",");
							for(int v=0; v<Student.student_object.size();v++) {
								if(regs[0].equals(Student.student_object.get(v).getfirst_name())&&regs[1].equals(Student.student_object.get(v).getlast_name())) {
									 Courseinfo.courseinfo.get(index).add_list(Student.student_object.get(v));
								  	Courseinfo.courseinfo.get(index).current_num();
								}
							}
						}
				
						else {
							System.out.println("Enter a student name in the following format: firstname,lastname ");
							String reg=scan.nextLine();
							String[] regs=(reg.split(","));
							for(int v=0; v<Student.student_object.size();v++) {
								if(regs[0].equals(Student.student_object.get(v).getfirst_name())&&regs[1].equals(Student.student_object.get(v).getlast_name()))
									Courseinfo.courseinfo.get(index).delete_list(v);
								Courseinfo.courseinfo.get(index).current_num();
								
								}
							
							}
						}
					
			
					
				if (edit.equals("4")) {
					System.out.println("Change Course Instructor To: ");
					Courseinfo.courseinfo.get(index).setcourse_instructor(scan.nextLine());
				}
			
			
				if (edit.equals("5")) {
					System.out.println("Change Course Location To: ");
					Courseinfo.courseinfo.get(index).setcourse_location(scan.nextLine());
				}
		}

		
	
		
		else {
			System.out.println("The course you entered does not exist. Enter 1 to re_enter, anything else to exit: ");
			String answer=scan.nextLine();
			if(answer.equals("1")) {
				edit_course();
			}
			else
				System.exit(0); 
			}
		
		}
	
	//Display information, including a list of students, for a given course
	public void display_info() {
		System.out.println("What is the ID of the course that you want to be displayed: ");
		String idname=scan.nextLine();
		int iden=0;
		for (int i=0; i<Courseinfo.courseinfo.size(); i++) {
			if(idname.equals(Courseinfo.courseinfo.get(i).getcourse_id())) {
				System.out.print("Course Name: "+Courseinfo.courseinfo.get(i).getcourse_name()+" | Course ID:"+Courseinfo.courseinfo.get(i).getcourse_id()+" | Course Maximum Students:"+Courseinfo.courseinfo.get(i).getcourse_max());
				System.out.println(" | Course Current Number of Students: "+Courseinfo.courseinfo.get(i).getcourse_current_num());
				System.out.println(" Course Students: ");
				if(Courseinfo.courseinfo.get(i).getlist().size()==0)
					System.out.println("No Students");
				else {
						for (int e=0; e<Courseinfo.courseinfo.get(i).getlist().size(); e++) {
							System.out.println(Courseinfo.courseinfo.get(i).getlist().get(e).getfirst_name()+" "+Courseinfo.courseinfo.get(i).getlist().get(e).getlast_name());
						}
				}
				System.out.println("Course instructor: "+Courseinfo.courseinfo.get(i).getcourse_instructor()+" | Course Section "+Courseinfo.courseinfo.get(i).getcourse_section());
				iden=1;
				System.out.println();
				}

			}
			if(iden==0) {
				System.out.println("The course you entered does not exist. Enter 1 to re_enter, anything else to return to Administrator menu: ");
				String answer=scan.nextLine();
				if(answer.equals("1")) {
					display_info();
				}
				else
					this.Admin_menu();

			}	
		}
	
	//register a student into the course system
	public void register_student() {
		System.out.println("Enter the new student's username, lastname, first name, id, password, separated by commas: ");
		String newst=scan.nextLine();
		String[] newsts= newst.split(",");
		Student newstudent=new Student(newsts[0],newsts[1], newsts[2],newsts[3],newsts[4]);
	    Student.student_object.add(newstudent);
		}

	
	//write all full courses to a file
	public void write_to_file() {
		String file_name="fullcourses.txt";
		super.full();
		if(coursefull.size()!=0) {
		
		try{
			FileWriter fileWriter = new FileWriter(file_name);
			BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
			
			for(int i=0; i<coursefull.size();i++) {
			bufferedWriter.write(coursefull.get(i).getcourse_name()+" "+coursefull.get(i).getcourse_id()+" "+coursefull.get(i).getcourse_section());
			bufferedWriter.newLine();
			}
			bufferedWriter.close();
		}
			

		//Always close files

		catch (IOException error) {
			System.out.println( "Error writing file '" + file_name + "'");
			error.printStackTrace();
		}
	
		
		}
		else
			System.out.println("No course is full");
	}
	
	//display students registered in a given course
	public void students_in_course() {
		System.out.println("Enter the NAME, ID, SECTION of the course, separated by commas: ");
		String studentin=scan.nextLine();
		String[] stu=studentin.split(",");
		
		int ind=super.findcourse(stu[0], stu[1], stu[2]);
		int index=ind-1;
		System.out.println(" Course Students: ");
		
		if(Courseinfo.courseinfo.get(index).getlist().size()==0) {
			System.out.println("No students");
		}
		else {
			for (int e=0; e<Courseinfo.courseinfo.get(index).getlist().size(); e++) {
				System.out.println(Courseinfo.courseinfo.get(index).getlist().get(e).getfirst_name()+" "+Courseinfo.courseinfo.get(index).getlist().get(e).getlast_name());
			}
		}
		
	}
	
//display all courses a given student registered in
	public void course_of_student() {
		int iden=0;
		System.out.println("View Courses for: (Enter first name,last name,id of the student, separated by commas, no spaces ");
		String stu=scan.nextLine();
		String [] stud=stu.split(",");
				
				
		for(int i=0; i<Courseinfo.courseinfo.size(); i++){
			for(int j=0; j<Courseinfo.courseinfo.get(i).getlist().size(); j++) {
					if(Courseinfo.courseinfo.get(i).getlist().get(j).getfirst_name().equals(stud[0])&&Courseinfo.courseinfo.get(i).getlist().get(j).getlast_name().equals(stud[1])&&Courseinfo.courseinfo.get(i).getlist().get(j).getID().equals(stud[2])){
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
