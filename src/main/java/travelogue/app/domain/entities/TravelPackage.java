package travelogue.app.domain.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import travelogue.app.domain.passengers.Passenger;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
public class TravelPackage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private int passengerCapacity;

    @OneToMany(mappedBy = "travelPackage")
    private List<Destination> itinerary;

    @OneToMany(mappedBy = "travelPackage")
    private List<Passenger> passengers;

}
