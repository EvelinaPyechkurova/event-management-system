package ua.edu.ukma.event_management_micro.core;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Data
@NoArgsConstructor
@Entity(name = "building")
@ToString
public class BuildingEntity {
    @Id
    // default strategy, JPA automatically selects the appropriate
    // generation strategy based on the database used
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(nullable = false)
    private String address;

    @Column(nullable = false)
    private int hourlyRate;

    @Column(nullable = false)
    private int areaM2;

    @Column(nullable = false)
    private int capacity;

    @Column(length = 500)
    private String description;

    public BuildingEntity(String address, int hourlyRate, int areaM2, int capacity, String description) {
        this.address = address;
        this.hourlyRate = hourlyRate;
        this.areaM2 = areaM2;
        this.capacity = capacity;
        this.description = description;
    }
}
