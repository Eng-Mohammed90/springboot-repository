/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.abed.springbootapp;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author pc
 */
public interface StudentRepository extends JpaRepository<Student, Integer>{
    
}
