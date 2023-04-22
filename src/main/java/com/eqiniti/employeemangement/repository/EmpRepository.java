package com.eqiniti.employeemangement.repository;

import com.eqiniti.employeemangement.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmpRepository  extends JpaRepository<Employee,Integer> {
}
