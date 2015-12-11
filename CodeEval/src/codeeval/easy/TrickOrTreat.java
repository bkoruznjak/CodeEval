/**
 * Everyone knows what Halloween is and how children love it. Children in
 * costumes travel from house to house asking for treats with a phrase
 * "Trick or treat". After that, they divide the treats equally among all.
 * This year, they collected tons of candies, and need your help to share
 * everything equally.
 * You know that children receive different number of candies depending on
 * their costume: vampire gets 3 candies from one house, zombie – 4 candies,
 * and witch – 5 candies.
 * That is, three children in three different costumes get 3+4+5=12 candies
 * from one house.
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
public class TrickOrTreat {

    //change to true before commit on CodeEval
    private static final boolean TESTING = true;
    private final int VAMPIRE = 3;
    private final int ZOMBIE = 4;
    private final int WITCH = 5;

    public static void main(String[] args) {
        File inputFile = null;
        if (TESTING) {
            inputFile = new File("src/input/trickOrTreat");
        } else {
            inputFile = new File(args[0]);
        }

        new TrickOrTreat().doWork(inputFile);
    }

    public void doWork(File file) {
        try (BufferedReader breader = new BufferedReader(new FileReader(file))) {
            String line = null;
            while ((line = breader.readLine()) != null) {
                System.out.println(getIndividualNumberOfCandies(line));
            }
        } catch (IOException ioEx) {
            ioEx.printStackTrace();
        }
    }

    private int getIndividualNumberOfCandies(String line) {
        String[] costumeData = line.split("[,:][\\W]");
        int totalCandies = 0;
        int totalNumOfChildren = 0;
        for (int i = 0; i < costumeData.length; i += 2) {
            switch (costumeData[i]) {
                case "Vampires":
                    totalCandies += Integer.parseInt(costumeData[i + 1]) * VAMPIRE;
                    totalNumOfChildren +=Integer.parseInt(costumeData[i + 1]);
                    break;
                case "Zombies":
                    totalCandies += Integer.parseInt(costumeData[i + 1]) * ZOMBIE;
                    totalNumOfChildren +=Integer.parseInt(costumeData[i + 1]);
                    break;
                case "Witches":
                    totalCandies += Integer.parseInt(costumeData[i + 1]) * WITCH;
                    totalNumOfChildren +=Integer.parseInt(costumeData[i + 1]);
                    break;
                case "Houses":
                    totalCandies = totalCandies * Integer.parseInt(costumeData[i + 1]);
                    break;
                default:
                    throw new IllegalArgumentException();
            }
        }
        return totalCandies/totalNumOfChildren;
    }
}
