package by.epam.aviacompany.model.businesslogic;


import by.epam.aviacompany.model.domain.Plane;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class SortManager {

    /**
     * Comparator
     */
    static Comparator<Plane> snorderer = new Comparator<Plane>() {

        public int compare(Plane o1, Plane o2) {
            return o1.getFlightRange() - (o2.getFlightRange());
        }
    };

    /**
     * @param planeList
     * @return sorted planeList
     */
    public ArrayList<Plane> sortByFlightRange(ArrayList<Plane> planeList){
        Collections.sort(planeList,snorderer );
        return planeList;
    }
}