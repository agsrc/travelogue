package edu.akshay.travelogue.domain;

import edu.akshay.travelogue.domain.entities.Activity;
import lombok.Data;

import javax.persistence.Entity;
import java.util.List;

@Entity
@Data
public class GoldPassenger implements PayingPassenger {
    private String name;
    private int passengerNumber;
    private double balance;

    private static final double GOLD_DISCOUNT_RATE = 0.9;


    @Override
    public PassengerType getPassengerType() {
        return PassengerType.GOLD;
    }

    @Override
    public void printDetails() {

    }

    @Override
    public void signUpForActivity(Activity activity) {
        double discountedCost = activity.getCost() * 0.9; // 10% discount
        if (balance >= discountedCost) {
            balance -= discountedCost;
            // Add activity to signedUpActivities (logic from previous example)
        } else {
            System.out.println("Insufficient balance for activity signup.");
        }
    }



    @Override
    public List<Activity> getSignedUpActivitiesWithDetails() {
        return null;
    }

    @Override
    public double getBalance() {
        return 0;
    }

    // Attributes specific to StandardPassenger (e.g., balance if applicable)

    // Implement methods from Passenger interface
}
