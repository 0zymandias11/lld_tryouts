package Request;

public class Request {
    String requestId;
    int floor;
    public String requestType;
    String direction;
    public Request(String requestId, int floor) {
        this.requestId = requestId;
        this.floor = floor;
        this.requestType = "external"; // Default request type
        this.direction = "";
    }

    public String getRequestId() {
        return requestId;
    }

    public int getFloor() {
        return floor;
    }
}
