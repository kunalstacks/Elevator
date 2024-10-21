package com.elevator.service;

import com.elevator.model.Direction;
import com.elevator.model.ElevatorSystem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ElevatorService {

    @Autowired
    private ElevatorSystem elevatorSystem;

    public void requestElevator(int floor, Direction direction) {
        // Implementation
    }

    // Add more methods as needed
}