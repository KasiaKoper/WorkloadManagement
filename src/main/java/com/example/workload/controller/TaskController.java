package com.example.workload.controller;

import com.example.workload.model.Task;
import com.example.workload.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/tasks")
@Controller
public class TaskController {

    @Autowired
    private TaskRepository taskRepository;

    @PostMapping("/add")
    public String addTask(@ModelAttribute Task task, ModelMap modelMap) {
        taskRepository.save(task);
        modelMap.put("task", task);
        return "taskAdd";
        //return "redirect:/tasks";
    }

    @GetMapping("/")
    public String showTasks(ModelMap modelMap){
        modelMap.put("task",taskRepository.findAll());
        return "taskShow";
    }


}