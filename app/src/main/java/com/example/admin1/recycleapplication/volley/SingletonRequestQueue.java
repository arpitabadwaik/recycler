package com.example.admin1.recycleapplication.volley;

import android.content.Context;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

public class SingletonRequestQueue {

    private static SingletonRequestQueue singletonRequestQueue;
    private Context mContext;
    private RequestQueue requestQueue;

    private SingletonRequestQueue(Context context){
        mContext = context;
        requestQueue = getRequestQueue();
    }

    public static synchronized SingletonRequestQueue getInstance(Context context){
        if(singletonRequestQueue == null)
            singletonRequestQueue = new  SingletonRequestQueue(context);
        return singletonRequestQueue;
    }

    public RequestQueue getRequestQueue(){
        if(requestQueue == null)
            requestQueue = Volley.newRequestQueue(mContext);
        return requestQueue;
    }
}
