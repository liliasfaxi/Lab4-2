package tn.medtech.lab4_2;

/**
 * Created by lilia on 28/04/2017.
 */

public class Student {



    private int id;
    private String name;
    private String surname;
    private int grade;

    Student(){}

    Student(String name, String surname,int grade){
        this.name = name;
        this.surname = surname;
        this.grade = grade;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public int getGrade() {
        return grade;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    @Override
    public String toString() {
        return "Name: "+name+ " "+surname+"("+grade+")";
    }
}
