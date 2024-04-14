package travelogue.app.domain.services;

import travelogue.app.domain.entities.Activity;
import travelogue.app.domain.passengers.Passenger;
import travelogue.app.domain.passengers.PayingPassenger;

import java.util.List;

public class PassengerService {

    public void printPassengerDetails(Passenger passenger, List<Activity> activities) {
        if (passenger != null) {
            System.out.println("** Passenger Details **");
            System.out.println("Name: " + passenger.getName());
            System.out.println("Passenger Number: " + passenger.getPassengerNumber());

            if (passenger instanceof PayingPassenger payingPassenger) {
                System.out.println("Balance: " + payingPassenger.getBalance());
            } else {
                System.out.println("Balance: N/A");
            }

            System.out.println("\nSigned Up Activities:");
            if (activities != null && !activities.isEmpty()) {
                for (Activity activity : activities) {
                    System.out.println(" - " + activity.getName() + " (" + activity.getDestination().getName() + ")");
                    System.out.println("   Price Paid: " + activity.getCost());
                }
            } else {
                System.out.println(" - No activities signed up for.");
            }
        } else {
            System.out.println("Passenger object is null.");
        }
    }
}

