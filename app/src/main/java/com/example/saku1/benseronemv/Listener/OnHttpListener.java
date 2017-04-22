package com.example.saku1.benseronemv.Listener;

import com.example.saku1.benseronemv.Model.PaymentModel;

import java.util.List;

/**
 * Created by saku1 on 3/12/2017.
 */

public interface OnHttpListener<R> {
    //void onComplete(List<PaymentModel> list);
    void onComplete(R model,boolean isValid);
}
