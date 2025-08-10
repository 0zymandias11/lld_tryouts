package ElevatorStrategy;

import java.util.HashMap;

import ElevatorFactory.Elevator;
import Request.Request;

public interface ElevatorStrategy {
    public Elevator getNearestElevator(HashMap<Integer, Elevator> elevatorMap,Request request);
}
