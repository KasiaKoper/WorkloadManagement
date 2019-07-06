package com.example.workload.controller;

import com.example.workload.model.Employee;
import com.example.workload.model.Task;
import com.example.workload.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/employees")
@Controller
public class EmployeeController {

    @Autowired
    private EmployeeRepository employeeRepository;

    @GetMapping("/add")
    public String getForm(ModelMap modelMap) {
        modelMap.put("employee",new Employee());
        return "employeeForm";
    }

    @PostMapping(path = "")
    public String create(@ModelAttribute Employee employee) {
        employeeRepository.save(employee);
        return "redirect:/";       //przejdz do adresu URL i wyczysc wszystkie wyslane parametry
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

    @GetMapping("/{id}")
    public String showPost(@PathVariable Integer id, ModelMap modelMap){
        Employee employee =employeeRepository.findById(id).get();
        modelMap.put("employee",employee);
        Task task=new Task();
        task.setEmployee(employee);
        modelMap.put("task", task);
        modelMap.put("tasks",employee.getTasks());
        return "taskByEmployee";
    }

}
