package com.example.saku1.benseronemv.Activity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.saku1.benseronemv.ApiHolder.LoginHolder;
import com.example.saku1.benseronemv.Listener.OnHttpListener;
import com.example.saku1.benseronemv.Model.LoginModel;
import com.example.saku1.benseronemv.R;

public class LoginPage extends AppCompatActivity implements View.OnClickListener {

    private static final String TAG = "LoginPage";
    Button numberZeroBtn, numberOneBtn, numberTwoBtn, numberThreeBtn, numberFourBtn, numberFiveBtn, numberSixBtn,
            numberSevenBtn, numberEightBtn, numberNineBtn, clearBtn, loginBtn;
    ImageView bevoLogo;
    TextView passwordBox;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login__page);

        initViews();
        initActionListener();

    }

    private void initViews() {

        numberZeroBtn = (Button) findViewById(R.id.loginpage_number_zero);
        numberOneBtn = (Button) findViewById(R.id.loginpage_number_one);
        numberTwoBtn = (Button) findViewById(R.id.loginpage_number_two);
        numberThreeBtn = (Button) findViewById(R.id.loginpage_number_three);
        numberFourBtn = (Button) findViewById(R.id.loginpage_number_four);
        numberFiveBtn = (Button) findViewById(R.id.loginpage_number_five);
        numberSixBtn = (Button) findViewById(R.id.loginpage_number_six);
        numberSevenBtn = (Button) findViewById(R.id.loginpage_number_seven);
        numberEightBtn = (Button) findViewById(R.id.loginpage_number_eight);
        numberNineBtn = (Button) findViewById(R.id.loginpage_number_nine);
        clearBtn = (Button) findViewById(R.id.loginpage_clearbtn);
        loginBtn = (Button) findViewById(R.id.loginpage_loginbtn);

        bevoLogo = (ImageView) findViewById(R.id.loginpage_title);
        passwordBox = (TextView) findViewById(R.id.loginpage_password_field);
    }

    private void initActionListener() {

        numberZeroBtn.setOnClickListener(this);
        numberOneBtn.setOnClickListener(this);
        numberTwoBtn.setOnClickListener(this);
        numberThreeBtn.setOnClickListener(this);
        numberFourBtn.setOnClickListener(this);
        numberFiveBtn.setOnClickListener(this);
        numberSixBtn.setOnClickListener(this);
        numberSevenBtn.setOnClickListener(this);
        numberEightBtn.setOnClickListener(this);
        numberNineBtn.setOnClickListener(this);
        clearBtn.setOnClickListener(this);
        loginBtn.setOnClickListener(this);

    }

    String number = "";

    @Override
    public void onClick(View v) {

        switch (v.getId()) {

            case R.id.loginpage_number_zero:
                number = number + "0";
                passwordBox.setText(number);
                break;
            case R.id.loginpage_number_one:
                number = number + "1";
                passwordBox.setText(number);
                break;
            case R.id.loginpage_number_two:
                number = number + "2";
                passwordBox.setText(number);
                break;
            case R.id.loginpage_number_three:
                number = number + "3";
                passwordBox.setText(number);
                break;
            case R.id.loginpage_number_four:
                number = number + "4";
                passwordBox.setText(number);
                break;
            case R.id.loginpage_number_five:
                number = number + "5";
                passwordBox.setText(number);
                break;
            case R.id.loginpage_number_six:
                number = number + "6";
                passwordBox.setText(number);
                break;
            case R.id.loginpage_number_seven:
                number = number + "7";
                passwordBox.setText(number);
                break;
            case R.id.loginpage_number_eight:
                number = number + "8";
                passwordBox.setText(number);
                break;
            case R.id.loginpage_number_nine:
                number = number + "9";
                passwordBox.setText(number);
                break;
            case R.id.loginpage_clearbtn:
                passwordBox.setText("");
                number = "";
                break;
            case R.id.loginpage_loginbtn:
                loginTask(number);
                break;
        }
    }

    ProgressDialog progressDialog;

    private void loginTask(final String password) {
        progressDialog = new ProgressDialog(LoginPage.this);

        LoginHolder holder = new LoginHolder(password, new OnHttpListener<LoginModel>() {
            @Override
            public void onComplete(LoginModel model, boolean isValid) {

                Log.e(TAG, "onComplete: password " + password);
                Log.e(TAG, "onComplete: message " + model.getCode());
                Log.e(TAG, "onComplete: details " + model.getEmpModel().getName());
                progressDialog.dismiss();

                if (model != null) {
                    if (model.getCode().equals("1")) {
                        //valid login
                        showToast("Welcome, " + model.getEmpModel().getName());
                        Intent loginIntent = new Intent(LoginPage.this, CategoryActivity.class);
                        startActivity(loginIntent);
                        finish();
                    } else {
                        //invalid login
                        showToast(model.getMessage());
                        passwordBox.setText("");
                        number = "";
                    }
                } else {
                    showToast("Server not found");
                }
            }
        });
        holder.execute();
        progressDialog.show();
    }

    private void showToast(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }
}
