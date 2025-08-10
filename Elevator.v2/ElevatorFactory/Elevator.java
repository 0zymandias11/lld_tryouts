package ElevatorFactory;

import java.util.TreeSet;

import Request.Request;
import states.ElevatorContext;

public class Elevator implements ElevatorFactory {
    int elevator_id;
    TreeSet<Request> upRequests;
    TreeSet<Request> downRequests;
    public int currentFloor;
    public ElevatorContext context;
    public Elevator(int id){
        this.elevator_id = id;
        this.upRequests = new TreeSet<>();
        this.downRequests = new TreeSet<Request>((a,b)->b.getFloor() - a.getFloor());  
        this.context = new ElevatorContext();
        this.currentFloor = 0;
    }

    public int getElevatorId() {    
        return elevator_id;
    }

    public TreeSet<Request> getUpRequests() {
        return upRequests;
    }
    public TreeSet<Request> getDownRequests() {
        return downRequests;
    }
    public void addUpRequest(Request request) {
        upRequests.add(request);
    }   
    public void addDownRequest(Request request) {
        downRequests.add(request);
    }
    public void removeUpRequest(Request request) {
        upRequests.remove(request);
    }
    public void removeDownRequest(Request request) {
        downRequests.remove(request);
    }

    @Override
    public void moveUp() {
        try{
            this.currentFloor+=1;
            System.out.println("Elevator " + elevator_id + " moving up to floor " + currentFloor);  

            // Simulate time taken to move up
            Thread.sleep(1000);
        }catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    @Override
    public void moveDown(){
        try {
            this.currentFloor--;
            System.out.println("Elevator " + elevator_id + " moving down to floor " + currentFloor);
            // Simulate time taken to move down
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    @Override
    public void stop() {
        //Stopping Elevator for a second
        try {
            System.out.println("Elevator " + elevator_id + " has stopped at floor " + currentFloor);
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    @Override
    public int getCurrentFloor(){
        return this.currentFloor;
    }
    
}
