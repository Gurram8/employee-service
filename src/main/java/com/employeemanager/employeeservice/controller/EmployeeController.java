package com.employeemanager.employeeservice.controller;

import com.employeemanager.employeeservice.dto.EmployeeRequest;
import com.employeemanager.employeeservice.dto.EmployeeResponse;
import com.employeemanager.employeeservice.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/v1/")
@RequiredArgsConstructor
public class EmployeeController {

    private final EmployeeService employeeService;

    @GetMapping("/employees")
    @ResponseStatus(HttpStatus.OK)
    public List<EmployeeResponse> getAllEmployees() {
        return employeeService.getAllEmployees();
    }

    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public void createEmployee(@RequestBody EmployeeRequest EmployeeRequest) {
        employeeService.createEmployee(EmployeeRequest);
    }


}
