package com.example.workload.controller;

import com.example.workload.repository.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class TeamController {

    @Autowired
    private TeamRepository teamRepository;

}
