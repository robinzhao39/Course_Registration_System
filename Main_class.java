import java.util.ArrayList;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Scanner;

public class Main_class  {
	public static void main(String[] args) {
		
		File file1 = new File("Courseinfo.ser");
		File file2 = new File("Student.ser");  
		
		
		//De-serialize file if exists
		
		if (file1.exists()&&file2.exists()) {
			 try{

			      FileInputStream fis = new FileInputStream("Courseinfo.ser");
			    ObjectInputStream ois = new ObjectInputStream(fis);
			      
			     FileInputStream fis1 = new FileInputStream("Student.ser");
			     ObjectInputStream ois1 = new ObjectInputStream(fis1);
	
			     Courseinfo.courseinfo = (ArrayList) ois.readObject();
			     Student.student_object=(ArrayList) ois1.readObject();
			      ois.close();
			      fis.close();
			      ois1.close();
			     fis1.close();
			      
			    }
			    catch(IOException ioe) {
			       ioe.printStackTrace();
			    
			    }
			 catch(ClassNotFoundException cnfe) {
			       cnfe.printStackTrace();
			     		    }
			
		}
		
		
		else {
		String filename="MyUniversityCourses.csv";
		Courseinfo x= new Courseinfo();
		x.storeinfo(filename);
		}
		
		
		
		Scanner sc=new Scanner(System.in);
		
		Admin begin=new Admin();
		Student news=new Student();
		
		//Determine Student or Administrator, and display the according menu if the user name and password are correct.
		
		System.out.println("Are you a student or an administrator? Enter 1 for student, 2 for administrator");
		String userinput =sc.nextLine();
		if(userinput.equals("1")) {
			System.out.println("Username:");
			String student_username=sc.nextLine();	
			System.out.println("Password:");
			String student_password=sc.nextLine();
			for(int i=0; i<Student.student_object.size();i++) {
				
				if(Student.student_object.get(i).getusername().equals(student_username)&&Student.student_object.get(i).getpassword().equals(student_password)) {
					System.out.println("Welcome Student:");
					news.student_menu(i);
					System.out.println("Do you want to perform another action? Enter 1 for yes, anything else to exit");
					String response=sc.nextLine();
					while(response.equals("1")) {
							news.student_menu(i);
							System.out.println("Do you want to perform another action? Enter 1 for yes, anything else to exit");
							response=sc.nextLine();
					}
									
				}
				else {
					System.out.println("Wrong Username or Password");
					}
				}
			
		}
		
		if(userinput.equals("2")) {
			System.out.println("Username:");
			String admin_username=sc.nextLine();
			System.out.println("Password:");
			String admin_password=sc.nextLine();
			if (admin_username.equals("Admin")&& admin_password.equals("Admin001")) {
				System.out.println("Welcome, Administrator");
				begin.Admin_menu();
				System.out.println("Do you want to perform another action? Enter 1 for yes, anything else to exit");
				String response=sc.nextLine();
				while (response.equals("1")) {
						begin.Admin_menu();
						System.out.println("Do you want to perform another action? Enter 1 for yes, anything else to exit");
						response=sc.nextLine();
			}
			}
			else {
				System.out.println("Wrong Username or Password");
			}
			
		}
		
		
		//Serialize Courseinfo.courseinfo and Student.student_object
		try {
			FileOutputStream fos = new FileOutputStream("Courseinfo.ser");
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			
			
			oos.writeObject(Courseinfo.courseinfo);
			
			oos.close();
			fos.close();
			
			System.out.print("Serialization ");
		} 
		catch (IOException ioe) {
			ioe.printStackTrace();
		}
		
		try {
		
		FileOutputStream fos1 = new FileOutputStream("Student.ser");
		ObjectOutputStream oos1 = new ObjectOutputStream(fos1);
		oos1.writeObject(Student.student_object);
		oos1.close();
		fos1.close();
		System.out.print("Complete");
		}
		catch (IOException ioe) {
			ioe.printStackTrace();
		}
		
	
	}
}


