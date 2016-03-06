package com.astro.vijay.unavu;

import android.content.Context;
import android.os.AsyncTask;
import android.support.v4.util.Pair;
import android.util.Log;

import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.extensions.android.json.AndroidJsonFactory;
import com.google.api.client.googleapis.services.AbstractGoogleClientRequest;
import com.google.api.client.googleapis.services.GoogleClientRequestInitializer;
import com.uttamavillain.unavu.backend.unavuApi.UnavuApi;
import com.uttamavillain.unavu.backend.unavuApi.model.FoodItem;

import java.io.IOException;
import java.util.List;

/**
 * Created by uttamavillain on 3/5/16.
 */
public class EndpointsAsyncTask extends AsyncTask<Pair<Context, String>, Void, List<FoodItem>> {
    public static final String TAG = EndpointsAsyncTask.class.getName();
    private static UnavuApi myApiService = null;
    private Context context;
    AsyncResponseListener mCallBack;

    public EndpointsAsyncTask(AsyncResponseListener mCallBack){
        this.mCallBack = mCallBack;
    }

    @Override
    protected List<FoodItem> doInBackground(Pair<Context, String>... params) {
        if(myApiService == null) {  // Only do this once
            UnavuApi.Builder builder = new UnavuApi.Builder(AndroidHttp.newCompatibleTransport(),
                    new AndroidJsonFactory(), null)
                    // options for running against local devappserver
                    // - 10.0.2.2 is localhost's IP address in Android emulator
                    // - turn off compression when running against local devappserver
                    .setRootUrl("http://10.0.2.2:8080/_ah/api/")
                    .setGoogleClientRequestInitializer(new GoogleClientRequestInitializer() {
                        @Override
                        public void initialize(AbstractGoogleClientRequest<?> abstractGoogleClientRequest) throws IOException {
                            abstractGoogleClientRequest.setDisableGZipContent(true);
                        }
                    });
            // end options for devappserver

            myApiService = builder.build();
        }

        context = params[0].first;
        String name = params[0].second;

        try {
            return myApiService.getFoods().execute().getItems();
        } catch (IOException e) {
            Log.e(TAG, "Error in retriving the list of food " + e.toString());
            return null;
        }
    }

    @Override
    protected void onPostExecute(List<FoodItem> result) {
        mCallBack.OnAsyncTaskCompleted(result);
    }

    public interface AsyncResponseListener {
        public void OnAsyncTaskCompleted(List<FoodItem> foodItems);
    }
}