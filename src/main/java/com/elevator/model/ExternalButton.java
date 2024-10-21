package com.elevator.model;

import com.elevator.dispatcher.ExternalDispatcher;
import lombok.Getter;

public class ExternalButton extends Button {
    private final ExternalDispatcher edispatcher = ExternalDispatcher.INSTANCE;
    @Getter
    private Direction direction;

    public void pressButton(int floor, Direction dir) {
        direction = dir;
        System.out.println("Pressed " + direction + " from floor " + floor);
        edispatcher.submitRequest(floor, dir);
    }
}
