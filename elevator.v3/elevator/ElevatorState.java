package elevator;


public interface ElevatorState {
    /** Advance one step of the state machine. Do not recurse. */
    void next(Elevator elevator) throws InterruptedException;
    String getState();
}
