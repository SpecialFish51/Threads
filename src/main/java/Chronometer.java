import java.util.List;

class Chronometer {
    public int time = 0;

    public void countTime(List<Messenger> messengers, int period) {
        for (int i = 0; i < period; i++) {
            synchronized (this) {
                time += 1;
                System.out.println(time);
                if (i == period - 1) Messenger.finish = true;
                messengers.forEach(messenger -> {
                    messenger.flag = false;
                    this.notify();
                });
            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
