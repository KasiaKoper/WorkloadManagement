package com.example.workload.model;

import javax.persistence.*;

@Entity
public class Task {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private int id;

    private String description;
    private double timeInHour;

    @ManyToOne(cascade = CascadeType.ALL)
    private Employee employee;

    @ManyToOne(cascade = CascadeType.ALL)
    private Team team;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getTimeInHour() {
        return timeInHour;
    }

    public void setTimeInHour(double timeInHour) {
        this.timeInHour = timeInHour;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }
}
