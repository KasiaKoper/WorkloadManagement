package com.example.workload.controller;

import com.example.workload.model.Task;
import com.example.workload.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/tasks")
@Controller
public class TaskController {

    @Autowired
    private TaskRepository taskRepository;

    @GetMapping("/add")
    public String addTask(ModelMap modelMap) {
        modelMap.put("task", new Task());
        return "task/add";
    }

    @PostMapping(path="")
    public String createTask(@ModelAttribute Task task) {
        taskRepository.save(task);
        return "redirect:/tasks";
    }

    @GetMapping("")
    public String showTasks(ModelMap modelMap){
        modelMap.put("tasks",taskRepository.findAll());
        return "task/show";
    }

//    @GetMapping("/{id}")
//    public String assignTask(@PathVariable Integer id, ModelMap modelMap){
//        Task task =taskRepository.findById(id).get();
//        modelMap.put("task",task);
//        Employee employee=new Employee();
//        task.setEmployee(employee);
//        modelMap.put("task", task);
//        modelMap.put("tasks",employee.getTasks());
//        return "taskByEmployee";
//    }


}