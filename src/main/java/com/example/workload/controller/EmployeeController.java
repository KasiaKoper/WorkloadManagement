package com.example.workload.controller;

import com.example.workload.model.Employee;
import com.example.workload.model.Task;
import com.example.workload.repository.EmployeeRepository;
import com.example.workload.repository.TaskRepository;
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
    @Autowired
    private TaskRepository taskRepository;

    @GetMapping("/add")
    public String addEmployee(ModelMap modelMap) {
        modelMap.put("employee",new Employee());
        return "employeeForm";
    }

    @PostMapping(path = "")
    public String create(@ModelAttribute Employee employee) {
        employeeRepository.save(employee);
        return "redirect:/employees/"+employee.getId();       //przejdz do adresu URL i wyczysc wszystkie wyslane parametry
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
    public String showEmployee(@PathVariable Integer id, ModelMap modelMap){
        Employee employee =employeeRepository.findById(id).get();
        modelMap.put("employee",employee);
        Task task=new Task();
        task.setEmployee(employee);
        modelMap.put("task", task);
        modelMap.put("myTasks",employee.getTasks());
        modelMap.put("tasks",taskRepository.findAll());
        return "taskByEmployee";
    }

    @PostMapping("/{id}")
    public String addtask(@PathVariable Integer id,
                          @ModelAttribute Task task){
        Employee employee=employeeRepository.findById(id).get();    //optional
        Task task2=taskRepository.findById(task.getId()).get();
        task2.setEmployee(employee);
        taskRepository.save(task2);
        return "redirect:/employees/" + employee.getId();
    }

}
