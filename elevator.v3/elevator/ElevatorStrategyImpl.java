// File: ElevatorStrategyImpl.java
package elevator;

import java.util.Comparator;
import java.util.HashMap;

public class ElevatorStrategyImpl implements ElevatorStrategy {
    private int cost(Elevator e, Request r) {
        int dist = Math.abs(e.getCurrentFloor() - r.getFloor());
        if (e.getDirection() == Direction.IDLE) return dist + 10;
        boolean sameDirToward = (e.getDirection() == Direction.UP && r.getFloor() >= e.getCurrentFloor())
                || (e.getDirection() == Direction.DOWN && r.getFloor() <= e.getCurrentFloor());
        return sameDirToward ? dist : dist + 100;
    }

    @Override public Elevator select(HashMap<Integer, Elevator> elevators, Request request) {
        return elevators.values().stream()
                .min(Comparator.comparingInt(e -> cost(e, request)))
                .orElse(null);
    }
}