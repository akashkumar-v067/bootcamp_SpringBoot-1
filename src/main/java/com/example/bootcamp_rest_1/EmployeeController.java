package com.example.bootcamp_rest_1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
public class EmployeeController {
  //Ques 2 implemented here

    @Autowired
    EmployeeData service;

    @GetMapping(path = "/Ques2/getAll")
    public List<Employee> getAll(){
        return service.getEmployeeAll();
    }

    @GetMapping(path = "/Ques2/getOne/{id}")
    public Employee getOne(@PathVariable int id){
       Employee e=service.getEmployee(id);
       if(e==null){
           throw new UserNotRegisteredException("id: "+id);

       }
       return e;
    }
//Ques 5 Implement POST http request for Employee to create a new employee.
    @PostMapping(path="/Ques2/addEmp")
    public ResponseEntity<Object> addEmp(@Valid @RequestBody Employee emp){
        service.setEmployee(emp);

        //for normal message at body change return type String and uncomment line below
        // return System.out.println(emp+" added successfully" );

        //used to show proper http code 201 created (comment it if print normal message)
        URI location = ServletUriComponentsBuilder
                .fromUriString("/Ques2/getOne")
                .path("/{id}")
                .buildAndExpand(emp.getId())
                .toUri();

        ResponseEntity.created(location).build();
        return ResponseEntity.created(location).build();
    }

  //Ques: 7 Implement DELETE http request for Employee to delete employee
    @DeleteMapping(path = "/Ques2/delEmp/{id}")
    public void delEmp(@PathVariable int id){
      Employee i= service.delEmployee(id);
        if(i==null){
            throw new UserNotRegisteredException(id+" ");
        }
    }




}
