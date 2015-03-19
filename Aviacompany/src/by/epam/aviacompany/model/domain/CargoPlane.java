package by.epam.aviacompany.model.domain;


import by.epam.aviacompany.model.exception.LogicException;
import org.apache.log4j.Logger;

public class CargoPlane extends Plane {
    private int weightCapacity;
    private String cargoType;
    private static Logger LOG = Logger.getLogger(CargoPlane.class);

    public CargoPlane(String title, int flightRange, double fluelRate, int id, int weightCapacity, String cargoType) {
        super(title, flightRange, fluelRate, id);
        this.weightCapacity = weightCapacity;
        this.cargoType = cargoType;
    }

    public CargoPlane(int weightCapacity, String cargoType) {
        this.weightCapacity = weightCapacity;
        this.cargoType = cargoType;
    }

    public CargoPlane(){
        this.weightCapacity = 0;
        this.cargoType = "";
    }

    public int getWeightCapacity() {
        return weightCapacity;
    }

    public void setWeightCapacity(int weightCapacity) {

        if(weightCapacity > 0) {
            this.weightCapacity = weightCapacity;
        } else try {
            throw new LogicException("Failed weight capacity input");
        } catch (LogicException e) {
            LOG.warn(e.getMessage());
        }
    }

    public String getCargoType() {
        return cargoType;
    }

    public void setCargoType(String cargoType) {

        if(cargoType != null || !cargoType.isEmpty()) {
            this.cargoType = cargoType;
        } else try {
            throw new LogicException("Failed cargo type input");
        } catch (LogicException e) {
            LOG.warn(e.getMessage());
        }
    }

    @Override
    public String toString() {
        return "CargoPlane{" +
                " Id: " + getId() +
                " Title: " + getTitle() +
                " Fuel rate: " + getFuelRate() +
                " FlightRange" + getFlightRange() +
                " Weight capacity: " + weightCapacity +
                " Type: " + cargoType +
                '}';
    }
}
