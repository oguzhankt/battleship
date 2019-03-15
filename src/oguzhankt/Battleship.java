package oguzhankt;

import java.util.*;

/**
 * Created by Oğuzhan on 7.2.2017.
 */
public class Battleship {
    private String name;
    private ArrayList<String> locationCells;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<String> getLocationCells() {
        return locationCells;
    }

    public void setLocationCells(ArrayList<String> locationCells) {
        this.locationCells = locationCells;
    }

    public String checkYourself(String userInput){
        String result = "miss";
        int index = locationCells.indexOf(userInput);

        if(index >= 0){
            locationCells.remove(index);
            if(locationCells.isEmpty()){
                result = "kill";
                System.out.println("You sunk " + name + " !");
            }
            else{
                result = "hit";
            }
        }

        System.out.println(result);
        return result;

    }
}
