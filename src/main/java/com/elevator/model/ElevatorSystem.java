package com.elevator.model;

import com.elevator.controller.ElevatorController;
import com.elevator.service.ElevatorControlStrategy;
import com.elevator.service.ElevatorSelectionStrategy;
import jakarta.annotation.PostConstruct;
import lombok.Getter;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

@Component
@Getter
public class ElevatorSystem {

    public static final ElevatorSystem INSTANCE = new ElevatorSystem();

    private final List<ElevatorController> elevatorControllerList = new CopyOnWriteArrayList<>();
    private final List<Floor> floors = new CopyOnWriteArrayList<>();

    public static ElevatorControlStrategy elevatorControlStrategy;
    public static ElevatorSelectionStrategy elevatorSelectionStrategy;

    private static final int TOTAL_FLOORS = 50;
    private static final int TOTAL_ELEVATORS = 4;

    public ElevatorSystem(ElevatorControlStrategy elevatorControlStrategy,
                          ElevatorSelectionStrategy elevatorSelectionStrategy) {
        ElevatorSystem.elevatorControlStrategy = elevatorControlStrategy;
        ElevatorSystem.elevatorSelectionStrategy = elevatorSelectionStrategy;
    }

    public ElevatorSystem() {
        elevatorControlStrategy = null; // or provide a default strategy
    }

    public ElevatorSystem(ElevatorControlStrategy elevatorControlStrategy) {
        ElevatorSystem.elevatorControlStrategy = elevatorControlStrategy;
    }

    @PostConstruct
    public void initialize() {
        initializeFloors();
        initializeElevators();
    }

    private void initializeFloors() {
        for (int i = 0; i <= TOTAL_FLOORS; i++) {
            addFloor(new Floor(i));
        }
        System.out.println("Number of floors added: " + (TOTAL_FLOORS + 1));
    }

    private void initializeElevators() {
        for (int i = 1; i <= TOTAL_ELEVATORS; i++) {
            addElevator(new ElevatorController(i, this));
        }
        System.out.println("Number of elevators added: " + TOTAL_ELEVATORS);
    }

    public void addElevator(ElevatorController elevator) {
        elevatorControllerList.add(elevator);
    }

    public void removeElevator(ElevatorController elevator) {
        elevatorControllerList.remove(elevator);
    }

    public void addFloor(Floor floor) {
        floors.add(floor);
    }

    public ElevatorController getElevatorById(int id) {
        return elevatorControllerList.stream()
//                .filter(e -> e.getId() == id)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Elevator not found with id: " + id));
    }

    public Floor getFloorById(int id) {
        return floors.stream()
                .filter(f -> f.getId() == id)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Floor not found with id: " + id));
    }
}