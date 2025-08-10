package elevator;

import java.util.HashMap;
import java.util.Map;

public final class ElevatorDriver {
    private static volatile ElevatorDriver INSTANCE;

    private final HashMap<Integer, Elevator> elevators = new HashMap<>();
    private final ElevatorStrategy strategy = new ElevatorStrategyImpl();

    private ElevatorDriver(int count, ElevatorCreator creator) {
        for (int i = 0; i < count; i++) {
            elevators.put(i, creator.create(i));
        }
    }

    public static ElevatorDriver getInstance(int count, ElevatorCreator creator) {
        if (INSTANCE == null) {
            synchronized (ElevatorDriver.class) {
                if (INSTANCE == null) INSTANCE = new ElevatorDriver(count, creator);
            }
        }
        return INSTANCE;
    }

    public void handle(Request r) {
        Elevator e = strategy.select(new HashMap<>(elevators), r);
        if (e == null) {
            System.out.println("No elevator available for request " + r.getId());
            return;
        }
        if (r.getFloor() == e.getCurrentFloor()) {
            try { e.openDoor(); } catch (InterruptedException ignored) {}
            return;
        }
        e.addStop(r.getFloor());
    }

    /** Advance each elevator one step (call periodically). */
    public void tickAll() {
        for (Map.Entry<Integer, Elevator> entry : elevators.entrySet()) {
            Elevator e = entry.getValue();
            try {
                e.getContext().next(e);
            } catch (InterruptedException ignored) { }
        }
    }

    public Map<Integer, Elevator> getElevators() { return elevators; }
}