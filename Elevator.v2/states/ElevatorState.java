package states;

import ElevatorFactory.Elevator;

public interface ElevatorState {
    public void next(Elevator elevator);
    public String getState();
}