package by.epam.aviacompany.controller;

import by.epam.aviacompany.model.businesslogic.*;
import by.epam.aviacompany.model.domain.CargoPlane;
import by.epam.aviacompany.model.domain.PassengerPlane;
import by.epam.aviacompany.model.domain.Plane;
import org.apache.log4j.Logger;
import java.awt.EventQueue;
import java.io.IOException;
import java.util.ArrayList;


public class Runner {

    /**
     * Start point
     */
    private static Logger LOG = Logger.getLogger(Runner.class);

    public static void main(String args[]){
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                LOG.info("start");
/**
 * Creating objects
 */
                Creator creator = new Creator();
                ArrayList<CargoPlane> cargoPlaneArrayList = creator.createCargoPlaneList();
                ArrayList<PassengerPlane> passengerPlaneArrayList = creator.createPassengerPlaneList();

                ArrayList<Plane> planeArrayList= creator.createAviacompany(cargoPlaneArrayList, passengerPlaneArrayList);
                SortManager sort = new SortManager();
                planeArrayList = sort.sortByFlightRange(planeArrayList);

                Searcher search = new Searcher();
                Calculator calculator = new Calculator();
                int totalSeats = calculator.calculateTotalSeats(passengerPlaneArrayList);
                int weightCapacity = calculator.calculateTotalWeightCapacity(cargoPlaneArrayList);
/**
 * Writing report
 */
                try {
                    ResultPrinter.printFullPlaneList("reports/result.txt", cargoPlaneArrayList, passengerPlaneArrayList);
                    ResultPrinter.printFlightRangeSortedList("reports/result.txt", planeArrayList);
                    ResultPrinter.findPlane(search.searchFlightRangePlane(planeArrayList, 0.1, 0.9));
                    ResultPrinter.printCalculatedValues("reports/result.txt", totalSeats, weightCapacity);
                }
                catch (IOException e) {
                    LOG.error(e.getMessage());

                }
            }
        });

    }




}
