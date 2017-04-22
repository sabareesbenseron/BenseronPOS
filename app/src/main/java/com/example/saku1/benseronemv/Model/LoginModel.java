package com.example.saku1.benseronemv.Model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

import java.util.jar.Attributes;

/**
 * Created by saku1 on 3/19/2017.
 */

public class LoginModel implements Parcelable{
    @SerializedName("ResponseMessage")
    private String message;
    @SerializedName("ResponseCode")
    private String code;
    @SerializedName("EmpData")
    private EmpModel empModel;

    public LoginModel(String message, String code, EmpModel empModel) {
        this.message = message;
        this.code = code;
        this.empModel = empModel;
    }

    public LoginModel() {
    }

    protected LoginModel(Parcel in) {
        message = in.readString();
        code = in.readString();
        empModel = in.readParcelable(EmpModel.class.getClassLoader());
    }

    public static final Creator<LoginModel> CREATOR = new Creator<LoginModel>() {
        @Override
        public LoginModel createFromParcel(Parcel in) {
            return new LoginModel(in);
        }

        @Override
        public LoginModel[] newArray(int size) {
            return new LoginModel[size];
        }
    };

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public EmpModel getEmpModel() {
        return empModel;
    }

    public void setEmpModel(EmpModel empModel) {
        this.empModel = empModel;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(message);
        dest.writeString(code);
        dest.writeParcelable(empModel, flags);
    }
}
