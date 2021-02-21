# Course_Registration_System

This project creates a usable course registration system for a given university. The program has two interfaces: one for the Administrator and one for students. For the administrator, after entering the correct username and passcode, the administrator can perform the following actions:
  1. Course Management:
      1. Create a new course
      2. Delete a course
      3. Edit a course
      4. Display information for a given course (by course ID)
      5. Register a student
      6. Exit
  2. Report:
      1. View all courses
      2. View all courses that are FULL
      3. Write to a file the list of course that are full
      4. View the names of the students that are registered in a specific course
      5. View the list of courses that a given student is registered in
      6. Sort the courses based on the current number of students registered
      7. Exit
   
For the student interface, after entering a matching username and passcode, the user is able to perform the following actions:

      1. View All Courses
      2. View all courses that are not full
      3. Register in a course
      4. Withdraw from a course
      5. View all courses that the current student is registered in
      6. Exit

After completing all desired actions, the program ends with two serialized files: the course information file and the student information file, and next time the program runs, it reads from the new serialized files.

