package be.intecbrussel.DO_NOT_TOUCH;

import java.util.ArrayList;
import java.util.List;

public class InternalApp {
    public void start() {
        System.out.println("RUNNING VERY REALISTIC COMPANY SOFTWARE.");

        List<Thread> threadList = new ArrayList<>();
        for (int i = 0; i < 6; i++) {
            Thread thread = new Thread(new SystemFlow());
            threadList.add(thread);
            thread.start();
        }

        for (Thread thread : threadList) {
            try {
                thread.join();
            } catch (InterruptedException e) {
            }
        }

        System.out.println("VERY REALISTIC COMPANY SOFTWARE IS DONE COLLECTING ERRORS.");
    }
}
