package edu.akshay.travelogue.domain;

import edu.akshay.travelogue.domain.entities.Activity;
import edu.akshay.travelogue.domain.entities.Destination;
import edu.akshay.travelogue.domain.entities.TravelPackage;

public class ItineraryPrinter {

    public void printItinerary(TravelPackage travelPackage) {
        System.out.println("** Travel Package Itinerary **");
        System.out.println("Package Name: " + travelPackage.getName());

        // Iterate through destinations and activities
        for (Destination destination : travelPackage.getItinerary()) {
            System.out.println("\nDestination: " + destination.getName());

            // Print activities for each destination with a separator line
            System.out.println("---------- Activities ----------");
            for (Activity activity : destination.getActivities()) {
                printActivityDetails(activity);
            }
        }
    }

    private void printActivityDetails(Activity activity) {
        System.out.println("- Activity: " + activity.getName());
        System.out.println("  Cost: " + activity.getCost());
        System.out.println("  Capacity: " + activity.getCapacity());
        System.out.println("  Description: " + activity.getDescription());
    }
}
