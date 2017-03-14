// you can also use imports, for example:
// import java.util.*;

// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");

import java.util.*;



class Solution {
    public int solution(int[] A, int[] B, int M, int X, int Y) {
        int floors=M;
        int maxCapacity=X;
        int maxWeight=Y;
        Elevator elevator=new Elevator(maxCapacity,maxWeight, floors);
        ElevatorComputer elevatorComputer=new ElevatorComputer();
        Queue<Occupant> occupantList=getOccupants(A,B);
        return elevatorComputer.calculateStops(elevator,occupantList);

    }

    private Queue<Occupant> getOccupants(int[] a, int[] b) {
        Queue<Occupant> toReturn=new LinkedList<>();
        for (int i = 0; i < a.length; i++) {
            toReturn.add(new Occupant(a[i],b[i]));
        }
        return toReturn;
    }

    public static class Elevator {
        private final int maxCapacity;
        private final int maxWeight;
        private final int maxFloor;
        private int totalStops;
        private int currentFloor;
        private LinkedList<Integer> destinationFloors=new LinkedList<>();

        public Elevator(int maxCapacity, int maxWeight, int maxFloor) {
            this.maxCapacity=maxCapacity;
            this.maxWeight=maxWeight;
            this.maxFloor = maxFloor;
            this.currentFloor=0;
            this.totalStops=1;
        }

        public void addFloor(int floor) {
            destinationFloors.add(floor);
            Collections.sort(destinationFloors);
        }

        public void moveToNextFloor() {
            int floor=destinationFloors.poll();
            while (!destinationFloors.isEmpty()&& floor == destinationFloors.peek()) {
                destinationFloors.poll();
            }
            totalStops++;
        }

        public boolean hasMoreFloors() {
            return !destinationFloors.isEmpty();
        }
    }

    public class ElevatorComputer {

        public int calculateStops(Elevator elevator, Queue<Occupant> occupantList) {
            int toReturn=0;
            int currentWeight=0;
            while (!occupantList.isEmpty()) {
                Occupant currentOccupant=occupantList.poll();
                boolean canElevatorSupportWeight = currentWeight + currentOccupant.getWeight() < elevator.maxWeight;
                boolean canElevatorSupportCapacity = elevator.destinationFloors.size() < elevator.maxCapacity;
                boolean hasNoMoreOccupants = occupantList.isEmpty();
                if (canElevatorSupportWeight && canElevatorSupportCapacity) {
                    currentWeight+=currentOccupant.weight;
                    elevator.addFloor(currentOccupant.floor);
                }
                if (!canElevatorSupportCapacity||!canElevatorSupportWeight){
                    currentWeight=0;
                    toReturn+=calculateElevatorStopsAndEmptyElevator(elevator);
                    elevator.addFloor(currentOccupant.floor);
                }
                if (hasNoMoreOccupants) {
                    toReturn+=calculateElevatorStopsAndEmptyElevator(elevator);
                }

            }
            return toReturn;
        }

        private int calculateElevatorStopsAndEmptyElevator(Elevator elevator) {
            elevator.totalStops=1;
            while (elevator.hasMoreFloors()) {
                elevator.moveToNextFloor();
            }
            return elevator.totalStops;
        }
    }

    public class Occupant {
        private final int weight;
        private final int floor;

        public Occupant(int weight, int floor) {
            this.weight=weight;
            this.floor=floor;
        }

        public int getWeight() {
            return weight;
        }

        public int getFloor() {
            return floor;
        }
    }
}