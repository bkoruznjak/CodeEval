/*
You must have heard about pirates, their customs, pirates code, and the 
“black spot”. If a pirate is presented with a “black spot”, he is officially 
pronounced guilty, meaning he will soon be expulsed from the pirate brotherhood 
or even be dead. We don’t have as strict rules as pirates have, and a person 
who receives a black spot simply leaves the game. 
For example, we have a list of three players: John, Tom, Mary, and a number 5. 
Starting with the first player (in our case, it’s John), we start to count all 
players: John – 1, Tom – 2, Mary – 3, and then again starting from the first 
one John – 4, Tom – 5. As Tom gets number 5, he should leave. Now, we have 
John and Mary and start counting again. John gets number 5, so he leaves. 
Thus, the winner is Mary.
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
public class BlackCard {

    private static File challengePath;
    //change this to your test file path
    private static final String TEST_FILE_PATH = "src/input/blackCard";

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
            System.out.println(textLine);
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
