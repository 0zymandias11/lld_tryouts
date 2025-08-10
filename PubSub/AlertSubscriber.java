public class AlertSubscriber implements Subscriber{
    private final String id;

    public AlertSubscriber(String id) {
        this.id = id;
    }
    @Override
    public String getId() {
        return this.id;
    }
    @Override
    public void onMessage(Message message) {
        System.out.println("AlertSubscriber " + id + " received message: " + message.getPayload());
    } 
}
