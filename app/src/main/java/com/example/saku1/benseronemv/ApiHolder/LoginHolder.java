package com.example.saku1.benseronemv.ApiHolder;

import android.os.AsyncTask;
import android.util.Log;

import com.example.saku1.benseronemv.ApiService.CommonService;
import com.example.saku1.benseronemv.Listener.OnHttpListener;
import com.example.saku1.benseronemv.Model.LoginModel;
import com.example.saku1.benseronemv.Utils.Config;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;

import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by saku1 on 3/18/2017.
 */

   public class LoginHolder extends AsyncTask<Void, Void, LoginModel>{
    private static final String TAG = "LoginHolder";

    private OnHttpListener<LoginModel> listener;
    private String password;

    public LoginHolder(String password,OnHttpListener<LoginModel> listener) {
        this.listener = listener;
        this.password = password;
    }


    @Override
    protected LoginModel doInBackground(Void... params) {

        Gson gson = new GsonBuilder()
                .setLenient()
                .create();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Config.LOGIN_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        CommonService service = retrofit.create(CommonService.class);
        Call<LoginModel> call = service.getLoginData(password);

        try{
            Response<LoginModel> response = call.execute();
            Log.e(TAG, "doInBackground: response "+gson.toJson( response.body()) );
            return response.body();
        } catch (IOException e) {
            Log.e(TAG, "doInBackground: exception "+e.getMessage());
            return null;
        }

    }

    @Override
    protected void onPostExecute(LoginModel loginModel) {

        super.onPostExecute(loginModel);

        if (loginModel != null){

            listener.onComplete(loginModel, true);
        } else {
            listener.onComplete(null, false);
        }

    }

}
