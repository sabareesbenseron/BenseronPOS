package com.example.saku1.benseronemv.ApiHolder;

import android.os.AsyncTask;

import com.example.saku1.benseronemv.ApiService.CommonService;
import com.example.saku1.benseronemv.Listener.OnHttpListener;
import com.example.saku1.benseronemv.Model.GlobalCatModel;
import com.example.saku1.benseronemv.Utils.Config;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by saku1 on 4/2/2017.
 */

public class GlobalCatHolder extends AsyncTask<Void,Void,GlobalCatModel> {

    private OnHttpListener<GlobalCatModel> listener;

    public GlobalCatHolder(OnHttpListener<GlobalCatModel> listener) {
        this.listener = listener;
    }

    @Override
    protected GlobalCatModel doInBackground(Void... params) {

        Gson gson = new GsonBuilder()
                .setLenient()
                .create();

        Retrofit retrofit=new Retrofit.Builder()
                .baseUrl(Config.LOGIN_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        CommonService service = retrofit.create(CommonService.class);

        Call<GlobalCatModel> call = service.getAllCategoryData();


        try {
            return call.execute().body();
        } catch (IOException e) {
            return null;
        }

    }

    @Override
    protected void onPostExecute(GlobalCatModel globalCatModel) {
        super.onPostExecute(globalCatModel);

        if (globalCatModel!=null) listener.onComplete(globalCatModel,true);
        else listener.onComplete(null,false);
    }
}
