package by.epam.aviacompany.model.businesslogic;

import by.epam.aviacompany.model.domain.CargoPlane;
import by.epam.aviacompany.model.domain.PassengerPlane;

import java.util.ArrayList;

public class Calculator {
    /**
     *
     * @param planeList list of passenger planes in the aviacompany
     * @return total capacity of seats in the aviacompany
     */
    public int calculateTotalSeats(ArrayList<PassengerPlane> planeList){


        int totalCapacity = 0;
        for(int i = 0; i < planeList.size(); i++){
            totalCapacity += planeList.get(i).getSeatsCapacity();
        }
        return totalCapacity;
    }

    /**
     *
     * @param planeList list of cargo planes in the aviacompany
     * @return total freight of all planes in the company
     */

    public int calculateTotalWeightCapacity(ArrayList<CargoPlane> planeList){
        int totalWeight = 0;
        for(int i = 0; i < planeList.size(); i++){
            totalWeight += planeList.get(i).getWeightCapacity();
        }
        return totalWeight;
    }
}
