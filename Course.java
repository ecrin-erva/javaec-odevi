
package odev;

import java.util.ArrayList;

public class Course {
    private String courseName;
    private ArrayList<String> students;
    private int numberOfStudents;

    public Course(String courseName) {
        this.courseName = courseName;
        students = new ArrayList<>();
        numberOfStudents = 0;
    }

    public void addStudent(String student) {
        students.add(student);
        numberOfStudents++;
    }

    public String[] getStudents() {
        String[] result = new String[numberOfStudents];

        for (int i = 0; i < numberOfStudents; i++) {
            result[i] = students.get(i);
        }

        return result;
    }

    public int getNumberOfStudents() {
        return numberOfStudents;
    }

    public String getCourseName() {
        return courseName;
    }

    public void dropStudent(String student) {
        if (students.remove(student)) {
            numberOfStudents--;
        }
    }
}
