package com.example.demo.entity;

import javax.persistence.*;

@Entity
@Table(name = "employees")
public class Employee {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        @Column(name = "employee_name", nullable = false)
        private String EmployeeName;

        @Column(name ="age")
        private int Age;

        @Column(name = "salary")
        private Long Salary;

        @Column(name = "email")
        private String Email;

        @Column(name = "phoneNo")
        private Long PhoneNo;

        public Employee() {

        }

        public Employee(String employeeName, int age, Long salary, String email, Long phoneNo){
            super();
            this.setEmployeeName(employeeName);
            this.setAge(age);
            this.setSalary(salary);
            this.setEmail(email);
            this.setPhoneNo(phoneNo);

        }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmployeeName() {
        return EmployeeName;
    }

    public void setEmployeeName(String employeeName) {
        EmployeeName = employeeName;
    }

    public int getAge() {
        return Age;
    }

    public void setAge(int age) {
        Age = age;
    }

    public Long getSalary() {
        return Salary;
    }

    public void setSalary(Long salary) {
        Salary = salary;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public Long getPhoneNo() {
        return PhoneNo;
    }

    public void setPhoneNo(Long phoneNo) {
        PhoneNo = phoneNo;
    }
}
