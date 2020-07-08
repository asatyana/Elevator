package com.ananth.lift;

public class LiftOperator {
    public static void main(String[] args) {
        int [] stoppages = {1, 6, 3, 8, 9, 14};
        String [] elevators = {"LiftA", "LiftB"};
        ElevatorSystem lifts = new ElevatorSystem(elevators, 15, stoppages);
        lifts.startElevatorService();
    }
}
