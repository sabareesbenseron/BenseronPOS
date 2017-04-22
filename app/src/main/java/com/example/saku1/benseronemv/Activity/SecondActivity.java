package com.example.saku1.benseronemv.Activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.saku1.benseronemv.Model.PaymentModel;
import com.example.saku1.benseronemv.R;

public class SecondActivity extends AppCompatActivity implements View.OnClickListener{

    Button paybtn;
    TextView tableview, checkview, amountview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        initViews();
        PaymentModel model = getIntent().getExtras().getParcelable("payment");
        tableview.setText(model.getId());
        checkview.setText(model.getTitle());
        amountview.setText(model.getDescription());

    }

    private void initViews() {

        tableview = (TextView) findViewById(R.id.second_activity_table_view);
        checkview = (TextView) findViewById(R.id.second_activity_check_view);
        amountview = (TextView) findViewById(R.id.second_activity_amount_view);
        paybtn = (Button) findViewById(R.id.second_pay_btn);

    }

    @Override
    public void onClick(View v) {

    }
}
