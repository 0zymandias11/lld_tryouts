package states;

import ElevatorFactory.Elevator;

public class Idle implements ElevatorState {
    @Override
    public void next(Elevator elevator) {
        int currentFloor = elevator.currentFloor;

        if(elevator.getUpRequests().isEmpty() && elevator.getDownRequests().isEmpty()) {
            elevator.stop();
            System.out.println("Elevator " + elevator.getElevatorId() + " is idle at floor " + currentFloor);
            return;
        }

        if(Math.abs(currentFloor - elevator.getDownRequests().last().getFloor()) 
        < Math.abs(currentFloor - elevator.getUpRequests().first().getFloor())) {
            elevator.context.setState(new MvDwn());
        } 
        else 
            elevator.context.setState(new MvUp());

        elevator.context.next(elevator);
    }   

    @Override
    public String getState() {
        return "Idle";
    }
}
 