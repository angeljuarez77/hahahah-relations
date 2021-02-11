package com.example.server.model;

import javax.persistence.*;

@Entity
@Table(name = "students_gpa")
public class Gpa {
    @Id
    @GeneratedValue
    @Column
    private Long id;

    @Column
    private Double gpa;

    @OneToOne(mappedBy = "gradePointAverage", cascade = {
            CascadeType.ALL
    })
    private Student student;

    public Gpa() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getGpa() {
        return gpa;
    }

    public void setGpa(Double gpa) {
        this.gpa = gpa;
    }
}
