package com.example.workload.controller;

import com.example.workload.model.Employee;
import com.example.workload.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/employees")
public class EmployeeController {


    @Autowired
    private EmployeeRepository employeeRepository;

    @GetMapping("/add")
    public String getForm() {
        return "employeeForm";
    }

    @PostMapping(path = "")
    public String create(@ModelAttribute Employee employee) {
        employeeRepository.save(employee);
        return "redirect:/employees";       //przejdz do adresu URL i wyczysc wszystkie wyslane parametry
    }

    @GetMapping("")
    public String getAll(ModelMap modelMap) {
        //findAll znajduje wszytskich uzytkownikow
        //ModelMap do przekazywanie zmiennych z Javy do Thymeleafa

        modelMap.put("employees", employeeRepository.findAll());
        return "employeesList";
    }
//
//    @GetMapping("/users/{id}")
//    public String show(@PathVariable Integer id, ModelMap modelMap) {
//        modelMap.put("user", userRepository.findById(id).get());
//        return "show";
//    }



}
