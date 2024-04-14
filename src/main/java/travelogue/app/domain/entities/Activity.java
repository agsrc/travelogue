package travelogue.app.domain.entities;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Activity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private double cost;
    private int capacity;
    private String description;

    @ManyToOne // One Destination can have many Activities
    private Destination destination;

    public Activity(String name, double cost, int capacity, String description, Destination destination) {
        if (cost <= 0) {
            throw new IllegalArgumentException("Cost must be positive.");
        }
        if (capacity < 0) {
            throw new IllegalArgumentException("Capacity cannot be negative.");
        }
        this.name = name;
        this.cost = cost;
        this.capacity = capacity;
        this.description = description;
        this.destination= destination;
    }


}

