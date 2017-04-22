package com.example.saku1.benseronemv.Model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

/**
 * Created by saku1 on 4/1/2017.
 */

public class SubCategoryModel implements Parcelable {

    @SerializedName("CategoryID")
    private String categoryid;
    @SerializedName("SubCategoryID")
    private String subcategoryid;
    @SerializedName("SubCategoryName")
    private String getSubcategoryname;

    public SubCategoryModel(String categoryid, String subcategoryid, String getSubcategoryname) {
        this.categoryid = categoryid;
        this.subcategoryid = subcategoryid;
        this.getSubcategoryname = getSubcategoryname;
    }

    public SubCategoryModel() {
    }

    protected SubCategoryModel(Parcel in) {
        categoryid = in.readString();
        subcategoryid = in.readString();
        getSubcategoryname = in.readString();
    }

    public static final Creator<SubCategoryModel> CREATOR = new Creator<SubCategoryModel>() {
        @Override
        public SubCategoryModel createFromParcel(Parcel in) {
            return new SubCategoryModel(in);
        }

        @Override
        public SubCategoryModel[] newArray(int size) {
            return new SubCategoryModel[size];
        }
    };

    public String getCategoryid() {
        return categoryid;
    }

    public void setCategoryid(String categoryid) {
        this.categoryid = categoryid;
    }

    public String getSubcategoryid() {
        return subcategoryid;
    }

    public void setSubcategoryid(String subcategoryid) {
        this.subcategoryid = subcategoryid;
    }

    public String getGetSubcategoryname() {
        return getSubcategoryname;
    }

    public void setGetSubcategoryname(String getSubcategoryname) {
        this.getSubcategoryname = getSubcategoryname;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(categoryid);
        dest.writeString(subcategoryid);
        dest.writeString(getSubcategoryname);
    }
}
