package edu.akshay.travelogue.domain;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
@Data
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
