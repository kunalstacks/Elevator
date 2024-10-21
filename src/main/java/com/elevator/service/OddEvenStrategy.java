package com.elevator.service;

import com.elevator.model.Direction;
import org.springframework.stereotype.Service;

@Service
public class OddEvenStrategy implements ElevatorSelectionStrategy {
    @Override
    public int selectElevator(int floor, Direction dir) {
        return 0;
    }

    // Implementation
}
