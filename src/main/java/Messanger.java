class Messenger implements Runnable {
    final private int time;
    final public Chronometer ch;
    public static boolean finish = false;
    public boolean flag = true;

    Messenger(int time, Chronometer ch) {
        this.time = time;
        this.ch = ch;
    }

    @Override
    public void run() {
        waitForTime();
        System.out.println("The end");
    }

    private void waitForTime() {
        while (true) {
            synchronized (ch) {
                try {
                    while (flag)
                        ch.wait();
                    if (finish) return;
                    if (ch.time % this.time == 0) {
                        System.out.println("Thread " + this.time);
                    }
                    flag = true;
                } catch (InterruptedException e) {
                }
            }
        }
    }
}
