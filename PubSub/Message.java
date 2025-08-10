import java.time.Instant;

public class Message {
    String payload;
    Instant timestamp;  
    public Message(String payload){
        this.payload = payload;
        this.timestamp = Instant.now();
    }

    public String getPayload(){
        return this.payload;
    }

    @Override
    public String toString() {
        return "Message{" +
                "payload='" + payload + '\'' +
                ", timestamp=" + timestamp +
                '}';
    }
}
