package com.example.workload.repository;

import com.example.workload.model.Employee;
import org.springframework.data.repository.CrudRepository;

public interface EmployeeRepository extends CrudRepository <Employee,Integer>{
}
