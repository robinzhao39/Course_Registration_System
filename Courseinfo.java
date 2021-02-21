import java.io.*;
import java.util.ArrayList;

public class Courseinfo {
	//default constructor
	public Courseinfo() {
	
	}
	
	//arraylist of all course information
	public static ArrayList<Courses> courseinfo =new ArrayList<Courses>();
	
	//reads from a file and stores information to the arraylist above
	public void storeinfo(String a) {
		String emptyrow;
		String row;
		String[] data;

		try {
			FileReader filereader=new FileReader(a);
			BufferedReader bufferedReader=new BufferedReader(filereader);
			emptyrow=bufferedReader.readLine();
	
		
			int i=0;
			while((row=bufferedReader.readLine())!=null) {
				data=row.split(",");				
				courseinfo.add(new Courses());
				courseinfo.get(i).setcourse_name(data[0]);
				courseinfo.get(i).setcourse_id(data[1]);
				courseinfo.get(i).setcourse_max(data[2]);
				courseinfo.get(i).setcourse_current_num(data[3]);
				courseinfo.get(i).setcourse_instructor(data[5]);
				courseinfo.get(i).setcourse_section(data[6]);
			courseinfo.get(i).setcourse_location(data[7]);
			i++;
			}
	
			bufferedReader.close();
		}

			catch(FileNotFoundException ex){
				System.out.println( "Unable to open file '" + a + "'");
			}
		
			catch (IOException ex) {
				System.out.println( "Error reading file '" + a + "'");
				ex.printStackTrace();
			}

		}
}