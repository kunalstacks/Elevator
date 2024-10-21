package com.elevator.service;

import com.elevator.controller.ElevatorController;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;

@Service
public class LookAlgorithm implements ElevatorControlStrategy {
    @Override
    public void moveElevator(ElevatorController elevatorController) {

    }

    @Override
    public Collection<Object> getPendingRequestList() {
        return List.of();
    }
    // Implementation
}
