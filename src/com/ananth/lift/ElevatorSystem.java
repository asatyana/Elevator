package com.ananth.lift;

import java.util.Arrays;
import java.util.Iterator;

public class ElevatorSystem {

    private Elevator[] lifts;
    private Iterator<Integer> stops;
    private int floors;
    private String[] elevatorNames;

    public ElevatorSystem(String[] elevators, int floors, Integer[] stops) {
        this.floors = floors;
        this.stops = Arrays.asList(stops).iterator();
        this.elevatorNames = elevators;
        this.lifts = new Elevator[elevatorNames.length];

        for (int i = 0; i < elevatorNames.length; i++) {
            lifts[i] = new Elevator(elevatorNames[i], floors);
        }
    }

    public void startElevatorService() {
        int nextFloor;
        int liftIndex = -1;
        int delta;
        while (true) {
            nextFloor = stops.next().intValue();
            for (int i = 0; i < lifts.length; i++) {
                if (nextFloor > lifts[i].getCurrentFloorNumber() && lifts[i].getDirection() == Utils.DIRECTION.UP) {
                    delta = Math.abs(nextFloor - lifts[i].getCurrentFloorNumber());
                } else {

                }
                if (nextFloor == lifts[i].getCurrentFloorNumber()) {
                    System.out.printf("Lift at %d, going to floor %d\n", liftA.getCurrentFloorNumber(), stops[i]);
                } else {
                    System.out.printf("Lift at %d, going to floor %d\n", liftA.getCurrentFloorNumber(), stops[i]);
                    liftA.goToFloor(stops[i]);
                }
            }
        }
    }
}
