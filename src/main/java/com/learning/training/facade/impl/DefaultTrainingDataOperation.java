package com.learning.training.facade.impl;

import com.learning.training.enitity.Employee;
import com.learning.training.facade.TrainingDataOperation;
import jakarta.persistence.EntityManager;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class DefaultTrainingDataOperation implements TrainingDataOperation {

    private final EntityManager entityManager;

    public DefaultTrainingDataOperation(EntityManager entityManager) {
        this.entityManager = entityManager;
    }


    @Override
    @Transactional
    public String addUser(Employee employee) {
        entityManager.persist(employee);
        return employee.toString();
    }

}
