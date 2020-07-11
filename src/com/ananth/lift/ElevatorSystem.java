package com.ananth.lift;

import java.util.Arrays;
import org.apache.commons.collections4.iterators.ArrayIterator;

public class ElevatorSystem {

    private Elevator[] lifts;
    private ArrayIterator stopsAsIterator;
    private int[] stops;
    private int floors;
    private String[] elevatorNames;

    public ElevatorSystem(String[] elevators, int floors, int[] stops) {
        this.floors = floors;
        this.stops = stops;
        Arrays.sort(stops);
        this.stopsAsIterator = new ArrayIterator(stops);
        this.elevatorNames = elevators;
        this.lifts = new Elevator[elevatorNames.length];

        for (int i = 0; i < elevatorNames.length; i++) {
            lifts[i] = new Elevator(elevatorNames[i], floors);
        }
    }

    public void startElevatorService() {
        int nextFloor = -1;
        int liftIndex = -1;
        int delta;
        int assignedLift = -1;
        while (true) {
            if (stopsAsIterator.hasNext()) {
                nextFloor = (int) stopsAsIterator.next();
            } else {
                System.exit(0);
            }
            for (int i = 0; i < lifts.length; i++) {
                if (nextFloor > lifts[i].getCurrentFloorNumber() && lifts[i].getDirection() == Utils.DIRECTION.UP) {
                    delta = nextFloor - lifts[i].getCurrentFloorNumber();
                    if (check(stops, nextFloor)) {
                        assignedLift = i;
                    }
                }
            }
            lifts[assignedLift].goToFloor(nextFloor);
        }
    }

    // Function return true if given element
    // found in array
    private  boolean check(int[] arr, int toCheckValue)
    {
        // check if the specified element
        // is present in the array or not
        // using Linear Search method
        boolean test = false;
        for (int element : arr) {
            if (element == toCheckValue) {
                test = true;
                break;
            }
        }
        return test;
    }
}
