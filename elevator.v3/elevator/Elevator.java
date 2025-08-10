package elevator;

import java.util.Comparator;
import java.util.NavigableSet;
import java.util.Optional;
import java.util.TreeSet;

public class Elevator {
    private final int elevatorId;
    private final NavigableSet<Integer> upStops = new TreeSet<>();                     // ascending
    private final NavigableSet<Integer> downStops = new TreeSet<>(Comparator.reverseOrder()); // descending
    private final ElevatorContext context = new ElevatorContext();

    private int currentFloor = 0;
    private Direction direction = Direction.IDLE;

    public Elevator(int id) { this.elevatorId = id; }

    // ---- Accessors
    public int getElevatorId() { return elevatorId; }
    public int getCurrentFloor() { return currentFloor; }
    public Direction getDirection() { return direction; }
    public void setDirection(Direction d) { this.direction = d; }
    public ElevatorContext getContext() { return context; }

    // Package-private getters for states/driver (read-only usage expected)
    NavigableSet<Integer> getUpStops() { return upStops; }
    NavigableSet<Integer> getDownStops() { return downStops; }

    // ---- Stop management (LOOK queues)
    public void addStop(int floor) {
        if (floor == currentFloor) return; // serve immediately by opening door elsewhere if needed
        if (floor > currentFloor) upStops.add(floor); else downStops.add(floor);
    }

    public void arriveAt(int floor) {
        this.currentFloor = floor;
        upStops.remove(floor);
        downStops.remove(floor);
    }

    public Optional<Integer> nextAbove() { return Optional.ofNullable(upStops.higher(currentFloor)); }
    public Optional<Integer> nextBelow() {
        // downStops is descending. First element is the highest value; ensure it's below current.
        return downStops.isEmpty() ? Optional.empty()
                : Optional.of(downStops.first()).filter(f -> f < currentFloor);
    }

    // ---- Movement + door (simulation)
    public void moveTo(int target) throws InterruptedException {
        if (target == currentFloor) return;
        if (target > currentFloor) setDirection(Direction.UP); else setDirection(Direction.DOWN);
        System.out.printf("Elevator %d moving %s from %d to %d%n", elevatorId,
                direction == Direction.UP ? "UP" : "DOWN", currentFloor, target);
        // Simple simulation delay
        Thread.sleep(150);
    }

    public void openDoor() throws InterruptedException {
        System.out.printf("Elevator %d opening door at floor %d%n", elevatorId, currentFloor);
        Thread.sleep(80);
        System.out.printf("Elevator %d closing door at floor %d%n", elevatorId, currentFloor);
        Thread.sleep(50);
    }

    public void stopIdle() { setDirection(Direction.IDLE); }
}