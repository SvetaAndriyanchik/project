package by.epam.aviacompany.model.businesslogic;


import by.epam.aviacompany.model.domain.CargoPlane;
import by.epam.aviacompany.model.domain.PassengerPlane;
import by.epam.aviacompany.model.domain.Plane;
import org.apache.log4j.Logger;


import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class ResultPrinter {
    /**
     *
     * Txt file output
     */

    private static Logger LOG = Logger.getLogger(ResultPrinter.class);

    /**
     * Writing report about all company's planes
     *
     * @param filename
     * @param cargoPlanes ArrayList of cargoPlane objects
     * @param passengerPlanes ArrayList of passengerPlane objects
     */
    public static void printFullPlaneList(String filename, ArrayList<CargoPlane> cargoPlanes,
                                          ArrayList<PassengerPlane> passengerPlanes) {
        File file = new File(filename);
        try {
            if(!file.exists()){
                file.createNewFile();
            }
            PrintWriter out = new PrintWriter(file.getAbsoluteFile());
            try {
                for(int i = 0; i < cargoPlanes.size(); i++){
                    out.print(cargoPlanes.get(i).toString());
                    out.print("\n");
                }
                for(int i = 0; i < passengerPlanes.size(); i++){
                    out.print(passengerPlanes.get(i).toString());
                    out.print("\n");
                }
            } finally {
                out.close();
                LOG.info("List of all planes written");
            }
        } catch(IOException e) {
            throw new RuntimeException(e);
        }

    }

    /**
     * Writing list of sorted by flight range planes into the report
     * @param filename
     * @param planeArrayList
     */
    public static void printFlightRangeSortedList(String filename, ArrayList<Plane> planeArrayList){
        File file = new File(filename);
        try {
            if(!file.exists()){
                file.createNewFile();
            }
            PrintWriter out = new PrintWriter(new FileWriter(filename, true));
            try {
                for(int i = 0; i < planeArrayList.size(); i++){
                    out.print(planeArrayList.get(i).getTitle());
                    out.print(" ");
                    out.print(planeArrayList.get(i).getFlightRange());
                    out.print("\n");
                }

            } finally {
                out.close();
                LOG.info("Sorted by the flight rage");
            }
        } catch(IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Writing the found plane into the report
     * @param filename
     * @param plane
     */
    public static void printSearchedPlane(String filename, Plane plane){
        File file = new File(filename);
        try {
            if(!file.exists()){
                file.createNewFile();
            }
            PrintWriter out = new PrintWriter(new FileWriter(filename, true));
            try {
                out.print("Found plane: ");
                out.print(plane.getTitle());
                out.print("\n");
            } finally {
                out.close();
                LOG.info("Searched plane");
            }
        } catch(IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Writing the report about total seats capacity and weight capacity int the aviacompany
     * @param filename
     * @param totalSeats
     * @param weightCapacity
     */
    public static void printCalculatedValues(String filename, int totalSeats, int weightCapacity){
        File file = new File(filename);
        try {
            if(!file.exists()){
                file.createNewFile();
            }
            PrintWriter out = new PrintWriter(new FileWriter(filename, true));
            try {
                out.print("Total seats: ");
                out.print(totalSeats);
                out.print("\n");
                out.print("Total weight capacity: ");
                out.print(weightCapacity);
                out.print("\n");
            } finally {
                out.close();
                LOG.info("Calculated values");
            }
        } catch(IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Reporting the info about the search effort
     * @param plane
     */
    public static void findPlane(Plane plane){

        if(plane == null) {
            LOG.info("Plane not found");
        }
        else {
            ResultPrinter.printSearchedPlane("output/result.txt", plane);
        }
    }

}
