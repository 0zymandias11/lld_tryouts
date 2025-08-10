package states;
import ElevatorFactory.Elevator;
public class ElevatorContext {
    public ElevatorState currentState;

    public ElevatorContext(){
        this.currentState = new Idle(); // Initial state
    }

    public void setState(ElevatorState state) {
        this.currentState = state;
    }

    public void next(Elevator elevator) {
        currentState.next(elevator);
    }

    public String getState(){
        return currentState.getState();
    }
}
