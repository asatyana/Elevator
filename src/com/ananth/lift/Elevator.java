package com.ananth.lift;

import static com.ananth.lift.Utils.DIRECTION.DOWN;

public class Elevator {
    private int currentFloorNumber = 0;
    private Utils.DIRECTION direction;
    private final int numberOfFloors;
    private boolean isDefault;
    private String name;

    private int[] floorsToVisit;

    public Elevator(String name, int numberOfFloors) {
        this.numberOfFloors = numberOfFloors;
        this.name = name;
    }

    public int goToFloor(int floor) {
        if (currentFloorNumber > floor) {
            direction = Utils.DIRECTION.UP;
        } else {
            direction = Utils.DIRECTION.DOWN;
        }
        currentFloorNumber = floor;
        return currentFloorNumber;
    }

    public int getCurrentFloorNumber() {
        return this.currentFloorNumber;
    }

    public Utils.DIRECTION getDirection() {
        return this.direction;
    }

    public String getName() {
        return this.name;
    }
}
