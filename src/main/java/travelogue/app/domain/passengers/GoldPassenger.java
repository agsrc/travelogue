package travelogue.app.domain.passengers;

import lombok.Getter;
import lombok.Setter;
import travelogue.app.domain.entities.Activity;
import travelogue.app.domain.valueobjects.PassengerType;

import javax.persistence.Entity;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Setter
@Getter
public class GoldPassenger extends BasePassenger implements PayingPassenger {

    private double balance;
    private List<Activity> signedUpActivities;

    private static final double GOLD_DISCOUNT_RATE = 0.9;

    public GoldPassenger(String name, int passengerNumber, double balance) {
        super(name, passengerNumber); // Call BasePassenger constructor
        this.balance = balance;
        this.signedUpActivities = new ArrayList<>(); // Track signed-up activities
    }


    @Override
    public PassengerType getPassengerType() {
        return PassengerType.GOLD;
    }

    @Override
    public void printDetails() {
        // TODO : check again, seems like code duplication
    }

    @Override
    public void signUpForActivity(Activity activity) {
        double discountedCost = activity.getCost() * GOLD_DISCOUNT_RATE; // 10% discount
        if (balance >= discountedCost) {
            balance -= discountedCost;
            signedUpActivities.add(activity);
        } else {
            System.out.println("Insufficient balance for activity signup.");
        }
    }


    @Override
    public List<Activity> getSignedUpActivitiesWithDetails() {
        return signedUpActivities;
    }

    @Override
    public double getBalance() {
        return balance;
    }

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
}
