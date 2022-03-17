package com.example.demo;

import com.example.demo.entity.Employee;
import com.example.demo.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner {

	public static void main(String[] args) {

		SpringApplication.run(DemoApplication.class, args);
	}

	@Autowired
	private EmployeeRepository employeeRepository;

	@Override
	public void run(String... args) throws Exception {

/*		Employee employee2 = new Employee("Jhon", 30, 35000L,
				"yi@gmail.com", 9943471809L);
		employeeRepository.save(employee2);

		Employee employee3 = new Employee("Ram", 20, 50000L,
				"rm3@gmail.com", 9943471888L);
		employeeRepository.save(employee3);
*/
	}
}
