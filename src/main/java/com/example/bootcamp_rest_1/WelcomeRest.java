package com.example.bootcamp_rest_1;

import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

@RestController
public class WelcomeRest {

    //Ques 1:Create a simple REST full service in Spring Boot which returns the Response "Welcome to spring boot"
    @GetMapping(path = "/Ques1")
    public String hello(){
        return "Welcome to Spring Boot";
    }

    //Ques 3: Implement GET http request for Employee to get list of employees
    @GetMapping(path="/Ques3/Employee")
    public List<Employee> getEmployeeList() {
        List list= Arrays.asList(
                new Employee(1,"akash",21),
                new Employee(2,"bhavya",23),
                new Employee(3,"shivam",25),
                new Employee(4,"pankaj",25));
        return list;
    }

    //Ques 4: to fetch the details of employee using PathVariable
    @GetMapping(path = "/Ques4/Employee/{top}")
    public Employee getEmployee(@PathVariable String top){
       List<Employee> list=getEmployeeList();
      Employee emp=list.stream().filter(e->e.getName().equals(top)).findFirst().orElse(null);
      return emp;
    }





}
