package travelogue.app.domain.passengers;

import travelogue.app.domain.valueobjects.PassengerType;
import travelogue.app.domain.entities.Activity;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import java.util.List;

@Entity
@Getter
@Setter
@EqualsAndHashCode
@AllArgsConstructor
public class PremiumPassenger implements Passenger {
    private String name;
    private int passengerNumber;

    @ManyToMany // Many Premium Passengers can sign up for many Activities (through a join table)
    @JoinTable( // Define the join table
            name = "passenger_activity",
            joinColumns = @JoinColumn(name = "passenger_id"),
            inverseJoinColumns = @JoinColumn(name = "activity_id"))
    private List<Activity> signedUpActivities;

    @Override
    public PassengerType getPassengerType() {
        return PassengerType.PREMIUM;
    }

    @Override
    public void printDetails() {

    }

    @Override
    public void signUpForActivity(Activity activity) {

    }

    @Override
    public List<Activity> getSignedUpActivitiesWithDetails() {
        return null;
    }
}
