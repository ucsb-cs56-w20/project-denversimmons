package edu.ucsb.cs56.w20.lab07.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Location {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public long id;
    
    public long placeId;
    public String name;
    public double latitude;
    public double longitude;
}
