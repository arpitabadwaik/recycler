package com.example.admin1.recycleapplication.volley;

import android.content.Intent;
import android.renderscript.RenderScript;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.NetworkError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.admin1.recycleapplication.R;
import com.example.admin1.recycleapplication.activity.RecyclerActivity;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import org.json.JSONObject;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Queue;

public class APIActivity extends AppCompatActivity{

    private TextView txtA, txtB;
    ArrayList<UserList.UserDataList> mUserDataList = new ArrayList<>();
    String MAIN_URL, DOMAIN_URL, BASE_URL;
    int numberOfRequestsCompleted;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_api);

        txtA = findViewById(R.id.txt_a);
        txtB = findViewById(R.id.txt_b);

        Response.ErrorListener errorListener = new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                if (error instanceof NetworkError) {
                    Toast.makeText(getApplicationContext(), "No network available", Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(getApplicationContext(), error.toString(), Toast.LENGTH_LONG).show();
                }
            }
        };
    }

    private void GETStringAndJSONRequest(String page_1, String page_2){
        mUserDataList.clear();
        numberOfRequestsCompleted = 0;
        VolleyLog.DEBUG = true;
        SingletonRequestQueue queue = SingletonRequestQueue.getInstance(getApplicationContext());
        String uriPageOne = String.format(BASE_URL + "/api/users?page=%1$s", page_1);
        final String uri_page_two = String.format(BASE_URL + "/api/users?page=%1$s", page_2);
    }

        StringRequest stringRequest = new StringRequest(Request.Method.GET, "api/users?page=%1$s", new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                VolleyLog.wtf(response, "utf-8");
                GsonBuilder builder = new GsonBuilder();
                Gson mGson = builder.create();
                UserList userList = mGson.fromJson(response, UserList.class);
                mUserDataList.addAll(userList.userDataList);
                ++numberOfRequestsCompleted;
            }
        }, errorListener){
            public Priority getPriority() {
                return Priority.LOW;bad
            }
        };
            queue.add(stringRequest);

        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest("api/users?page=%1$s", null, new Response.Listener<JSONObject>() {
        @Override
                public void onResponse(JSONObject response) {

                VolleyLog.wtf(response.toString(), "utf-8");
                GsonBuilder builder = new GsonBuilder();
                Gson mGson = builder.create();

                UserList userList = mGson.fromJson(response.toString(), UserList.class);
                mUserDataList.addAll(userList.userDataList);
                ++numberOfRequestsCompleted;

            }
        }, errorListener) {

            public String getBodyContentType() {
                return "application/json";
            }

            public Priority getPriority() {
                return Priority.IMMEDIATE;
            }
        };

        queue.add(jsonObjectRequest);

        queue.addRequestFinishedListener(new RequestQueue.RequestFinishedListener<Object>() {

        public void onRequestFinished(Request<Object> request) {
            try {
                if (request.getCacheEntry() != null) {
                    String cacheValue = new String(request.getCacheEntry().data, "UTF-8");
                    VolleyLog.d(request.getCacheKey() + " " + cacheValue);

                }
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }

            if (numberOfRequestsCompleted == 2) {
                numberOfRequestsCompleted = 0;
                startActivity(new Intent(APIActivity.this, RecyclerActivity.class).putExtra("users", mUserDataList));
            }
        }
    };
}
