package com.example.kushal.current_weather;

import java.util.ArrayList;


public class model2 {
    private String cod;
    private float message;
    private float cnt;
    ArrayList< ListModel > list = new ArrayList<ListModel>();
    City CityObject;


    // Getter Methods
    public ArrayList<ListModel> getListModel(){
        return list;
    }
    public String getCod() {
        return cod;
    }

    public float getMessage() {
        return message;
    }

    public float getCnt() {
        return cnt;
    }

    public City getCity() {
        return CityObject;
    }

    // Setter Methods

    public void setCod(String cod) {
        this.cod = cod;
    }

    public void setMessage(float message) {
        this.message = message;
    }

    public void setCnt(float cnt) {
        this.cnt = cnt;
    }

    public void setCity(City cityObject) {
        this.CityObject = cityObject;
    }
}
class City {
    private float id;
    private String name;
    coordi coordiObject;
    private String country;
    private float timezone;


    // Getter Methods

    public float getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public coordi getcoordi() {
        return coordiObject;
    }

    public String getCountry() {
        return country;
    }

    public float getTimezone() {
        return timezone;
    }

    // Setter Methods

    public void setId(float id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setcoordi(coordi coordiObject) {
        this.coordiObject = coordiObject;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public void setTimezone(float timezone) {
        this.timezone = timezone;
    }
}
class coordi {
    private float lat;
    private float lon;


    // Getter Methods

    public float getLat() {
        return lat;
    }

    public float getLon() {
        return lon;
    }

    // Setter Methods

    public void setLat(float lat) {
        this.lat = lat;
    }

    public void setLon(float lon) {
        this.lon = lon;
    }

}
