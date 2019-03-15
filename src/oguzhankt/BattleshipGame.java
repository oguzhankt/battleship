package oguzhankt;
import java.util.*;
/**
 * Created by Oğuzhan on 6.2.2017.
 */
public class BattleshipGame {
    private int numOfGuesses = 0;
    private GameHelper helper = new GameHelper();
    private ArrayList<Battleship> battleshipList = new ArrayList<Battleship>();

    void setUpGame(){
        Battleship ship1 = new Battleship();
        ship1.setName("USS Queen");
        Battleship ship2 = new Battleship();
        ship2.setName("The Flying Jesus");
        Battleship ship3 = new Battleship();
        ship3.setName("The Middleman");

        // Initializing ships array
        battleshipList.add(ship1);
        battleshipList.add(ship2);
        battleshipList.add(ship3);

        System.out.println("Your goal is to sink three battleships.");
        System.out.println("USS Queen, The Flying Jesus, The Middleman");
        System.out.println("Try to sink them all in he fewest number of guesses");

        for(Battleship battleshipToSet : battleshipList){
            ArrayList<String> newLocation = helper.placeBattleship(3);
            battleshipToSet.setLocationCells(newLocation);
        }

    }

    public void startGame(){
        while(!battleshipList.isEmpty()){
            String userGuess = helper.getUserInput("Enter a guess");
            checkUserGuess(userGuess);
        }

        finishGame();
    }

    private void checkUserGuess(String userGuess){
        numOfGuesses++;
        String result = "missed";
        for(Battleship battleshipToTest : battleshipList){
            result = battleshipToTest.checkYourself(userGuess);

            if(result.equals("hit")){

            }
            if(result.equals("killed")){
                battleshipList.remove(battleshipToTest);
            }
            System.out.println("You " + result + " " + battleshipToTest.getName());
        }

    }

    private void finishGame(){
        System.out.println("All the battleships are dead!");
        if(numOfGuesses <= 18){
            System.out.println("It took you only " + numOfGuesses + " guesses.");
        }
        else{
            System.out.println("It took you long enough.");
            System.out.println(numOfGuesses + " guesses.");
            System.out.println("Fish are dancing with your options.");
        }
    }
}
