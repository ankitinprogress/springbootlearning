package com.learning.training;

import com.learning.training.enitity.Employee;
import com.learning.training.facade.TrainingDataOperation;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class TrainingApplication {

	public static void main(String[] args) {
		SpringApplication.run(TrainingApplication.class, args);
	}
	@Bean
	public CommandLineRunner commandLineRunner(TrainingDataOperation trainingDataOperation) {

		Employee employee = new Employee("Ankit", "Bhargava", "ankit@gmail.com", "8520067572");
		return args -> {
			trainingDataOperation.addUser(employee);
		};
	}

}
