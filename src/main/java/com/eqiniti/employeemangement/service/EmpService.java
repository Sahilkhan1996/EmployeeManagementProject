package com.eqiniti.employeemangement.service;

import com.eqiniti.employeemangement.model.Employee;
import com.eqiniti.employeemangement.repository.EmpRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmpService {
    @Autowired
    EmpRepository empRepository;

    public void addEmp(Employee employee){
        empRepository.save(employee);
    }

    public List<Employee> getAllEmp(){
        return empRepository.findAll();
    }
    public Employee getEmpByID(int id){
         Optional<Employee> e =empRepository.findById(id);
         if(e.isPresent()){
             return e.get();
         }else{
             return null;
         }
    }

    public void updateEmployeeDetails(Employee employee) {
        System.out.println("Id is:::"+employee.getId());
        Employee emp=getEmpByID(employee.getId());
        emp=employee;
        empRepository.save(emp);
    }

    public void deleteById(int id) {
        empRepository.deleteById(id);
    }
}
