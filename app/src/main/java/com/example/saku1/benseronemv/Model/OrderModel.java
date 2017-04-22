package com.example.saku1.benseronemv.Model;

import java.util.Date;
import java.util.List;

/**
 * Created by kesavanT on 4/19/2017.
 */

public class OrderModel {


    public String id ;
    public String orderNumber ;
    public List<OrderDetail> orderDetails ;
    public String totalAmountStr ;
    public Boolean paymentPaid;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber;
    }

    public List<OrderDetail> getOrderDetails() {
        return orderDetails;
    }

    public void setOrderDetails(List<OrderDetail> orderDetails) {
        this.orderDetails = orderDetails;
    }

    public String getTotalAmountStr() {
        return totalAmountStr;
    }

    public void setTotalAmountStr(String totalAmountStr) {
        this.totalAmountStr = totalAmountStr;
    }





    public Boolean getPaymentPaid() {
        return paymentPaid;
    }

    public void setPaymentPaid(Boolean paymentPaid) {
        this.paymentPaid = paymentPaid;
    }


    public class OrderDetail
    {
        public String priceAmountStr ;
        public String quantity;
        public String itemTotalTax;
        public String miName ;
        public String miExternalID ;
        public String ssExternalID;

        public String getMiName() {
            return miName;
        }

        public void setMiName(String miName) {
            this.miName = miName;
        }



        public String getPriceAmountStr() {
            return priceAmountStr;
        }

        public void setPriceAmountStr(String priceAmountStr) {
            this.priceAmountStr = priceAmountStr;
        }

        public String getQuantity() {
            return quantity;
        }

        public void setQuantity(String quantity) {
            this.quantity = quantity;
        }

        public String getItemTotalTax() {
            return itemTotalTax;
        }

        public void setItemTotalTax(String itemTotalTax) {
            this.itemTotalTax = itemTotalTax;
        }

        public String getMiExternalID() {
            return miExternalID;
        }

        public void setMiExternalID(String miExternalID) {
            this.miExternalID = miExternalID;
        }

        public String getSsExternalID() {
            return ssExternalID;
        }

        public void setSsExternalID(String ssExternalID) {
            this.ssExternalID = ssExternalID;
        }



    }

}


