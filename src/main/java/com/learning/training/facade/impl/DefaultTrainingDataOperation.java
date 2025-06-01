package com.learning.training.facade.impl;

import com.learning.training.enitity.Employee;
import com.learning.training.facade.TrainingDataOperation;
import com.learning.training.repository.EmployeeRepository;
import org.springframework.stereotype.Service;

@Service
public class DefaultTrainingDataOperation implements TrainingDataOperation {

    EmployeeRepository employeeRepository;

    public DefaultTrainingDataOperation(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public String addUser(Employee employee) {
        if (isUserExsiting(employee)){
            return "User already exists";
        }
        return employeeRepository.save(employee).toString();
    }

    private boolean isUserExsiting(Employee employee){
        return employeeRepository.existsById(Integer.parseInt(employee.getId()));
    }
    @Override
    public void deleteUser(int id) {
        employeeRepository.deleteById(id);
    }
}
