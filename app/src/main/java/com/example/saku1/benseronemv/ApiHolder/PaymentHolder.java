package com.example.saku1.benseronemv.ApiHolder;

import android.os.AsyncTask;
import android.util.Log;

import com.example.saku1.benseronemv.ApiService.CommonService;
import com.example.saku1.benseronemv.Listener.OnHttpListener;
import com.example.saku1.benseronemv.Model.PaymentModel;
import com.example.saku1.benseronemv.Utils.Config;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.util.List;

import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by saku1 on 3/12/2017.
 */
public class PaymentHolder extends AsyncTask<Void, Void, List<PaymentModel>> {
    private static final String TAG = "PaymentHolder";

    private OnHttpListener<List<PaymentModel>> listener;

    public PaymentHolder(OnHttpListener listener) {
        this.listener = listener;
    }

    @Override
    protected List<PaymentModel> doInBackground(Void... params) {

        Gson gson = new GsonBuilder()
                .setLenient()
                .create();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Config.BASE_URL+"/satish_test/")
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();


        CommonService service = retrofit.create(CommonService.class);

        Call<List<PaymentModel>> call = service.getAllData();

        try {
            Response<List<PaymentModel>> response = call.execute();
            return response.body();
        } catch (IOException e) {
            Log.e(TAG, "doInBackground: exception " + e.getMessage());
            return null;
        }
    }

    @Override
    protected void onPostExecute(List<PaymentModel> paymentModel) {
        super.onPostExecute(paymentModel);

        if (paymentModel != null) {
            listener.onComplete(paymentModel,true);
        } else {
            listener.onComplete(null,false);
        }
    }
}
