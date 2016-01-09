/*
 *  *** CIS-1232 Intermediate OOP ***
 * 
 * NAME: Christopher Sigouin
 * DATE: 18-Jan-2015
 * PROJECT NAME: Assignment 1
 * DEPENDENCIES: InputGrades.java, Student.java
 *
 */

package ex_7;

/**
 *
 * COLLEGE COURSE CLASS
 * 
 * @author Christopher Sigouin
 * @since 18-Jan-2015
 */
public class CollegeCourse {
    
    private int courseId;
    private int creditHours;
    private String letterGrade;
    private static int numberOfCoursesEntered;

    public CollegeCourse() {
        ++numberOfCoursesEntered; // Increment each time an instance is created
    }
    
    @Override
    public String toString() {
        return "**********************************" + System.lineSeparator() +
               "Course ID: " + courseId + System.lineSeparator() +
               "Credit Hours: " + creditHours + System.lineSeparator() +
               "Letter Grade: " + letterGrade + System.lineSeparator() +
               "**********************************" + System.lineSeparator();
    }
    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    public int getCreditHours() {
        return creditHours;
    }

    public void setCreditHours(int creditHours) {
        this.creditHours = creditHours;
    }

    public String getLetterGrade() {
        return letterGrade;
    }

    public void setLetterGrade(String letterGrade) {
        this.letterGrade = letterGrade;
    }

    public static int getNumberOfCoursesEntered() {
        return numberOfCoursesEntered;
    }

    public static void setNumberOfCoursesEntered(int numberOfCoursesEntered) {
        CollegeCourse.numberOfCoursesEntered = numberOfCoursesEntered;
    }
    
    
    
}
