package Student_Mangment_System;

import java.io.Serializable;

public class Student implements Serializable {
    private static final long serialVersionUID = 1L;

    private String name;
    private int roll_no;
    private String grade;

    public Student(String name, int roll_no, String grade) {
        this.name = name;
        this.roll_no = roll_no;
        this.grade = grade;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getRoll_No() {
        return roll_no;
    }

    public void setRoll_No(int roll_no) {
        this.roll_no = roll_no;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    @Override
    public String toString() {
        return "Student{" + "name='" + name + '\'' + ", rollNumber=" + roll_no + ", grade='" + grade + '\'' + '}';
    }
}
