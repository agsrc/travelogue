package travelogue.app.domain.passengers;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import travelogue.app.domain.entities.Activity;
import travelogue.app.domain.valueobjects.PassengerType;

import javax.persistence.Entity;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Getter
@Setter
@ToString
public class StandardPassenger extends BasePassenger implements PayingPassenger {
    private double balance;
    private List<Activity> signedUpActivities;


    public StandardPassenger(String name, int passengerNumber, double balance) {
        super(name, passengerNumber); // Call BasePassenger constructor
        this.balance = balance;
        this.signedUpActivities = new ArrayList<>(); // Track signed-up activities
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
            signedUpActivities.add(activity); // Add activity to signedUpActivities list
        } else {
            System.out.println("Insufficient balance for activity signup.");
        }
    }

    @Override
    public double getBalance() {
        return balance;
    }

    @Override
    public List<Activity> getSignedUpActivitiesWithDetails() {
        return signedUpActivities;
    }


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

}
