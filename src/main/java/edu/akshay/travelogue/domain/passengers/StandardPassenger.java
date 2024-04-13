package edu.akshay.travelogue.domain;

import edu.akshay.travelogue.domain.entities.Activity;
import lombok.Data;

import javax.persistence.Entity;
import java.util.List;

@Entity
@Data
public class StandardPassenger implements PayingPassenger {
    private String name;
    private int passengerNumber;
    private double balance;

    @Override
    public PassengerType getPassengerType() {
        return PassengerType.STANDARD;
    }

    @Override
    public void printDetails() {

    }

    @Override
    public void signUpForActivity(Activity activity) {
        if (balance >= activity.getCost()) {
            balance -= activity.getCost();
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
