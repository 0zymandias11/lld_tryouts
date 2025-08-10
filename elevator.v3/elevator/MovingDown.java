package elevator;

import java.util.Optional;

public final class MovingDown implements ElevatorState {
    @Override public void next(Elevator e) throws InterruptedException {
        // Highest target strictly below current
        Optional<Integer> next = e.nextBelow();
        if (next.isPresent()) {
            int target = next.get();
            e.setDirection(Direction.DOWN);
            e.moveTo(target);
            e.arriveAt(target);
            e.openDoor();
            return; // one step
        }
        // No more below; reverse if any above, else idle
        if (!e.getUpStops().isEmpty()) {
            e.setDirection(Direction.UP);
            e.getContext().setState(new MovingUp());
        } else {
            e.stopIdle();
            e.getContext().setState(new Idle());
        }
    }

    @Override public String getState() { return "Moving Down"; }
}