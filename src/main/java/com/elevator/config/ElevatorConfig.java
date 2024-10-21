package com.elevator.config;

import com.elevator.model.ElevatorSystem;
import com.elevator.service.ElevatorControlStrategy;
import com.elevator.service.ElevatorSelectionStrategy;
import com.elevator.service.LookAlgorithm;
import com.elevator.service.OddEvenStrategy;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ElevatorConfig {

    @Bean
    public ElevatorControlStrategy elevatorControlStrategy() {
        return new LookAlgorithm();
    }

    @Bean
    public ElevatorSelectionStrategy elevatorSelectionStrategy() {
        return new OddEvenStrategy();
    }

    @Bean
    public ElevatorSystem elevatorSystem() {
        return new ElevatorSystem(); // Assuming ElevatorSystem has a default constructor
    }
}