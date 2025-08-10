package elevator;

public class DefaultElevatorCreator implements ElevatorCreator {
    @Override public Elevator create(int id) { return new Elevator(id); }
}