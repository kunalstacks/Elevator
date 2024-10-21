package com.elevator.model;

import lombok.Getter;
import lombok.Setter;

import java.awt.*;

@Getter
@Setter
public class Floor {
    private int id;
    private Display display;
    private Button button;

    public Floor(int id) {
        this.id = id;
        button = new ExternalButton();
    }

    public void pressButton(Direction dir) {
        button.pressButton(id, dir);
    }

    private void setDisplay(int floor, Direction dir) {
        display.setDir(dir);
        display.setFloor(floor);
    }
}