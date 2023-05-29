package SWProject;

public class TwoPassengersDiscount extends RideDiscountDecorator {
    
    public TwoPassengersDiscount(IRide ride){
        super(ride);
    }

    @Override
    public double getCost(double price) {
        return ride.getCost(price) - (0.05 * price);
    }
}
