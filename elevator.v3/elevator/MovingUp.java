package elevator;

import java.util.Optional;

public final class MovingUp implements ElevatorState {
    @Override public void next(Elevator e) throws InterruptedException {
        // Next target strictly above current
        Optional<Integer> next = e.nextAbove();
        if (next.isPresent()) {
            int target = next.get();
            e.setDirection(Direction.UP);
            e.moveTo(target);
            e.arriveAt(target);
            e.openDoor();
            return; // one step; scheduler/driver will call again
        }
        // No more above; reverse if any below, else idle
        if (!e.getDownStops().isEmpty()) {
            e.setDirection(Direction.DOWN);
            e.getContext().setState(new MovingDown());
        } else {
            e.stopIdle();
            e.getContext().setState(new Idle());
        }
    }

    @Override public String getState() { return "Moving Up"; }
}