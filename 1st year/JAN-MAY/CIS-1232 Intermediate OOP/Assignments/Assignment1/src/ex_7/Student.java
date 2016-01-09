/*
 *  *** CIS-1232 Intermediate OOP ***
 * 
 * NAME: Christopher Sigouin
 * DATE: 18-Jan-2015
 * PROJECT NAME: Assignment 1
 * DEPENDENCIES: CollegeCourse.java, InputGrades.java
 *
 */

package ex_7;

/**
 *
 *  STUDENT CLASS
 *
 * @author Christopher Sigouin
 * @since 18-Jan-2015
 */
public class Student {
    
    public final static int MAX_NUMBER_OF_COURSES = 5; // 5
    private int idNumber;
    private CollegeCourse[] collegeCourses = new CollegeCourse[MAX_NUMBER_OF_COURSES]; // Object Array - CollegeCourse
    private static int numberOfStudentsEntered;
    
    public Student() {
        ++numberOfStudentsEntered; // Everytime an instance is created, increment the static value
    }
    
    @Override
    public String toString() {
        String courseOutput = "";
        for( CollegeCourse courseInfo : collegeCourses ) {
            courseOutput += courseInfo.toString();
        }
        
        return "STUDENT ID NUMBER: " + idNumber + System.lineSeparator() +
               courseOutput;
    }

    public int getIdNumber() {
        return idNumber;
    }

    public void setIdNumber(int idNumber) {
        this.idNumber = idNumber;
    }

    public CollegeCourse getCollegeCourses(int coursePosition) {
        return collegeCourses[coursePosition];
    }

    public void setCollegeCourses(CollegeCourse collegeCourses, int coursePosition) {
        this.collegeCourses[coursePosition] = collegeCourses;
    }

    public static int getNumberOfStudentsEntered() {
        return numberOfStudentsEntered;
    }

    
}
