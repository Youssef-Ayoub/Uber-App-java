package SWProject;

import java.util.ArrayList;

public class ArrayListStrategy implements ISystemDataStrategy {
    private ArrayList<IPassenger> passengers;
    private ArrayList<IDriver> drivers;
    private ArrayList<IRegistrationRequest> registrations;
    private ArrayList<IOffer> offers;
    private ArrayList<IRide> rides;
    private ArrayList<IRating> ratings;
    private ArrayList<String> discountAreas;
    private IAdmin admin;

    public ArrayListStrategy(){
        passengers = new ArrayList<IPassenger>();
        drivers = new ArrayList<IDriver>();
        registrations = new ArrayList<IRegistrationRequest>();
        offers = new ArrayList<IOffer>();
        rides = new ArrayList<IRide>();
        ratings = new ArrayList<IRating>();
        discountAreas = new ArrayList<>();
        admin = new Admin("admin", "0000");
    }

    @Override
    public boolean displayAllRegistrations() {
        for(int i=0; i < registrations.size(); i++){
            System.out.println((i+1) +":"+ registrations.get(i));
        }
        if (registrations.size() == 0)
        {
            return false;
        }
        return true;
    }

    @Override
    public boolean addRegistrationRequest(IRegistrationRequest registrationRequest) {
        return registrations.add(registrationRequest);
    }

    @Override
    public boolean addDriver(IDriver driver) {
        return drivers.add(driver);
    }

    @Override
    public boolean addPassenger(IPassenger passenger) {
        return passengers.add(passenger);
    }
    
    @Override
    public boolean addOffer(IOffer offer) {
        return offers.add(offer);
    }

    @Override
    public boolean addRide(IRide ride) {
        return rides.add(ride);
    }

    @Override
    public boolean addRating(IRating rating) {
        return ratings.add(rating);
    }

    @Override
    public IRegistrationRequest getRegistrationRequest(int index) {
        return registrations.get(index);
    }

    @Override
    public IRegistrationRequest getRegistrationRequest(String username) {
        for (IRegistrationRequest registrationRequest : registrations) {
            if (registrationRequest.getUserInfo().getUsername().equals(username))
                return registrationRequest;
        }
        return null;
    }

    @Override
    public IDriver getDriver(String username) {
        for (IDriver driver : drivers){
            if (driver.getPersonalInfo().getUsername().equals(username)){
                return driver;
            }    
        }
        return null;
    }

    @Override
    public IPassenger getPassenger(String username) {
        for (IPassenger passenger : passengers){
            if (passenger.getPersonalInfo().getUsername().equals(username)){
                return passenger;
            }              
        }
        return null;
    }

    @Override
    public IAdmin getAdmin(String username) {
        if (admin.getUsername().equals(username))
            return admin;
        return null;
    }

    @Override
    public ArrayList<IDriver> getDriversWithFavouriteArea(String area) {
        ArrayList<IDriver> driversWithFavouriteArea = new ArrayList<>();
        for (IDriver driver : drivers){
            if (driver.hasFavouriteArea(area)){
                driversWithFavouriteArea.add(driver);
            }
        }
        return driversWithFavouriteArea;
    }

    @Override
    public ArrayList<IOffer> getOffersOfPassenger(IPassenger passenger) {
        ArrayList<IOffer> offersOfPassenger = new ArrayList<>();
        for (IOffer iOffer : offers) {
            if (iOffer.getItsRide().getItsPassenger().equals(passenger))
                offersOfPassenger.add(iOffer);
        }
        return offersOfPassenger;
    }

    @Override
    public ArrayList<IOffer> getOffersOfDriver(IDriver driver) {
        ArrayList<IOffer> offersOfDriver = new ArrayList<>();
        for (IOffer iOffer : offers) {
            if (iOffer.getItsDriver().equals(driver))
                offersOfDriver.add(iOffer);
        }
        return offersOfDriver;
    }

    @Override
    public ArrayList<IRating> gerRatingsOfDriver(IDriver driver) {
        ArrayList<IRating> ratingsOfDriver = new ArrayList<>();
        for (IRating iRating : ratings) {
            if (iRating.getItsDriver().equals(driver))
                ratingsOfDriver.add(iRating);
        }
        return ratingsOfDriver;
    }

    @Override
    public ArrayList<IRide> getRidesOfDriver(IDriver driver) {
        ArrayList<IRide> ridesOfDriver = new ArrayList<>();
        for (String favouriteArea : driver.getFavouriteAreas()) {
            for (IRide ride : rides) {
                if (ride.getSource().equals(favouriteArea))
                    ridesOfDriver.add(ride);
            }
        }
        return ridesOfDriver;
    }
    
    @Override
    public boolean removeRegisrationRequest(IRegistrationRequest registrationRequest) {
        return registrations.remove(registrationRequest);
    }

    @Override
    public boolean containsRideOfPassenger(IPassenger passenger) {
        for (IRide ride : rides) {
            if (ride.getItsPassenger() == passenger)
                return true;
        }
        return false;
    }

    @Override
    public boolean containsDiscountArea(String destination) {
        for (String area : discountAreas) {
            if (area.equals(destination))
                return true;
        }
        return false;
    }

    @Override
    public boolean addDiscountArea(String area) {
        return discountAreas.add(area);
    }

    @Override
    public boolean removeDiscountArea(String area) {
        return discountAreas.remove(area);
    }

}
