package com.example.kushal.current_weather;

import java.util.ArrayList;


public class ListModel {
    private float dt;
    Mains main;
    ArrayList<Weather5DaysModel> weather = new ArrayList<Weather5DaysModel>();
    Cloudss CloudsObject;
    Winds WindObject;
    Syss SysObject;
    private String dt_txt;


    // Getter Methods
    public ArrayList<Weather5DaysModel> getweather5DaysModels(){
        return weather;
    }

    public float getDt() {
        return dt;
    }

    public Mains getMains() {
        return main;
    }

    public Cloudss getClouds() {
        return CloudsObject;
    }

    public Winds getWind() {
        return WindObject;
    }

    public Syss getSys() {
        return SysObject;
    }

    public String getDt_txt() {
        return dt_txt;
    }

    // Setter Methods

    public void setDt(float dt) {
        this.dt = dt;
    }

    public void setMain(Mains mainObject) {
        this.main = mainObject;
    }

    public void setClouds(Cloudss cloudsObject) {
        this.CloudsObject = cloudsObject;
    }

    public void setWind(Winds windObject) {
        this.WindObject = windObject;
    }

    public void setSys(Syss sysObject) {
        this.SysObject = sysObject;
    }

    public void setDt_txt(String dt_txt) {
        this.dt_txt = dt_txt;
    }
}

class Syss {
    private String pod;


    // Getter Methods

    public String getPod() {
        return pod;
    }

    // Setter Methods

    public void setPod(String pod) {
        this.pod = pod;
    }
}

class Winds {
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

class Cloudss {
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

class Mains {
    private float temp;
    private float temp_min;
    private float temp_max;
    private float pressure;
    private float sea_level;
    private float grnd_level;
    private float humidity;
    private float temp_kf;


    // Getter Methods

    public float getTemp() {
        return temp;
    }

    public float getTemp_min() {
        return temp_min;
    }

    public float getTemp_max() {
        return temp_max;
    }

    public float getPressure() {
        return pressure;
    }

    public float getSea_level() {
        return sea_level;
    }

    public float getGrnd_level() {
        return grnd_level;
    }

    public float getHumidity() {
        return humidity;
    }

    public float getTemp_kf() {
        return temp_kf;
    }

    // Setter Methods

    public void setTemp(float temp) {
        this.temp = temp;
    }

    public void setTemp_min(float temp_min) {
        this.temp_min = temp_min;
    }

    public void setTemp_max(float temp_max) {
        this.temp_max = temp_max;
    }

    public void setPressure(float pressure) {
        this.pressure = pressure;
    }

    public void setSea_level(float sea_level) {
        this.sea_level = sea_level;
    }

    public void setGrnd_level(float grnd_level) {
        this.grnd_level = grnd_level;
    }

    public void setHumidity(float humidity) {
        this.humidity = humidity;
    }

    public void setTemp_kf(float temp_kf) {
        this.temp_kf = temp_kf;
    }
}

class Weather5DaysModel {

    private float id;
    private String main;
    private String description;
    private String icon;


    // Getter Methods

    public float getId() {
        return id;
    }

    public String getMain() {
        return main;
    }

    public String getDescription() {
        return description;
    }

    public String getIcon() {
        return icon;
    }

    // Setter Methods

    public void setId(float id) {
        this.id = id;
    }

    public void setMain(String main) {
        this.main = main;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }
}
