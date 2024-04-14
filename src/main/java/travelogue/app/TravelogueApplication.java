package travelogue.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import travelogue.app.domain.entities.Activity;
import travelogue.app.domain.entities.Destination;
import travelogue.app.domain.entities.TravelPackage;
import travelogue.app.domain.passengers.GoldPassenger;
import travelogue.app.domain.passengers.Passenger;
import travelogue.app.domain.passengers.StandardPassenger;
import travelogue.app.domain.services.ActivityService;
import travelogue.app.domain.services.ItineraryPrinter;
import travelogue.app.domain.services.PassengerService;
import travelogue.app.domain.services.TravelReportPrinter;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@SpringBootApplication
public class TravelogueApplication {

    public static void main(String[] args) {
        SpringApplication.run(TravelogueApplication.class, args);

        Destination destination = new Destination("Sun Island");

        // Create activities with the destination
        List<Activity> activities = new ArrayList<>();
        activities.add(new Activity("Hiking", 50.0, 10, "Explore the beautiful mountain trails.", destination));
        activities.add(new Activity("City Tour", 25.0, 20, "Discover the city's landmarks and culture.", destination));
        activities.add(new Activity("Snorkelling", 75.0, 15, "Experience the underwater world.", destination));

        // Create a TravelPackage with dummy data
        List<Destination> itinerary = new ArrayList<>();

        // Create some dummy passengers
        List<Passenger> passengers = new ArrayList<>();
        passengers.add(new GoldPassenger("John Smith", 12345, 1000.0));
        passengers.add(new StandardPassenger("Jane Doe", 54321, 100.0));


        TravelPackage travelPackage = new TravelPackage(null, "Beach Getaway", 50, itinerary, passengers);
        travelPackage.setItinerary(List.of(new Destination(null, "Sun Island", activities)));
        travelPackage.getItinerary().get(0).setActivities(activities);

        //set passengers
        travelPackage.setPassengers(passengers);

        // Use the utility classes to print information -- (Following utilities would be aid when the app is scaled and integrated with database)

        // Print itinerary
        ItineraryPrinter itineraryPrinter = new ItineraryPrinter();
        itineraryPrinter.printItinerary(travelPackage);

        // Print passenger list
        TravelReportPrinter reportPrinter = new TravelReportPrinter();
        reportPrinter.printPassengerList(travelPackage);

        // Print activities with available spaces (assuming bookedCount is 2)
        int bookedCount = 2; // Simulate 2 passengers booked activities
        ActivityService activityService = new ActivityService(activities); // Inject activities
        activityService.printActivitiesWithAvailableSpaces(bookedCount);

        // PassengerService to print individual passenger details

        PassengerService passengerService = new PassengerService();

        Random random = new Random();
        for (Passenger passenger : passengers) {
            int numActivities = random.nextInt(activities.size()); // Choose a random number of activities (up to total activities)
            for (int i = 0; i < Math.min(numActivities, 2); i++) { // Sign up for a maximum of 2 activities
                int randomActivityIndex = random.nextInt(activities.size());
                passenger.signUpForActivity(activities.get(randomActivityIndex));
            }

            List<Activity> passengerActivities = passenger.getSignedUpActivitiesWithDetails();
            passengerService.printPassengerDetails(passenger, passengerActivities);
        }

    }

}



