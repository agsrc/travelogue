package travelogue.app.domain.services;

import travelogue.app.domain.entities.Activity;

import java.util.ArrayList;
import java.util.List;

public class ActivityService {

    private List<Activity> activities; // In-memory list of activities

    public ActivityService() {
        this.activities = new ArrayList<>();
    }

    public void printActivitiesWithAvailableSpaces(int bookedCount) {
        System.out.println("\n** Activities with Available Spaces **");
        List<Activity> availableActivities = new ArrayList<>();
        for (Activity activity : activities) {
            if (activity.getCapacity() > bookedCount) {
                availableActivities.add(activity);
            }
        }

        if (availableActivities.isEmpty()) {
            System.out.println("No activities currently have available spaces.");
        } else {
            for (Activity activity : availableActivities) {
                System.out.println(" - " + activity.getName() + " (" + activity.getDestination().getName() + ")");
                System.out.println("   Available Spaces: " + (activity.getCapacity() - bookedCount));
            }
        }
    }
}


