package be.intecbrussel;

import be.intecbrussel.DO_NOT_TOUCH.ErrorSystem;
import be.intecbrussel.DO_NOT_TOUCH.InternalApp;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        new InternalApp().start(); // DO NOT TOUCH

        // Hieronder plaats je de code.
        // Met de methode getError(), krijg je een error,
        // Met de methode fixError(String error, level), kan je de behandelde error opslaan.
        //---------------------------------------------------


        Scanner scanner = new Scanner(System.in);

        while (getError() != null){
            String currentError = getError();
        System.out.println("CURRENT ERROR: " + currentError);
        System.out.print("Enter current error level: (LOW/MEDIUM/HIGH/NO_ERROR) ");
        String userInput = scanner.nextLine();

        PriorityLevel currentPL = PriorityLevel.NO_ERROR;

        switch (userInput) {
            case "LOW":
                currentPL = PriorityLevel.LOW;
                break;
            case "MEDIUM":
                currentPL = PriorityLevel.MEDIUM;
                break;
            case "HIGH":
                currentPL = PriorityLevel.HIGH;
                break;
        }

        if (currentPL != PriorityLevel.NO_ERROR) {
            fixError((currentPL.name()) + " - " + currentError, currentPL);
        }
    }


        //---------------------------------------------------

        printOverview();
    }

    // ---------------------------
    // DO NOT TOUCH ANYTHING BELOW
    // ---------------------------
    private static String getError() {
        return ErrorSystem.pollError();
    }

    private static void fixError(String error, Object level) {
        ErrorSystem.handledError(error, level);
    }

    private static void printOverview(){
        System.out.println("---------------------------\n");
        System.out.println("       HANDLED ERROR       \n");
        System.out.println("---------------------------\n");

        for (String handledError : ErrorSystem.getHandledErrors()) {
            System.out.println(handledError);
        }


        System.out.println("---------------------------\n");
        System.out.println("      UNHANDLED ERROR      \n");
        System.out.println("---------------------------\n");

        for (String unHandledError : ErrorSystem.getUnHandledErrors()) {
            System.out.println(unHandledError);
        }
    }
}