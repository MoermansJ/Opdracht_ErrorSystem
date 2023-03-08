package be.intecbrussel.DO_NOT_TOUCH;

import java.util.Random;

public class SystemFlow implements Runnable {
    @Override
    public void run() {
        while(true) {
            try {
                Thread.sleep(new Random().nextInt(2000)+1000);

                ErrorSystem.newError(ErrorGenerator.generateError());

                int random = new Random().nextInt(2);
                if (random == 1) {
                    System.err.println(ErrorSystem.getUnhandledErrorCount() + " errors have been found");
                    break;
                }

            } catch (InterruptedException e) {

            }
        }
    }
}
