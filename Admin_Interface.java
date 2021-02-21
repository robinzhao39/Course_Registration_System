import java.util.ArrayList;

public interface Admin_Interface {
	//Admin Interface Methods
	public void Admin_menu();
	public void create_course();
	public void delete_course();
	public void edit_course();
	public void display_info();
	public void register_student();
	public void coursefull();
	public void write_to_file();
	public void students_in_course();
	public void course_of_student();
	public void view_course(ArrayList<Courses> course);
	

}
