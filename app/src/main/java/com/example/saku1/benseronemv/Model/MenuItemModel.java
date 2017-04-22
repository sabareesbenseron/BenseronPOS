package com.example.saku1.benseronemv.Model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

/**
 * Created by saku1 on 4/1/2017.
 */

public class MenuItemModel implements Parcelable {

    @SerializedName("CategoryID")
    private String categoryid;
    @SerializedName("SubCategoryID")
    private String subcategoryid;
    @SerializedName("MenuItemID")
    private String menuitemid;
    @SerializedName("MenuItemName")
    private String menuitemname;

    public MenuItemModel(String categoryid, String subcategoryid, String menuitemid, String menuitemname) {
        this.categoryid = categoryid;
        this.subcategoryid = subcategoryid;
        this.menuitemid = menuitemid;
        this.menuitemname = menuitemname;
    }

    public MenuItemModel() {
    }

    protected MenuItemModel(Parcel in) {
        categoryid = in.readString();
        subcategoryid = in.readString();
        menuitemid = in.readString();
        menuitemname = in.readString();
    }

    public static final Creator<MenuItemModel> CREATOR = new Creator<MenuItemModel>() {
        @Override
        public MenuItemModel createFromParcel(Parcel in) {
            return new MenuItemModel(in);
        }

        @Override
        public MenuItemModel[] newArray(int size) {
            return new MenuItemModel[size];
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

    public String getMenuitemid() {
        return menuitemid;
    }

    public void setMenuitemid(String menuitemid) {
        this.menuitemid = menuitemid;
    }

    public String getMenuitemname() {
        return menuitemname;
    }

    public void setMenuitemname(String menuitemname) {
        this.menuitemname = menuitemname;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(categoryid);
        dest.writeString(subcategoryid);
        dest.writeString(menuitemid);
        dest.writeString(menuitemname);
    }
}
