import java.util.concurrent.BlockingQueue;

public class Consumer implements Runnable {
    BlockingQueue<String> queue;
    int count = 0;

    public Consumer(BlockingQueue<String> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        try {
            while (true) {
                String value = queue.take();
                count++;
            }
        } catch (InterruptedException e) {
            System.out.println("Остановка");
        }
    }
}
