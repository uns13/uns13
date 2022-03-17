package com.javaguide.springboot.controller;

import com.javaguide.springboot.exception.ResourceNotFoundException;
import com.javaguide.springboot.model.Student;
import com.javaguide.springboot.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin("*")
@RestController
@RequestMapping("/api/v1/students")
public class StudentController {

    @Autowired
    private StudentRepository studentRepository;

    @GetMapping
    public List<Student> getAllStudents() {
        return this.studentRepository.findAll();
    }

    //Create Student Built REST API
    @PostMapping
    public Student StudentcreateStudent(@RequestBody Student student){
        return studentRepository.save(student);
    }

    //build Students by id REST API
    @GetMapping("{id}")
    public ResponseEntity<Student> getStudentById(@PathVariable long id){
        Student student = studentRepository.findById(id)
                .orElseThrow(() ->new ResourceNotFoundException("Student not exit with id:" + id));
        return ResponseEntity.ok(student);

    }

    // build update students REST API
    @PutMapping("{id}")
    public ResponseEntity<Student> updateStudent(@PathVariable long id,@RequestBody Student studentDetails){
        Student updateStudent = studentRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Student not exist with id:" + id));

        updateStudent.setFirstName(studentDetails.getFirstName());
        updateStudent.setLastName(studentDetails.getLastName());
        updateStudent.setEmailId(studentDetails.getEmailId());

        studentRepository.save(updateStudent);

        return ResponseEntity.ok(updateStudent);
    }

 /*   @DeleteMapping
    public Student StudentcreateStudent(@RequestBody Student student){return studentRepository.save(student);}*/

  /*  @RequestMapping
    public void deleteStudendentController() {
        studentRepository.deleteAll();
    }*/
}
