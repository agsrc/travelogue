package edu.akshay.travelogue.domain;

import edu.akshay.travelogue.domain.PassengerType;
import edu.akshay.travelogue.domain.entities.Activity;

import java.util.List;

public interface Passenger {

    PassengerType getPassengerType();

    void printDetails();
    void signUpForActivity(Activity activity);
    List<Activity> getSignedUpActivitiesWithDetails();
}
