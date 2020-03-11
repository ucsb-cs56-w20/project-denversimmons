package edu.ucsb.cs56.w20.lab07.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Location {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    
    private long placeId;
    private String name;
    private double latitude;
    private double longitude;

    public Location(){
    }
    public Location(long placeId, String name, double latitude, double longitude){
	this.placeId = placeId;
	this.name = name;
	this.latitude = latitude;
	this.longitude = longitude;
    }
    public void setId(long id){
	this.id = id;
    }
    public void setPlaceId(long placeId){
	this.placeId = placeId;
    }
    public void setName(String name){
	this.name = name;
    }
    public void setLatitude(double latitude){
	this.latitude = latitude;
    }
    public void setLongitude(double longitude){
	this.longitude = longitude;
    }
    public long getId(){
	return id;
    }
    public String getName(){
	return name;
    }
    public double getLatitude(){
	return latitude;
    }
    public double getLongitude(){
	return longitude;
    }
}
