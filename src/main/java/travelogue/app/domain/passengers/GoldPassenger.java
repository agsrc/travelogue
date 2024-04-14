package travelogue.app.domain.passengers;

import lombok.*;
import travelogue.app.domain.valueobjects.PassengerType;
import travelogue.app.domain.entities.Activity;

import javax.persistence.Entity;
import java.util.List;
import java.util.Objects;

@Entity
@AllArgsConstructor
@Setter
@Getter
public class GoldPassenger extends BasePassenger implements PayingPassenger {

    private double balance;

    private static final double GOLD_DISCOUNT_RATE = 0.9;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        GoldPassenger that = (GoldPassenger) o;
        return Double.compare(that.balance, balance) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), balance);
    }

    @Override
    public PassengerType getPassengerType() {
        return PassengerType.GOLD;
    }

    @Override
    public void printDetails() {

    }

    @Override
    public void signUpForActivity(Activity activity) {
        double discountedCost = activity.getCost() * 0.9; // 10% discount
        if (balance >= discountedCost) {
            balance -= discountedCost;
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
