/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.abed.springbootapp;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Entity
@Table(name = "student")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;
    private String major;
    private Double grade;

    public Student() {}

    public Student(Integer id, String name, String major, Double grade) {
        
        this.id = id;
        this.name = name;
        this.major = major;
        this.grade = grade;
    }

    // getters & setters
    public Integer getId() { 
        
        return id; 
    }
    public void setId(Integer id) {
        
        this.id = id; 
    }
    public String getName() {
        
        return name; 
    }
    public void setName(String name) {
        
        this.name = name; 
    }
    public String getMajor() {
        
        return major; 
    }
    public void setMajor(String major) {
        
        this.major = major; 
    }
    public Double getGrade() {
        
        return grade;
    }
    public void setGrade(Double grade) {
        
        this.grade = grade; 
    }

    @Override
    public String toString() {
        return "Student{" + "id=" + id + ", name=" + name + ", major=" + major + ", grade=" + grade + '}';
    }
   
}


