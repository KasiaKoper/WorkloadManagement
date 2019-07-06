package com.example.workload.controller;

import com.example.workload.repository.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TeamController {

    @Autowired
    private TeamRepository teamRepository;
//
//    @GetMapping("/employees")
//    public String getAllEmployees(ModelMap modelMap) {
//        //findAll znajduje wszytskich uzytkownikow
//        //ModelMap do przekazywanie zmiennych z Javy do Thymeleafa
//
//        modelMap.put("employees", team.ge);
//        return "employeesList";
//

}
