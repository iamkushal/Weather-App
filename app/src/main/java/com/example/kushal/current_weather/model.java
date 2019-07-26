package com.example.kushal.current_weather;

import java.util.ArrayList;

public class model {
    Coord CoordObject;
    ArrayList<Weather> weather = new ArrayList<Weather>();
    private String base;

    Main main;
    private float visibility;
    Wind WindObject;
    Clouds CloudsObject;
    private float dt;
    Sys SysObject;
    private float id;
    private String name;
    private float cod;


    // Getter Methods

    public Coord getCoord() {
        return CoordObject;
    }

    public ArrayList<Weather> getWeather() {
        return weather;
    }

    public String getBase() {
        return base;
    }

    public Main getMain() {
        return main;
    }

    public float getVisibility() {
        return visibility;
    }

    public Wind getWind() {
        return WindObject;
    }

    public Clouds getClouds() {
        return CloudsObject;
    }

    public float getDt() {
        return dt;
    }

    public Sys getSys() {
        return SysObject;
    }

    public float getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public float getCod() {
        return cod;
    }

    // Setter Methods

    public void setCoord(Coord coordObject) {
        this.CoordObject = coordObject;
    }

    public void setBase(String base) {
        this.base = base;
    }

    public void setMain(Main mainObject) {
        this.main = mainObject;
    }

    public void setVisibility(float visibility) {
        this.visibility = visibility;
    }

    public void setWind(Wind windObject) {
        this.WindObject = windObject;
    }

    public void setClouds(Clouds cloudsObject) {
        this.CloudsObject = cloudsObject;
    }

    public void setDt(float dt) {
        this.dt = dt;
    }

    public void setSys(Sys sysObject) {
        this.SysObject = sysObject;
    }

    public void setId(float id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCod(float cod) {
        this.cod = cod;
    }
}

class Sys {
    private float type;
    private float id;
    private float message;
    private String country;
    private float sunrise;
    private float sunset;


    // Getter Methods

    public float getType() {
        return type;
    }

    public float getId() {
        return id;
    }

    public float getMessage() {
        return message;
    }

    public String getCountry() {
        return country;
    }

    public float getSunrise() {
        return sunrise;
    }

    public float getSunset() {
        return sunset;
    }

    // Setter Methods

    public void setType(float type) {
        this.type = type;
    }

    public void setId(float id) {
        this.id = id;
    }

    public void setMessage(float message) {
        this.message = message;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public void setSunrise(float sunrise) {
        this.sunrise = sunrise;
    }

    public void setSunset(float sunset) {
        this.sunset = sunset;
    }
}

class Clouds {
    private float all;


    // Getter Methods

    public float getAll() {
        return all;
    }

    // Setter Methods

    public void setAll(float all) {
        this.all = all;
    }
}

class Wind {
    private float speed;
    private float deg;


    // Getter Methods

    public float getSpeed() {
        return speed;
    }

    public float getDeg() {
        return deg;
    }

    // Setter Methods

    public void setSpeed(float speed) {
        this.speed = speed;
    }

    public void setDeg(float deg) {
        this.deg = deg;
    }
}

class Main {
    private float temp;
    private float pressure;
    private float humidity;
    private float temp_min;
    private float temp_max;


    // Getter Methods

    public float getTemp() {
        return temp;
    }

    public float getPressure() {
        return pressure;
    }

    public float getHumidity() {
        return humidity;
    }

    public float getTemp_min() {
        return temp_min;
    }

    public float getTemp_max() {
        return temp_max;
    }

    // Setter Methods

    public void setTemp(float temp) {
        this.temp = temp;
    }

    public void setPressure(float pressure) {
        this.pressure = pressure;
    }

    public void setHumidity(float humidity) {
        this.humidity = humidity;
    }

    public void setTemp_min(float temp_min) {
        this.temp_min = temp_min;
    }

    public void setTemp_max(float temp_max) {
        this.temp_max = temp_max;
    }
}

class Coord {
    private float lon;
    private float lat;


    // Getter Methods

    public float getLon() {
        return lon;
    }

    public float getLat() {
        return lat;
    }

    // Setter Methods

    public void setLon(float lon) {
        this.lon = lon;
    }

    public void setLat(float lat) {
        this.lat = lat;
    }

}

class Weather{
    int id;
    String main;
    String description;
    String icon;
    String date,day,temperature;


    public Weather(int id, String main, String description, String icon,String date, String day,String temperature_range) {
        this.id = id;
        this.main = main;
        this.description = description;
        this.icon = icon;
        this.date = date;
        this.day= day;
        this.temperature = temperature_range;
    }

    public int getId() {
        return id;
    }
    public String getDate() {return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
    public String getTemperature() {return temperature;
    }

    public void setTemperature(String temperature) {
        this.temperature = temperature;
    }

    public String getDay() {return day;
    }

    public void setDay(String day) {
        this.day = day;
    }


    public void setId(int id) {
        this.id = id;
    }

    public String getMain() {
        return main;
    }

    public void setMain(String main) {
        this.main = main;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }
}
