package travelogue.app.domain.services;

import travelogue.app.domain.entities.TravelPackage;
import travelogue.app.domain.passengers.Passenger;

public class TravelReportPrinter {

    public void printPassengerList(TravelPackage travelPackage) {
        System.out.println("** Passenger List for " + travelPackage.getName() + " Travel Package **");
        System.out.println("Passenger Capacity: " + travelPackage.getPassengerCapacity());
        System.out.println("Number of Passengers Enrolled: " + travelPackage.getPassengers().size());
        System.out.println("\nPassengers:");
        for (Passenger passenger : travelPackage.getPassengers()) {
            System.out.println("- " + passenger.getName() + " (" + passenger.getPassengerNumber() + ")");
        }
    }
}

