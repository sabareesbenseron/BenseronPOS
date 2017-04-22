package com.example.saku1.benseronemv.ApiHolder;

import android.nfc.Tag;
import android.os.AsyncTask;
import android.util.Log;

import com.example.saku1.benseronemv.ApiService.CommonService;
import com.example.saku1.benseronemv.Listener.OnHttpListener;
import com.example.saku1.benseronemv.Model.CategoryModel;
import com.example.saku1.benseronemv.Utils.Config;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.util.List;

import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static android.content.ContentValues.TAG;

/**
 * Created by saku1 on 4/2/2017.
 */

public class CategoryHolder extends AsyncTask<Void, Void, List<CategoryModel>> {

    private OnHttpListener<List<CategoryModel>> listener;

    public CategoryHolder(OnHttpListener<List<CategoryModel>> listener) {
        this.listener = listener;
    }

    @Override
    protected List<CategoryModel> doInBackground(Void... params) {

        Gson gson = new GsonBuilder()
                .setLenient()
                .create();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Config.LOGIN_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        CommonService service = retrofit.create(CommonService.class);
        Call<List<CategoryModel>> call = service.getCategoryInfo();

        try{
            Response<List<CategoryModel>> response = call.execute();
            Log.e(TAG, "doInBackground: response "+gson.toJson(response.body()) );
            return response.body();
            } catch (IOException e) {
            Log.e(TAG, "doInBackground: exception "+e.getMessage());
            return null;
        }
    }

    @Override
    protected void onPostExecute(List<CategoryModel> categoryModel) {
        super.onPostExecute(categoryModel);

        if(categoryModel != null){

            listener.onComplete(categoryModel, true);
        }else {
            listener.onComplete(null, false);
        }
    }
}
