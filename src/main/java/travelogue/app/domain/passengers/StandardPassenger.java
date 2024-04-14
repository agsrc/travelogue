package travelogue.app.domain.passengers;

import lombok.*;
import travelogue.app.domain.valueobjects.PassengerType;
import travelogue.app.domain.entities.Activity;

import javax.persistence.Entity;
import java.util.List;
import java.util.Objects;

@Entity
@AllArgsConstructor
@Getter
@Setter
public class StandardPassenger extends BasePassenger implements PayingPassenger {
    private double balance;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        StandardPassenger that = (StandardPassenger) o;
        return Double.compare(that.balance, balance) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), balance);
    }

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
