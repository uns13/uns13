package com.javaguide.springboot;

import com.javaguide.springboot.model.Student;
import com.javaguide.springboot.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringbootBackendApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootBackendApplication.class, args);
	}

	@Autowired
	private StudentRepository studentRepository;

	@Override
	public void run(String... args) throws Exception {

//		Student student = new Student();
//		student.setFirstName("Yunus");
//		student.setLastName("Ebrahim S");
//		student.setEmailId("yub@gmail.com");
//		studentRepository.save(student);
//
//		Student student1 = new Student();
//		student1.setFirstName("Hajira");
//		student1.setLastName("Ummal");
//		student1.setEmailId("haji@gmail.com");
//		studentRepository.save(student1);

	}
}
