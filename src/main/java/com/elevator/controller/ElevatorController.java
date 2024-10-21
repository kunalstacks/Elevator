package com.elevator.controller;

import com.elevator.algorithm.PendingRequests;
import com.elevator.model.Direction;
import com.elevator.model.ElevatorSystem;
import com.elevator.service.ElevatorService;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/elevator")
public class ElevatorController {


    @Autowired
    private ElevatorService elevatorService;

    @Autowired
    private ElevatorSystem elevatorSystem;

    public ElevatorController(int i, ElevatorSystem elevatorSystem) {

    }

    @PostMapping("/request")
    public ResponseEntity<String> requestElevator(@RequestParam int floor, @RequestParam Direction direction) {
        elevatorService.requestElevator(floor, direction);
        return ResponseEntity.ok("Elevator requested");
    }
    public void acceptRequest(int floor, Direction dir) {
        ElevatorSystem.elevatorControlStrategy.getPendingRequestList().add(new PendingRequests(floor, dir));
        controlCar();
    }

    private void controlCar() {
        ElevatorSystem.elevatorControlStrategy.moveElevator(this);
        System.out.println("Elevator moving...");
    }

}