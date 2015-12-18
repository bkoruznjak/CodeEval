/*
 * This is a template file that you can use to build your challenges on
 */
package codeeval;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author bkoruznjak
 */
public class Main {

    private static File challengePath;
    //change this to your test file path
    private static final String TEST_FILE_PATH="src/input/testing";
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
}

/**
 * Class that extends the Template and overrides the doWork method to fit your 
 * challenge needs
 * @author bkoruznjak
 */
class ChallengeSolver extends Template{

    @Override
    public void doWork(String textLine) {
        System.out.println(textLine);
    }
}

class Template{
    
    public void solveChallenge(File challenge) {
        try(BufferedReader breader = new BufferedReader(new FileReader(challenge))) {
            String textLine = null;
            while ((textLine = breader.readLine())!= null) {
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
