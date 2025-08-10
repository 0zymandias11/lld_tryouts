package ElevatorStrategy;

import java.util.HashMap;

import ElevatorFactory.Elevator;
import Request.Request;

public class ElevatorStrategyImpl implements ElevatorStrategy {
    @Override
    public Elevator getNearestElevator(HashMap<Integer, Elevator> elevatorMap, Request request) {
        Elevator temp = null;
        int floorDiff=Integer.MAX_VALUE;
        for(Elevator elevator: elevatorMap.values()){
            if(elevator.currentFloor == request.getFloor())
                return elevator;
            else{
                int diff = Math.abs(request.getFloor() - elevator.currentFloor);
                if(diff< floorDiff){
                    floorDiff = diff;
                    temp = elevator;
                }
            }
        }
        return temp;
    }
}
