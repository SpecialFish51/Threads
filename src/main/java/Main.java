import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.function.Consumer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {

        Chronometer chronometer = new Chronometer();

        List<Messenger> messengers = new ArrayList<Messenger>();

        messengers.add(new Messenger(1, chronometer));
        messengers.add(new Messenger(5, chronometer));
        messengers.add(new Messenger(7, chronometer));

        messengers.forEach(messenger -> {
            new Thread(messenger).start();
        });

        chronometer.countTime(messengers,20);
        //Не удалось заставить работать =,(
       /* BlockingQueue<String> queue = new LinkedBlockingQueue<>(2);
        String filePath = new File("resources","Voina_i_mir").getAbsolutePath();
        Consumer consumer = new Consumer() {
            @Override
            public void accept(Object o) {

            }
        };
        Thread consumerThread = new Thread(consumer);

        Thread producerThread = new Thread(()->{
            Scanner scanner = null;
            String foundWord;
            try{
                scanner = new Scanner(new FileReader(filePath));

        }catch (FileNotFoundException e) {
                e.printStackTrace();
            }

            while ((scanner.hasNextLine())) {
                String line = scanner.nextLine();
                Pattern pattern = Pattern.compile("страдан", Pattern.CASE_INSENSITIVE);
                Matcher matcher = pattern.matcher(line);

                while (matcher.find()) {
                    foundWord = matcher.group();
                    System.out.println("Producer" + foundWord);
                    try {
                        queue.put(foundWord);
                    }catch (InterruptedException e) {
                        System.out.println("Ошибка".concat(e.getMessage()));
                    }
                }


            }
            consumerThread.interrupt();
        });
        producerThread.start();
        consumerThread.start();
        try {
            producerThread.join();
            consumerThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();*/
        }
        /* Thread thread1 = new Thread() {
            @Override
            public void run() {
                try {
                    sleep(5000);
                    System.out.println("5 seconds");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        Thread thread2 = new Thread() {
            @Override
            public void run() {
                try {
                    sleep(7000);
                    System.out.println("7 seconds");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        };

        thread2.start();
        thread1.start();
        new Thread(new TenSecondsWaiter()).start(); ;
        System.out.println("Main thread");*/
    }
