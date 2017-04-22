package com.example.saku1.benseronemv.Model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

/**
 * Created by saku1 on 3/27/2017.
 */

public class EmpModel implements Parcelable{
    @SerializedName("EmployeeEmail")
    private String EmployeeEmail;
    @SerializedName("EmployeeNo")
    private String EmployeeNo;
    @SerializedName("HomeAddress")
    private String HomeAddress;
    @SerializedName("Name")
    private String Name;

    public EmpModel(String EmployeeEmail, String EmployeeNo, String HomeAddress, String Name) {

        this.EmployeeEmail = EmployeeEmail;
        this.EmployeeNo = EmployeeNo;
        this.HomeAddress = HomeAddress;
        this.Name = Name;
    }

    public EmpModel(){

    }

    public static final Parcelable.Creator<LoginModel> CREATOR = new Parcelable.Creator<LoginModel>() {
        @Override
        public LoginModel createFromParcel(Parcel source) {
            return null;
        }

        @Override
        public LoginModel[] newArray(int size) {
            return new LoginModel[0];
        }
    };

    public String getEmployeeEmail() {
        return EmployeeEmail;
    }
    public void setEmployeeEmail(String EmployeeEmail) {
        this.EmployeeEmail = EmployeeEmail;
    }

    public String getEmployeeNo() {
        return EmployeeNo;
    }
    public void setEmployeeNo(String EmployeeNo) {
        this.EmployeeNo = EmployeeNo;
    }

    public String getHomeAddress() {
        return HomeAddress;
    }
    public void setHomeAddress(String HomeAddress) {
        this.HomeAddress = HomeAddress;
    }

    public String getName() {
        return Name;
    }
    public void setName(String Name) {
        this.Name = Name;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {

        dest.writeString(EmployeeEmail);
        dest.writeString(EmployeeNo);
        dest.writeString(HomeAddress);
        dest.writeString(Name);
    }
}
