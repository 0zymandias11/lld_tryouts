package elevator;

import java.util.HashMap;

public interface ElevatorStrategy {
    Elevator select(HashMap<Integer, Elevator> elevators, Request request);
}