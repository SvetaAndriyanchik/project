package by.epam.aviacompany.model.domain;


import by.epam.aviacompany.model.exception.LogicException;
import org.apache.log4j.Logger;

public class PassengerPlane extends Plane {

    private int seatsCapacity;
    private boolean alcoholAllowance;
    private static Logger LOG = Logger.getLogger(PassengerPlane.class);

    public PassengerPlane(String title, int flightRange, double fluelRate, int id, int seatsCapacity, boolean alcoholAllowance) {
        super(title, flightRange, fluelRate, id);
        this.seatsCapacity = seatsCapacity;
        this.alcoholAllowance = alcoholAllowance;
    }

    public PassengerPlane(int seatsCapacity, boolean alcoholAllowance) {
        this.seatsCapacity = seatsCapacity;
        this.alcoholAllowance = alcoholAllowance;
    }

    public int getSeatsCapacity() {
        return seatsCapacity;
    }

    public void setSeatsCapacity(int seatsCapacity) {
        if(seatsCapacity > 0) {
            this.seatsCapacity = seatsCapacity;
        } else try {
            throw new LogicException("Failed seats capacity input");
        } catch (LogicException e) {
            LOG.warn(e.getMessage());
        }

    }

    public boolean isAlcoholAllowance() {
        return alcoholAllowance;
    }

    public void setAlcoholAllowance(boolean alcoholAllowance) {
        this.alcoholAllowance = alcoholAllowance;
    }

    @Override
    public String toString() {
        return "PassengerPlane{" +
                " Id: " + getId() +
                " Title: " + getTitle() +
                " Fuel rate: " + getFuelRate() +
                " FlightRange" + getFlightRange() +
                " Seats capacity=" + seatsCapacity +
                " AlcoholAllowance=" + alcoholAllowance +
                '}';
    }
}
