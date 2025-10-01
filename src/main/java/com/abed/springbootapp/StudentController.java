/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.abed.springbootapp;

import java.net.URI;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.util.UriComponentsBuilder;




@RestController
public class StudentController {
    @Autowired
    StudentRepository repo;
    
    @RequestMapping("/student")
    public String Index(){
        return String.format("%s", "welcome");
    }
     

    @Autowired
    public StudentController(StudentRepository repo) {
        this.repo = repo;
    }

    // Read all
    @RequestMapping("/showAll")
    public String showAll() {
        List <Student>students = repo.findAll();
        String str = "";
        for(Student s : students) {
            
            str += s + "<br>";
        }
        return String.format("%s",str);
    }

    
        @RequestMapping("/show/{id}")
        public String show(@PathVariable Integer id) {
        Student s = repo.findById(id).get();
        return String.format("%s",s) ;
    }


        @RequestMapping("/add")
        @ResponseBody
        public String add(@RequestParam String name,
                          @RequestParam String major,
                          @RequestParam Double grade) {
    // ننشئ object جديد من Student
    Student s = new Student();
    s.setName(name);
    s.setMajor(major);
    s.setGrade(grade);

    // تخزين الطالب في قاعدة البيانات
    repo.save(s);

    return "Student added: " + s.toString();
}

    // Create
    @PostMapping
    public ResponseEntity<Student> create(@RequestBody Student student, UriComponentsBuilder uriBuilder) {
        Student saved = repo.save(student);
        URI uri = uriBuilder.path("/api/students/{id}").buildAndExpand(saved.getId()).toUri();
        return ResponseEntity.created(uri).body(saved);
    }

    @RequestMapping("/update/{id}")
    @ResponseBody
    public String update(@PathVariable Integer id,
                         @RequestParam String name,
                         @RequestParam String major,
                         @RequestParam Double grade) {
        Student s = repo.findById(id).orElse(null);
        if (s == null) return "Student not found";

        s.setName(name);
        s.setMajor(major);
        s.setGrade(grade);
        repo.save(s);

        return "Student updated: " + s.toString();
    }


     @RequestMapping("/delete/{id}")
     @ResponseBody
    public String delete(@PathVariable Integer id) {
        repo.deleteById(id);
        return "Student with id " + id + " deleted.";
    }

}
