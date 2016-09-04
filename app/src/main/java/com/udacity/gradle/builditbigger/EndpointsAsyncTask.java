package com.udacity.gradle.builditbigger;

import android.os.AsyncTask;

import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.extensions.android.json.AndroidJsonFactory;
import com.google.api.client.googleapis.services.AbstractGoogleClientRequest;
import com.google.api.client.googleapis.services.GoogleClientRequestInitializer;
import com.knoxpo.backend.myApi.MyApi;

import java.io.IOException;

/**
 * Created by asus on 9/4/2016.
 */
public class EndpointsAsyncTask extends AsyncTask<Void, Void, String> {

    private static MyApi sApiService = null;

    @Override
    protected String doInBackground(Void... params) {
        if (sApiService == null) {
            MyApi.Builder builder = new MyApi.Builder(AndroidHttp.newCompatibleTransport(),
                    new AndroidJsonFactory(), null)
                    .setRootUrl("http://10.0.2.2:8080/_ah/api/")
                    .setGoogleClientRequestInitializer(new GoogleClientRequestInitializer() {
                        @Override
                        public void initialize(AbstractGoogleClientRequest<?> abstractGoogleClientRequest) throws IOException {
                            abstractGoogleClientRequest.setDisableGZipContent(true);
                        }
                    });

            sApiService = builder.build();

        }
        try {
            return sApiService.getJoke().execute().getData();
        } catch (IOException e) {
            return e.getMessage();
        }
    }
}