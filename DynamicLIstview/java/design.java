package aidev.com.androiddesigns;

import android.app.Activity;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ListView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class design extends AppCompatActivity {


    private  ListView listView;
    private  ArrayList<Initialiser> al;
    private Initialiser initialiser;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_design);


        initialiser();
        dataSource();
    }

    private void dataSource() {

        String url = "http://api.aladhan.com/timingsByCity?city=Hyderabad&country=India&method=8";

        MyTask tk= new MyTask();
        tk.execute(url);

    }

    private void initialiser() {

        listView = (ListView)findViewById(R.id.listview);
        al = new ArrayList<Initialiser>();
    }
    private class MyTask extends AsyncTask<String, Void,Void>
    {

        @Override
        protected void onPreExecute() {
            super.onPreExecute();

        }


        @Override
        protected void onPostExecute(Void androidAdapter) {


        }

        @Override
        protected Void doInBackground(String... strings) {

            StringRequest stringRequest = new StringRequest(Request.Method.GET, strings[0], new Response.Listener<String>() {
                @Override
                public void onResponse(String response) {



                    try {

                        JSONObject baseJsonResponse = new JSONObject(response);
                        JSONObject  data = baseJsonResponse.getJSONObject("data");
                        JSONObject  timings = data.getJSONObject("timings");
                        JSONObject  date = data.getJSONObject("date");
                        String readable = date.getString("readable");
                        JSONObject  meta = data.getJSONObject("meta");
                        String timezone = meta.getString("timezone");

                        int i=1;

                        switch(i=1)
                        {
                            case 1:

                                String fajr = timings.getString("Fajr");
                                Initialiser homeInitialiser = new Initialiser(" Fajr     : " +fajr ,"Date  : " +readable , "TimeZone : "+timezone);
                                al.add(homeInitialiser);
                            case 2:
                                String sunrise = timings.getString("Sunrise");
                                Initialiser homeInitialiser1 = new Initialiser(" Sunrise : " +sunrise ,"Date  : "+readable ,"TimeZone : "+timezone);
                                al.add(homeInitialiser1);
                            case 3:
                                String dhuhr = timings.getString("Dhuhr");
                                Initialiser homeInitialiser2 = new Initialiser(" Zohar   : " +dhuhr ,"Date  : "+readable ,"TimeZone : "+timezone);
                                al.add(homeInitialiser2) ;

                            case 4:
                                String asrr = timings.getString("Asr");
                                Initialiser homeInitialiser3 = new Initialiser(" Asar    : " +asrr ,"Date  : "+readable ,"TimeZone : "+timezone);
                                al.add(homeInitialiser3);

                            case 5:
                                String sunset = timings.getString("Sunset");
                                Initialiser homeInitialiser4 = new Initialiser(" SunSet  : " +sunset ,"Date  : "+readable ,"TimeZone : "+timezone);
                                al.add(homeInitialiser4);

                            case 6:
                                String magrib = timings.getString("Maghrib");
                                Initialiser homeInitialiser5 = new Initialiser(" Magrib  : " +magrib ,"Date  : "+readable ,"TimeZone : "+timezone);
                                al.add(homeInitialiser5);
                            case 7:
                                String isha = timings.getString("Isha");
                                Initialiser homeInitialiser6 = new Initialiser(" Isha    : " +isha ,"Date  : "+readable ,"TimeZone : "+timezone);
                                al.add(homeInitialiser6);

                            case 8:
                                String imask = timings.getString("Imsak");
                                Initialiser homeInitialiser7 = new Initialiser(" Imsak   : " +imask ,"Date  : "+readable ,"TimeZone : "+timezone);
                                al.add(homeInitialiser7);


                            case 9:
                                String midnight = timings.getString("Midnight");
                                Initialiser homeInitialiser8 = new Initialiser(" MidNight : " +midnight ,"Date  : "+readable ,"TimeZone : "+timezone);
                                al.add(homeInitialiser8);
                                break;


                        }

                    } catch (JSONException e) {

                        Log.e("QueryUtils", "Problem parsing the earthquake JSON results", e);
                    }

                    Adapter adapter = new Adapter(design.this,al);
                    listView.setAdapter(adapter);

                }
            }

                    , new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {

                    Toast.makeText(getApplicationContext(),""+error, Toast.LENGTH_LONG).show();

                }
            });

            RequestQueue requestQueue = Volley.newRequestQueue(design.this);
            requestQueue.add(stringRequest);



            return null;
        }



    }

}
