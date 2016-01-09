/*
 *  *** CIS-1232 Intermediate OOP ***
 * 
 * NAME: Christopher Sigouin
 * DATE: 18-Jan-2015
 * PROJECT NAME: Assignment 1
 * DEPENDENCIES: CollegeCourse.java, Student.java
 *
 */

package ex_7;

import javax.swing.JOptionPane;

/**
 *
 *  INPUT GRADES CLASS ( MAIN )
 * 
 * @author Christopher Sigouin
 * @since 18-Jan-2015
 */
public class InputGrades {

    public final static int MAX_NUMBER_OF_STUDENTS = 2; // 10
    private static Student[] students = new Student[MAX_NUMBER_OF_STUDENTS]; // Object Array - Student
    private static int currentStudent = 0; // For Student Array Subscript
    private static int currentCourse = 0; // For Courses Array Subscript
    
    /**
     * MAIN METHOD
     * @param args
     */
    public static void main(String[] args) {
        
        //Runs until all the students and courses are entered
        getInput();
        
        // Print the students and their corresponding courses
        for(Student allStudents : students) {
            System.out.println(allStudents);
        }
     
    }
    
    public static void getInput() {
        
        do {
 
            getStudentInfo(); // Get the Student Information ( ID )
            getCourseInfo(); // Get the Course Information for the Student
     
        } while( Student.getNumberOfStudentsEntered() < MAX_NUMBER_OF_STUDENTS );
 
    }
    
    public static void getStudentInfo() {

        // ***** Create the new student
        Student newStudent = new Student();
        //Ask for input
        newStudent.setIdNumber(Integer.parseInt(JOptionPane.showInputDialog("Enter ID for student " + Student.getNumberOfStudentsEntered() + ":")));
        //Store the student in the array
        students[currentStudent] = newStudent;

    }
    
    public static void getCourseInfo() {
        boolean getCourses = true; // Loop Control

        do {
            // *** Create a College Course Object
            CollegeCourse newCourse;newCourse = new CollegeCourse();
            // Ask for input
            newCourse.setCourseId(Integer.parseInt(JOptionPane.showInputDialog(
                    "(Student #" + Student.getNumberOfStudentsEntered() + ") Enter course ID #" + CollegeCourse.getNumberOfCoursesEntered() + ":")));
            newCourse.setCreditHours(Integer.parseInt(JOptionPane.showInputDialog(
                    "(Student #" + Student.getNumberOfStudentsEntered() + ") Enter course hours #" + CollegeCourse.getNumberOfCoursesEntered() + ":")));
    
            // Loop until valid entry for Letter Grade before entering it into the CollegeCourse object
            isLetterGradeValid(JOptionPane.showInputDialog("(Student #" + Student.getNumberOfStudentsEntered() + ") Enter course letter grade #" + CollegeCourse.getNumberOfCoursesEntered() + ":"), newCourse);

            // Store the course into the students course array
            students[currentStudent].setCollegeCourses(newCourse, currentCourse);

            // Check the count on the number of courses entered
            if( CollegeCourse.getNumberOfCoursesEntered() >= 5) {
                getCourses = false; // Loop stops
                CollegeCourse.setNumberOfCoursesEntered(0); // Reset for next student
                currentCourse = 0; // Reset for next student
                ++currentStudent; // Increment to next student;
            } else {
                ++currentCourse; // Move to the next array element for the course array
            }    

        } while ( getCourses );
 
    }
    
    public static void isLetterGradeValid( String letterGrade, CollegeCourse theCourse ) {
        boolean invalidEntry = true;
        final String[] validLetterGrades = { "A", "B", "C", "D", "F" };
    
        do {

            for(String value : validLetterGrades) {
                if( letterGrade.equalsIgnoreCase(value) ) {
    
                    theCourse.setLetterGrade(value);
                    invalidEntry = false;
                    break; // Stop looping when you find it
                }
            }

            if( invalidEntry == true )
                JOptionPane.showMessageDialog(null, "That's not a valid course Letter Grade. Please re-enter it");
        
        } while ( invalidEntry );
    }

}
