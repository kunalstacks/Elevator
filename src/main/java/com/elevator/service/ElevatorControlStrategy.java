package com.elevator.service;

import com.elevator.controller.ElevatorController;

import java.util.Collection;

public interface ElevatorControlStrategy {
    void moveElevator(ElevatorController elevatorController);

    Collection<Object> getPendingRequestList();
}
