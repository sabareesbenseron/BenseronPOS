package com.example.saku1.benseronemv.Activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.saku1.benseronemv.Adapter.MenuItemAdapter;
import com.example.saku1.benseronemv.ApiService.CommonService;
import com.example.saku1.benseronemv.Controller.OrderController;
import com.example.saku1.benseronemv.Model.MenuItemModel;
import com.example.saku1.benseronemv.Model.OrderModel;
import com.example.saku1.benseronemv.R;
import com.example.saku1.benseronemv.Utils.Config;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class OrderActivity extends AppCompatActivity  {

    private List<MenuItemModel> orderList;
    private MenuItemAdapter adapter;
    public Button bt_order;
    final static String URL = "http://192.168.2.162:58816/api/";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);


        RecyclerView orderRV = (RecyclerView) findViewById(R.id.order_rv);
        bt_order = (Button) findViewById(R.id.btn_order);
        orderOnClickListener();
        GridLayoutManager layoutManager = new GridLayoutManager(OrderActivity.this, 1);
        layoutManager.setOrientation(GridLayoutManager.VERTICAL);
        orderRV.setLayoutManager(layoutManager);

        orderList = new ArrayList<>();
        adapter = new MenuItemAdapter(OrderActivity.this, orderList);
        orderRV.setAdapter(adapter);

        updateAdapter();

    }

    private void updateAdapter(){
        orderList.clear();
        orderList.addAll(OrderController.getOrderList());
        adapter.notifyDataSetChanged();
    }

    private void orderOnClickListener(){

        bt_order.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                OrderModel orderMode = new OrderModel();
                orderMode.id = "1";
                orderMode.orderNumber = "21";
                orderMode.orderDetails = new ArrayList<OrderModel.OrderDetail>();
                OrderModel.OrderDetail order = orderMode.new OrderDetail();
                for (MenuItemModel i: OrderController.getOrderList()) {
                    order.priceAmountStr = "0.4";
                    order.quantity = i.getCategoryid();
                    order.itemTotalTax ="3";
                    order.miName = i.getMenuitemname();
                    order.miExternalID = i.getMenuitemid();
                    order.ssExternalID = "1";
                    orderMode.orderDetails.add(order);
                }
                orderMode.totalAmountStr = "5.00";
                orderMode.paymentPaid = false;

                Gson gson = new Gson();
                String json = gson.toJson(orderMode);
                Retrofit retrofit = new Retrofit.Builder()
                        .baseUrl(URL)
                        .addConverterFactory(GsonConverterFactory.create(gson))
                        .build();
                CommonService service = retrofit.create(CommonService.class);
                Call<OrderModel> call = service.sendOrder(orderMode);
               call.enqueue(new Callback<OrderModel>() {
                   @Override
                   public void onResponse(Call<OrderModel> call, Response<OrderModel> response) {
                          int statusCode = response.code();

                   }

                   @Override
                   public void onFailure(Call<OrderModel> call, Throwable t) {
                       Toast.makeText(OrderActivity.this,"Something went wrong",Toast.LENGTH_SHORT);
                   }
               });
            }
        });
    }
}
