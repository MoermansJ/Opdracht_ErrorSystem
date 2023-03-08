package be.intecbrussel.DO_NOT_TOUCH;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

public class ErrorSystem {
    private static Queue<String> unHandledErrors = new ConcurrentLinkedQueue<>();
    private static Queue<String> handledErrors = new ConcurrentLinkedQueue<>();

    public static void newError(String error) {
        unHandledErrors.add(error);
    }

    public static void handledError(String error, Object level) {
        handledErrors.add(error);
    }

    public static String pollError() {
        return unHandledErrors.poll();
    }


    public static int getUnhandledErrorCount() {
        return unHandledErrors.size();
    }

    public static Queue<String> getHandledErrors() {
        return handledErrors;
    }

    public static Queue<String> getUnHandledErrors() {
        return unHandledErrors;
    }
}
