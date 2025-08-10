package elevator;


public final class Idle implements ElevatorState {
    public void next(Elevator e) {
        // Choose an initial direction/target if any requests exist
        boolean hasUp = !e.getUpStops().isEmpty();
        boolean hasDown = !e.getDownStops().isEmpty();
        if (!hasUp && !hasDown) {
            e.stopIdle();
            return; // nothing to do
        }
        // Pick closer first target
        Integer upFirst = hasUp ? e.getUpStops().first() : null;      // smallest above
        Integer downFirst = hasDown ? e.getDownStops().first() : null; // highest below
        if (upFirst == null) {
            e.setDirection(Direction.DOWN);
            e.getContext().setState(new MovingDown());
        } else if (downFirst == null) {
            e.setDirection(Direction.UP);
            e.getContext().setState(new MovingUp());
        } else {
            int du = Math.abs(e.getCurrentFloor() - upFirst);
            int dd = Math.abs(e.getCurrentFloor() - downFirst);
            if (du <= dd) { e.setDirection(Direction.UP); e.getContext().setState(new MovingUp()); }
            else { e.setDirection(Direction.DOWN); e.getContext().setState(new MovingDown()); }
        }
    }

    @Override public String getState() { return "Idle"; }
}