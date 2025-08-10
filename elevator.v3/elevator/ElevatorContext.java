package elevator;

public final class ElevatorContext {
    private ElevatorState state;

    public ElevatorContext() { this.state = new Idle(); }
    public ElevatorState getState() { return state; }
    public void setState(ElevatorState s) { this.state = s; }

    public void next(Elevator e) throws InterruptedException { state.next(e); }
}