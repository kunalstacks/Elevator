package com.elevator.dispatcher;

import com.elevator.controller.ElevatorController;
import com.elevator.model.Direction;
import com.elevator.model.ElevatorSystem;

public class ExternalDispatcher {

    public static ExternalDispatcher INSTANCE = new ExternalDispatcher();

    private ExternalDispatcher() {
        // Private constructor for singleton pattern
    }

    public void submitRequest(int floor, Direction dir) {
        int elevatorId = ElevatorSystem.elevatorSelectionStrategy.selectElevator(floor, dir);
        System.out.println("Selected elevator " + elevatorId);

        for (ElevatorController eController : ElevatorSystem.INSTANCE.getElevatorControllerList()) {
            if (eController.getId() == elevatorId) {
                eController.acceptRequest(floor, dir);
            }
        }
    }
}