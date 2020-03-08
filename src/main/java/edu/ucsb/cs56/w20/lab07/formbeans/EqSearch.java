package edu.ucsb.cs56.w20.lab07.formbeans;

public class EqSearch
{
    private int distance;
    private int minmag;
    private double lat;
    private double lon;
    private String location;

    public EqSearch()
    {
	distance = 0;
	minmag = 0;
    }
    
    public void setDistance(int d)
    {
	distance = d;
    }

    public void setMinmag(int m)
    {
	minmag = m;
    }

    public void setLat(double la)
    {
	lat = la;
    }

    public void setLon(double lo)
    {
	lon = lo;
    }

    public void setLocation(String l)
    {
	location = l;
    }

    public double getLat()
    {
	return lat;
    }

    public double getLon()
    {
	return lon;
    }

    public String getLocation()
    {
	return location;
    }

    public int getDistance()
    {
	return distance;
    }

    public int getMinmag()
    {
	return minmag;
    }
}
