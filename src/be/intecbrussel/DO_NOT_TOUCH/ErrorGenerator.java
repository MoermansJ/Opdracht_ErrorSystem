package be.intecbrussel.DO_NOT_TOUCH;

import java.util.Random;

public class ErrorGenerator {
    private static String[] adj = "dramatically desperately horribly majestically succesfully rapidly stupidly".split(" ");

    public static String generateError() {
        return String.format(
                "%s has failed %s! Message: %s %s is %s %s!",
                Dictionary.getRandomWord(),
                adj[new Random().nextInt(adj.length)],
                Dictionary.getRandomWord(),
                Dictionary.getRandomWord(),
                Dictionary.getRandomWord(),
                Dictionary.getRandomWord()
                );
    }
}
