package com.elevator.service;

import com.elevator.model.Direction;

public interface ElevatorSelectionStrategy {
    int selectElevator(int floor, Direction dir);

}
