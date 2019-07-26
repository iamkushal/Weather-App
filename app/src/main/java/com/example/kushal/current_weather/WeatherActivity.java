package com.example.kushal.current_weather;

import android.content.Context;
import android.content.pm.PackageManager;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.github.pavlospt.CircleView;
import com.google.android.gms.location.FusedLocationProviderClient;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class WeatherActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private RecyclerviewAdapter recyclerviewAdapter;
    weatherInterface weatherInterface;
    ArrayList<Weather> arrayList;
    ArrayList<Weather> fiveDayList;
    Main mainlist;
    String weatherData;
    TextView textView,textView1;
    private static final int MY_PERMISSIONS_REQUEST_SEND_SMS = 1;
    public static double latitude, longitude;
    public static String location;
    private GPSTracker gpsTracker;
    private static final int MY_PERMISSIONS_REQUEST_ACCESS_COARSE_LOCATION = 2;
    Context context = this;
    private String LocationText = null;
    private FusedLocationProviderClient mFusedLocationClient;
    String  Weather;
    CircleView weatherresultcircleview;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weather);
        arrayList = new ArrayList<>();
        mainlist = new Main();
        weatherresultcircleview= findViewById(R.id.weather_result);
        textView = findViewById(R.id.city_country);
        textView1 = findViewById(R.id.current_date);
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.openweathermap.org/data/2.5/").
                        addConverterFactory(GsonConverterFactory.create()).build();

        weatherInterface = retrofit.create(weatherInterface.class);
        try {
            if (ContextCompat.checkSelfPermission(getApplicationContext(), android.Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED ) {
                ActivityCompat.requestPermissions(this, new String[]{android.Manifest.permission.ACCESS_FINE_LOCATION}, 101);
            }
        } catch (Exception e){
            e.printStackTrace();
        }
        gpsTracker = new GPSTracker(WeatherActivity.this);
        if(gpsTracker.canGetLocation()){
            latitude = gpsTracker.getLatitude();
            longitude = gpsTracker.getLongitude();
        }else{
            gpsTracker.showSettingsAlert();
        }
        //Calculating Todays Date and Setting up the textview to display during initialisation.
        Date d = Calendar.getInstance().getTime();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("EEE-dd-MMM-yyyy");
        String formattedtodaydate = simpleDateFormat.format(d);
        textView1.setText(formattedtodaydate);

        //Get weather Informations
        getWeather();
        get5Weather();
        //RecyclerViewInit
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this,4);
        recyclerView = (RecyclerView) findViewById(R.id.weather_daily_list);
        recyclerView.setLayoutManager(gridLayoutManager);
    }
    public void getLocation(View view){
        gpsTracker = new GPSTracker(WeatherActivity.this);
        if(gpsTracker.canGetLocation()){
            latitude = gpsTracker.getLatitude();
            longitude = gpsTracker.getLongitude();
        }else{
            gpsTracker.showSettingsAlert();
        }

    }


    private void getWeather() {

        Call<model> call = weatherInterface.getWeather(latitude, longitude, "d889087b5eaf4f7b3fbd60d428311037");
        call.enqueue(new Callback<model>() {
            public static final String TAG = "";

            @Override
            public void onResponse(Call<model> call, Response<model> response) {
                if (!response.isSuccessful()) {
                    Toast.makeText(WeatherActivity.this, response.code(), Toast.LENGTH_LONG).show();
                }
                model model = response.body();
                String base = model.getBase();
                arrayList = model.getWeather();
                location = model.getName();
                System.out.println("SDSD:::"+model.getBase());
                Main main=model.getMain();

                //Temp in kelvin to Celcius and converted as string
                String temp = String.valueOf(Math.round(main.getTemp()-273.15));


                for (Weather weather : arrayList) {

                    weatherData = weather.getMain() + " :"+weather.getDescription();

                }
                String [] split = weatherData.split(":");
                textView.setText(location +",Nepal");
                weatherresultcircleview.setSubtitleText(split[1]);
                weatherresultcircleview.setTitleText(temp+"°C");

            }

            @Override
            public void onFailure(Call<model> call, Throwable t) {

            }
        });

    }
    private void get5Weather(){
        Weather="";
        fiveDayList = new ArrayList<Weather>();
        Call<model2> call = weatherInterface.get5Weather(latitude,longitude,"d889087b5eaf4f7b3fbd60d428311037");
        call.enqueue(new Callback<model2>() {

            @Override
            public void onResponse(Call<model2> call, Response<model2> response) {
                if (!response.isSuccessful()) {
                    Toast.makeText(WeatherActivity.this, response.code(), Toast.LENGTH_LONG).show();
                }
                model2 model2= response.body();
                String cod=model2.getCod();
                Toast.makeText(WeatherActivity.this, cod, Toast.LENGTH_SHORT).show();
                ArrayList<ListModel> listModels=new ArrayList<>();
                int[] everyday = new int[]{0,0,0,0,0,0,0};
                listModels=model2.getListModel();
                for(ListModel listModel: listModels){
                    String Date=listModel.getDt_txt();
                    String Day = convertTimeToDay(Date);

                    Mains mains = listModel.getMains();
                    String temperature_range = String.valueOf(Math.round(mains.getTemp_min()-273.15))+"--"+String.valueOf(Math.round(mains.getTemp_max()-273.15));
                    ArrayList<Weather5DaysModel> listweather5DaysModels=listModel.getweather5DaysModels();

                    for (Weather5DaysModel weather5DaysModel:listweather5DaysModels){
                        float id = weather5DaysModel.getId();
                        String main = weather5DaysModel.getMain();
                        String desc = weather5DaysModel.getDescription();
                        String icon =weather5DaysModel.getIcon();

                        Weather=Weather+" Date: "+Date+" Main: " + weather5DaysModel.getMain() + " Description: " + weather5DaysModel.getDescription();
                        if(convertTimeToDay(Date).equals("Mon") && everyday[0] < 1){
                            fiveDayList.add(new Weather(1,main,desc,icon,Date,Day,temperature_range));
                            everyday[0] = 1;
                        }
                        if(convertTimeToDay(Date).equals("Tue") && everyday[1] < 1){
                            fiveDayList.add(new Weather(1,main,desc,icon,Date,Day,temperature_range));
                            everyday[1] = 1;
                        }
                        if(convertTimeToDay(Date).equals("Wed") && everyday[2] < 1){
                            fiveDayList.add(new Weather(1,main,desc,icon,Date,Day,temperature_range));
                            everyday[2] = 1;
                        }
                        if(convertTimeToDay(Date).equals("Thu") && everyday[3] < 1){
                            fiveDayList.add(new Weather(1,main,desc,icon,Date,Day,temperature_range));
                            everyday[3] = 1;
                        }
                        if(convertTimeToDay(Date).equals("Fri") && everyday[4] < 1){
                            fiveDayList.add(new Weather(1,main,desc,icon,Date,Day,temperature_range));
                            everyday[4] = 1;
                        }
                        if(convertTimeToDay(Date).equals("Sat") && everyday[5] < 1){
                            fiveDayList.add(new Weather(1,main,desc,icon,Date,Day,temperature_range));
                            everyday[5] = 1;
                        }
                        if(convertTimeToDay(Date).equals("Sun") && everyday[6] < 1){
                            fiveDayList.add(new Weather(1,main,desc,icon,Date,Day,temperature_range));
                            everyday[6] = 1;
                        }



                    }


                }
                recyclerviewAdapter = new RecyclerviewAdapter(context,fiveDayList);
                recyclerView.setAdapter(recyclerviewAdapter);

            }

            @Override
            public void onFailure(Call<model2> call, Throwable t) {

            }
        });
    }



        private String convertTimeToDay(String time){
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:SSSS", Locale.getDefault());
            String days = "";
            try {
                java.util.Date date = format.parse(time);
                System.out.println("Our time " + date);
                Calendar calendar = Calendar.getInstance();
                calendar.setTime(date);
                days = calendar.getDisplayName(Calendar.DAY_OF_WEEK, Calendar.SHORT, Locale.getDefault());
                System.out.println("Our time " + days);
            } catch (ParseException e) {
                e.printStackTrace();
            }
            return days;
        }
}
