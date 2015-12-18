/*
In many teams, there is a person who tests a project, finds bugs and errors, 
and prioritizes them. Now, you have the unique opportunity to try yourself as 
a tester and test a product. Here, you have two strings - the first one is 
provided by developers, and the second one is mentioned in design. You have to 
find and count the number of bugs, and also prioritize them for fixing using 
the following statuses: 'Low', 'Medium', 'High', 'Critical' or 'Done'.
 */
package codeeval.easy;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author bkoruznjak
 */
public class Testing {

    private static File challengePath;
    //change this to your test file path
    private static final String TEST_FILE_PATH = "src/input/testing";

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        if (args.length != 0) {
            challengePath = new File(args[0]);
        } else {
            challengePath = new File(TEST_FILE_PATH);
        }
        new ChallengeSolver().solveChallenge(challengePath);
    }

    /**
     * Class that extends the Template and overrides the doWork method to fit
     * your challenge needs
     *
     * @author bkoruznjak
     */
    private static class ChallengeSolver extends Template {

        /*
    'Low' - 2 or fewer bugs; 
    'Medium' - 4 or fewer bugs; 
    'High' - 6 or fewer bugs; 
    'Critical' - more than 6 bugs; 
    'Done' - all is done; 
         */
        @Override
        public void doWork(String textLine) {
            String[] data = textLine.split(" \\| ");
            int errorCounter = 0;
            for (int index = 0; index < data[0].length(); index++) {
                if (data[0].charAt(index) != data[1].charAt(index)) {
                    errorCounter++;
                }
            }
            if (errorCounter == 0) {
                System.out.println("Done");
            } else if (errorCounter <= 2) {
                System.out.println("Low");
            } else if (errorCounter <= 4) {
                System.out.println("Medium");
            } else if (errorCounter <= 6) {
                System.out.println("High");
            } else if (errorCounter > 6) {
                System.out.println("Critical");
            }
        }
    }

    private static class Template {

        public void solveChallenge(File challenge) {
            try (BufferedReader breader = new BufferedReader(new FileReader(challenge))) {
                String textLine = null;
                while ((textLine = breader.readLine()) != null) {
                    doWork(textLine);
                }
            } catch (IOException ioEx) {
                ioEx.printStackTrace();
            }
        }

        //Override this method in challenge solver to fit your challenge needs
        public void doWork(String textLine) {
            System.out.println(textLine);
        }
    }
}
