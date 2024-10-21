package com.elevator.repository;

import com.elevator.controller.ElevatorController;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ElevatorRepository extends JpaRepository<ElevatorController, Integer> {
}
