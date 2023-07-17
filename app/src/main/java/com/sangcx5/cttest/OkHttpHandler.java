package com.sangcx5.cttest;

import android.os.AsyncTask;
import android.util.Log;
import com.appmattus.certificatetransparency.CTInterceptorBuilder;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class OkHttpHandler extends AsyncTask<String, Void, String> {

    CTInterceptorBuilder builder = new CTInterceptorBuilder();
    Interceptor networkInterceptor = builder.build();
    OkHttpClient client = new OkHttpClient.Builder().addNetworkInterceptor(networkInterceptor).build();

    @Override
    protected String doInBackground(String... params) {

        Request.Builder builder = new Request.Builder();
        builder.url(params[0]);

        Request request = builder.build();

        try {
            Response response = client.newCall(request).execute();
            return response.body().string();
        } catch (Exception e) {
            Log.d("Request Error", e.getMessage());
            return "Connect failed";
        }
    }
}
