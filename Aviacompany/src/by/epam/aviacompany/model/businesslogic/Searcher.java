package by.epam.aviacompany.model.businesslogic;


import by.epam.aviacompany.model.domain.Plane;


import java.util.ArrayList;

/**
 * Searching the plane corresponding to specified range
 */
public class Searcher {
    public Plane searchFlightRangePlane(ArrayList<Plane> planeList, double begin, double end){

        if((end - begin) > 0 && begin > 0 && end > 0) {
            for (int i = 0; i < planeList.size(); i++) {
                if (planeList.get(i).getFuelRate() >= begin && planeList.get(i).getFuelRate() <= end) {
                    return planeList.get(i);
                }
            }
        }
        else {
            return null;
        }
        return null;
    }
}
