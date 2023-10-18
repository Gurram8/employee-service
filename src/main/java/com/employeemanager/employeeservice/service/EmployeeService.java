package com.employeemanager.employeeservice.service;

import com.employeemanager.employeeservice.dto.EmployeeRequest;
import com.employeemanager.employeeservice.dto.EmployeeResponse;
import com.employeemanager.employeeservice.model.Employee;
import com.employeemanager.employeeservice.repository.EmployeeRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EmployeeService {

    private final EmployeeRepo employeeRepo;


    public List<EmployeeResponse> getAllEmployees() {
        List <Employee> employees = employeeRepo.findAll();

        return employees.stream().map(this::mapToEmployeeResponse).toList();
    }

    private EmployeeResponse mapToEmployeeResponse(Employee employee) {
        return EmployeeResponse.builder()
                .id(employee.getId())
                .firstName(employee.getFirstName())
                .lastName(employee.getLastName())
                .email(employee.getEmail())
                .build();
    }

    public void createEmployee(EmployeeRequest employeeRequest) {
        Employee employee = Employee.builder()
                .id(employeeRequest.getId())
                .email(employeeRequest.getEmail())
                .firstName(employeeRequest.getFirstName())
                .lastName(employeeRequest.getLastName())
                .build();

        employeeRepo.save(employee);
    }

}
