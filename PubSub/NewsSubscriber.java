public class NewsSubscriber implements Subscriber {
    private final String id;
    public NewsSubscriber(String id) {
        this.id = id;
    }

    @Override
    public String getId(){
        return this.id;
    }

    @Override
    public void onMessage(Message message) {
        System.out.println("NewsSubscriber " + id + " received message: " + message.getPayload());
    }
}
