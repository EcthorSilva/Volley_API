package com.example.volley_api;

import android.content.Context;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

public class MySingleton {

    //variaveis globais para conexão e para os protocolos de comunicação
    private static MySingleton myInstance;
    private RequestQueue requestQueue;
    private static Context myContext;


    public MySingleton(Context context) {
        myContext = context;
        requestQueue = getRequestQueue();
    }

    public RequestQueue getRequestQueue() {
        if (requestQueue == null) {
            requestQueue = Volley.newRequestQueue(myContext.getApplicationContext());
        }
        return requestQueue;
    }

    public static synchronized MySingleton getInstance(Context context) {
        if (myInstance == null) {
            myInstance = new MySingleton(context);
        }
        return myInstance;
    }

    public <T> void addToRequestQue(Request<T> request) {
        requestQueue.add(request);
    }
}
