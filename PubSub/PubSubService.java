import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class PubSubService {
    private static final PubSubService instance = new PubSubService();
    private final ExecutorService executorService;
    private final Map<String, Topic> topicRegistry;

    private PubSubService(){
        this.topicRegistry = new HashMap<>();
        this.executorService = Executors.newCachedThreadPool(); // Example thread pool size
    }

    public static PubSubService getInstance() {
        return instance;
    }

    public void createTopic(String topicName){
        topicRegistry.putIfAbsent(topicName, new Topic(topicName, executorService));
        System.out.println("Topic created: " + topicName);
    }

    public void subscribe(String topicName, Subscriber subscriber){
        Topic topic  = topicRegistry.get(topicName);
        if(topic==null){
            throw new IllegalArgumentException("Topic does not exist: " + topicName);
        }

        topic.addSubscriber(subscriber);
        System.out.println("Subscriber " + subscriber.getId() + " added to topic: " + topicName);
    }

    public void unsubscribe(String topicName, Subscriber subscriber){
        Topic topic  = topicRegistry.get(topicName);
        if(topic == null){
            throw new IllegalArgumentException("Topic does not exist: " + topicName);
        }

        topic.removeSubscriber(subscriber);
        System.out.println("Subscriber " + subscriber.getId() + " removed from topic: " + topicName);
    }

    public void publish(String topicName, Message message){
        Topic topic =  topicRegistry.get(topicName);
        if(topic == null){
            throw new IllegalArgumentException("Topic does not exist: " + topicName);
        }
        topic.broadcast(message);
    }

    public void shutdown() {
        executorService.shutdown();
        System.out.println("PubSubService shutdown initiated.");
    }

}

