package edu.akshay.travelogue.domain;

import edu.akshay.travelogue.domain.Destination;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

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

}

