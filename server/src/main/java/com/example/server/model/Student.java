package com.example.server.model;

import javax.persistence.*;

@Entity
@Table(name = "school_students")
public class Student {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String firstName;

    @Column
    private String lastName;

    @Column
    private Integer age;

    @Column
    private Integer grade;

    @Column
    private String schoolName;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "students_gpa_id")
    private Gpa gpa;
    // 1.4
    // 1.5
    // 1.6

    // angel is it's own row in Student table
    // 1.0 is it's own row in Gpa table
    // angel -> 1.0
    // donovan -> 1.0

    // Student table
    // id, firstName, lastName, age, grade, schoolName, gpa_id_foreign_key
    // 1, angel, juarez, 17, 12, CSSJ, 200
    // 2, angel, juarez, 17, 12, CSSJ, 300

    // Gpa table
    // id, gpa
    // 200, 1.0
    // 300, 3.5

    // JOINED TABLE
    // we want to join the table when the gpa_id_foreign_key = gpa table id
    // 1, angel, juarez, 17, 12, CSSJ, 1.0
    // 2, angel, juarez, 17, 12, CSSJ, 3.5

    public Student() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Integer getGrade() {
        return grade;
    }

    public void setGrade(Integer grade) {
        this.grade = grade;
    }

    public String getSchoolName() {
        return schoolName;
    }

    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName;
    }

    public Gpa getGpa() {
        return gpa;
    }

    public void setGpa(Gpa gpa) {
        this.gpa = gpa;
    }
}
