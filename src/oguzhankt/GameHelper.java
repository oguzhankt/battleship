package oguzhankt;

import java.io.*;
import java.util.*;
/**
 * Created by Oğuzhan on 6.2.2017.
 */
public class GameHelper {
    private static final String alphabet = "abcdefg";
    private int gridLenght = 7;
    private int gridSize = 49;
    private int[] grid = new int[gridSize];
    private int shipCount = 0;

    public String getUserInput(String prompt){
        String inputLine = null;
        System.out.print(prompt + " ");
        try{
            BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
            inputLine = in.readLine();
            if(inputLine.length() == 0) return null;
        } catch (IOException e){
            System.out.println("IOException" + e);
        }
        return inputLine.toLowerCase();
    }

    public ArrayList<String> placeBattleship(int shipSize){
        ArrayList<String> alphaCells = new ArrayList<String>();
        String[] alphaCoords = new String[shipSize];
        String temp = null;
        int[] coords = new int[shipSize];
        int attempts = 0;
        boolean success = false;
        int location = 0;

        shipCount++;
        int incr = 1;
        if((shipCount % 2) == 1){
            incr = gridLenght;
        }
        while(!success & attempts++ < 200){
            location = (int)(Math.random()*gridSize);
            int x = 0;
            success = true;
            while(success && x < shipSize){
                if(grid[location] == 0){
                    coords[x++] = location;
                    location += incr;
                    if(location >= gridSize){
                        success = false;
                    }
                    if(x>0 && (location % gridLenght == 0)){
                        success = false;
                    }
                }
                else{
                    success = false;
                }
            }
        }

        int x = 0;
        int row = 0;
        int column = 0;

        while( x < shipSize ){
            grid[coords[x]] = 1;
            row = (int)(coords[x] / gridLenght);
            column = coords[x] % gridLenght;
            temp = String.valueOf(alphabet.charAt(column));

            alphaCells.add(temp.concat(Integer.toString(row)));
            x++;
        }

        return alphaCells;
    }
}
