package com.example.bootcamp_rest_1;

import org.springframework.stereotype.Component;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Component
public class EmployeeData {
private static List<Employee> employeeList=new ArrayList<>();
private static int employeeCount=3;
static {
    employeeList.add(new Employee(123,"akash",21));
    employeeList.add(new Employee(124,"vijay",23));
    employeeList.add(new Employee(125,"bhavya",25));
}

public List<Employee> getEmployeeAll(){
    return employeeList;
}

public Employee getEmployee(int id){
    for(Employee i: employeeList){
        if(i.getId()==id){
            return i;
        }
    }
    return null;
}

public Employee setEmployee(Employee e){
    Employee emp=new Employee(e);
    employeeList.add(emp);
    return emp;
}

public Employee delEmployee(int id){
   for(Employee i: employeeList){
       if (i.getId()==id){
           employeeList.remove(i);
           return i;
       }
   }
  return null;
}



}
