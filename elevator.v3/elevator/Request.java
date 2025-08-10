package elevator;

import java.util.Objects;

public final class Request {
    private final String id;
    private final int floor;
    private final CallType type;

    public Request(String id, int floor, CallType type) {
        this.id = Objects.requireNonNull(id);
        this.floor = floor;
        this.type = Objects.requireNonNull(type);
    }
    public String getId() { return id; }
    public int getFloor() { return floor; }
    public CallType getType() { return type; }
}