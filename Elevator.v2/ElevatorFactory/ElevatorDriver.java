package ElevatorFactory;

import java.util.HashMap;
import states.ElevatorState;
import states.MvDwn;
import states.MvUp;
import ElevatorStrategy.ElevatorStrategy;
import ElevatorStrategy.ElevatorStrategyImpl;
import Request.Request;

public class ElevatorDriver {
    HashMap<Integer, Elevator> elevators;
    ElevatorStrategy elevatorStrategy;
    
    public ElevatorDriver(int numberOfElevators) {
        elevatorStrategy = new ElevatorStrategyImpl();
        this.elevators = new HashMap<>();
        for(int i=0;i< numberOfElevators; i++) {
            elevators.put(i, new Elevator(i));
        }
    }

    public Elevator requestElevator(Request request){
        // request.requestType.equals("external")
        return elevatorStrategy.getNearestElevator(elevators, request);
   }

   public void processInternalRequest(Request request, int elevatorId){
        Elevator elevator = elevators.get(elevatorId);
        if(elevator == null) {
            System.out.println("Elevator with ID " + elevatorId + " does not exist.");
            return;
        }
        if(request.getFloor() == elevator.currentFloor) {
            System.out.println("Elevator " + elevatorId + " is already at floor " + request.getFloor());
            return;
        }

        if(elevator.context.getState().equals("Idle")) {
            ElevatorState state = null;
            if(request.getFloor() > elevator.currentFloor) {
                state = new MvUp();
                elevator.context.setState(state);
                elevator.context.next(elevator);
            }
            else{
                state = new MvDwn();
                elevator.context.setState(state);
                elevator.context.next(elevator);
            }
        }
   }
}
