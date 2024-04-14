package travelogue.app.domain.passengers;

import travelogue.app.domain.valueobjects.PassengerType;
import travelogue.app.domain.entities.Activity;

import java.util.List;

public interface Passenger {

    String getName();
    int getPassengerNumber();
    PassengerType getPassengerType();

    void printDetails();
    void signUpForActivity(Activity activity);
    List<Activity> getSignedUpActivitiesWithDetails();
}
