package states;

import ElevatorFactory.Elevator;
import Request.Request;

public class MvUp implements ElevatorState{
    @Override
    public void next(Elevator elevator) {
        if(elevator.getUpRequests().isEmpty()){
            elevator.stop();
        }     
        for(Request request : elevator.getDownRequests()) {
            while(elevator.getUpRequests().size()>0) {
                elevator.moveUp();
                if(elevator.getUpRequests().contains(request)) {
                    elevator.stop();
                    elevator.removeUpRequest(request);
                    System.out.println("Elevator " + elevator.getElevatorId() + " has stopped at floor " + elevator.currentFloor);
                }
            }
        }

        elevator.context.setState(new Idle());
    }

    @Override
    public String getState() {
        return "Moving Up";
    }
}
