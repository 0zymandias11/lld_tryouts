package states;

import ElevatorFactory.Elevator;
import Request.Request;

public class MvDwn implements ElevatorState {

    @Override
    public void next(Elevator elevator) {
        if(elevator.getDownRequests().isEmpty()){
            elevator.stop();
        }     
        for(Request request : elevator.getDownRequests()) {
            while(elevator.getDownRequests().size()>0) {
                elevator.moveDown();
                if(elevator.getDownRequests().contains(request)) {
                    elevator.stop();
                    elevator.removeDownRequest(request);
                    System.out.println("Elevator " + elevator.getElevatorId() + " has stopped at floor " + elevator.currentFloor);
                    
                }
            }
        }

        if(elevator.getUpRequests().isEmpty()) {
            elevator.context.setState(new Idle());
            elevator.context.next(elevator);
        }
        else{
            elevator.context.setState(new MvUp());
            elevator.context.next(elevator);
        }
    }

    @Override
    public String getState() {
        return "Moving Up";
    }
}