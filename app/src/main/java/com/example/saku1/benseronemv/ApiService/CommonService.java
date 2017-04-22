package com.example.saku1.benseronemv.ApiService;

import com.example.saku1.benseronemv.Model.CategoryModel;
import com.example.saku1.benseronemv.Model.GlobalCatModel;
import com.example.saku1.benseronemv.Model.LoginModel;
import com.example.saku1.benseronemv.Model.OrderModel;
import com.example.saku1.benseronemv.Model.PaymentModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

/**
 * Created by saku1 on 3/12/2017.
 */

public interface CommonService {
    @GET("get_all_data.php")
    Call<List<PaymentModel>> getAllData();
    @GET("GetEmployee/{password}")
    Call<LoginModel> getLoginData(@Path("password")String password);
    @GET("Getcategoryinfo")
    Call<List<CategoryModel>> getCategoryInfo();

    @GET("Getallitemsinfo")
    Call<GlobalCatModel> getAllCategoryData();

    @POST("Order/GetSampleOrder/{orderModel}")
    Call<OrderModel> sendOrder(@Body OrderModel orderModel);
}
