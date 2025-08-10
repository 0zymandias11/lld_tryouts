import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ExecutorService;

public class Topic {
    String name;
    Set<Subscriber> subscribers;
    ExecutorService executorService;
    public Topic(String name, ExecutorService deliveryExecutor) {
        this.name = name;
        this.subscribers = new HashSet<>();
        this.executorService = deliveryExecutor;
    }

    public String getName(){
        return this.name;
    }

    public void addSubscriber(Subscriber subscriber) {
        this.subscribers.add(subscriber);
    }

    public void removeSubscriber(Subscriber subscriber) {
        this.subscribers.remove(subscriber);
    }

    public void broadcast(Message message){
        for(Subscriber subscriber : subscribers) {
            executorService.submit(()->{
                try{
                    subscriber.onMessage(message);
                    System.out.println("Delivered message to subscriber: " + subscriber.getId());
                }catch(Exception w){
                    System.out.println("Error while delivering message to subscriber: " + subscriber.getId());
                }
            });
        }
    }
}
