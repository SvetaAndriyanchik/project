package by.epam.aviacompany.model.businesslogic;


import by.epam.aviacompany.model.domain.CargoPlane;
import by.epam.aviacompany.model.domain.PassengerPlane;
import by.epam.aviacompany.model.domain.Plane;

import java.util.ArrayList;

public class Creator {

    /**
     * Filling data into the classes fields
     */

    private static int id = 0;

    public static int idGenerate(){
        id++;
        return id;
    }

    /**
     * Filling data into ArrayList of cargo planes
     * @return ArrayList of cargo planes
     */
    public ArrayList<CargoPlane> createCargoPlaneList(){
        ArrayList<CargoPlane> planeList = new ArrayList<CargoPlane>();
        CargoPlane planeOne = new CargoPlane("c1", 1200, 12, idGenerate(), 280, "boxes");
        CargoPlane planeTwo = new CargoPlane("c2", 1900, 15, idGenerate(), 290, "irons");
        CargoPlane planeThree = new CargoPlane("c3", 1100, 13, idGenerate(), 310, "wood");
        planeList.add(0, planeOne);
        planeList.add(1, planeTwo);
        planeList.add(2, planeThree);
        return planeList;
    }

    /**
     * @return ArrayList of passenger planes
     */
    public ArrayList<PassengerPlane> createPassengerPlaneList(){
        ArrayList<PassengerPlane> planeList = new ArrayList<PassengerPlane>();
        PassengerPlane planeOne = new PassengerPlane("p1", 3900, 14, idGenerate(), 226, false);
        PassengerPlane planeTwo = new PassengerPlane("p2", 9020, 19, idGenerate(), 330, true);
        PassengerPlane planeThree = new PassengerPlane("p3", 7300, 14.8, idGenerate(), 226, false);
        planeList.add(0, planeOne);
        planeList.add(1, planeTwo);
        planeList.add(2, planeThree);
        return planeList;
    }

    /**
     * Splitting cargo- and passenger planes into one list
     * @param cargoList ArrayList of CargoPlane objects
     * @param passengerList ArrayList of PassengerPlane objects
     * @return list of all planes in aviacompany
     */
    public ArrayList<Plane> createAviacompany(ArrayList<CargoPlane> cargoList, ArrayList<PassengerPlane> passengerList){
        ArrayList<Plane> planeArrayList = new ArrayList<Plane>();
        if(cargoList != null && passengerList != null){
            for(int i = 0; i < cargoList.size(); i++){
                planeArrayList.add(i, cargoList.get(i));
            }
            for(int i = 0; i < passengerList.size(); i++){
                planeArrayList.add(i, passengerList.get(i));
            }
            return planeArrayList;
        } else return null;
    }



}
