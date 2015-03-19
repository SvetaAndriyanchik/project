package by.epam.aviacompany.model.domain;


import by.epam.aviacompany.model.exception.LogicException;
import org.apache.log4j.Logger;

public abstract class Plane {

    private String title;
    private int flightRange;
    private double fuelRate;
    private int id;
    private static Logger LOG = Logger.getLogger(Plane.class);

    public Plane(String title, int flightRange, double fuelRate, int id) {
        this.title = title;
        this.flightRange = flightRange;
        this.fuelRate = fuelRate;
        this.id = id;
    }

    public Plane(){
        this.title = "";
        this.flightRange = 0;
        this.fuelRate = 0.0;
        this.id = 0;
    }
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {

        if(title != null || !title.isEmpty()) {
            this.title = title;
        } else {
            try {
                throw new LogicException("Failed title");
            } catch (LogicException e) {
                LOG.warn(e.getMessage());
            }
        }
    }

    public int getFlightRange() {
        return flightRange;
    }

    public void setFlightRange(int flightRange) {

        if(flightRange > 0) {
            this.flightRange = flightRange;
        } else try {
            throw new LogicException("Failed flight range");
        } catch (LogicException e) {
            LOG.warn(e.getMessage());
        }

    }

    public double getFuelRate() {
        return fuelRate;
    }

    public void setFuelRate(double fuelRate) {
        if(fuelRate > 0) {
            this.fuelRate = fuelRate;
        } else try {
            throw new LogicException("Failed fuel rate input");
        } catch (LogicException e) {
            LOG.error(e.getMessage());
        }
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        if(id >= 0) {
            this.id = id;
        } else try {
            throw new LogicException("Failed id input");
        } catch (LogicException e) {
            LOG.error(e.getMessage());
        }
    }

    @Override
    public String toString() {
        return "Plane{" +
                "title='" + title + '\'' +
                ", flightRange=" + flightRange +
                ", fuelRate=" + fuelRate +
                ", id=" + id +
                '}';
    }
}
