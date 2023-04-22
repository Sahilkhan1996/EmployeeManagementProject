package com.eqiniti.employeemangement.controller;

import com.eqiniti.employeemangement.model.Employee;
import com.eqiniti.employeemangement.service.EmpService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class EmpControlller {
    @Autowired
    EmpService empService;

    @GetMapping("/")
    public String home(Model m) {
        List<Employee> emp = empService.getAllEmp();
        m.addAttribute("emp", emp);

        return "index";
    }

    @GetMapping("/addemp")
    public String addEmp() {
        return "add_emp";
    }

    @PostMapping("/register")
    public String register(@ModelAttribute Employee employee, HttpSession session) {
        empService.addEmp(employee);
        System.out.println(employee);
        session.setAttribute("msg", "Employee is added Sucessfully!");
        return "redirect:/";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable String id, Model m) {
        System.out.println("Id: " + id);
        Integer id1 = Integer.parseInt(id);
        System.out.println(id1);
        Employee e = empService.getEmpByID(id1);
        System.out.println("Employee details returned" + e);
        m.addAttribute("emp", e);
        return "edit";
    }

    @PostMapping("/update")
    public String updateEmp(@ModelAttribute Employee employee) {
        empService.addEmp(employee);
        return "redirect:/";
    }

    @GetMapping("delete/{id}")
    public String deleteEmp(@PathVariable int id) {
empService.deleteById(id);
        return "redirect:/";

    }
}