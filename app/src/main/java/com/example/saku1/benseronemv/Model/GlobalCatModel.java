package com.example.saku1.benseronemv.Model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by saku1 on 4/2/2017.
 */

public class GlobalCatModel {
    @SerializedName("CategoryItems")
    private List<CategoryModel> categoryModelList;
    @SerializedName("SubCategoryItems")
    private List<SubCategoryModel> subCategoryModelList;
    @SerializedName("MenuItems")
    private List<MenuItemModel> menuItemModelList;

    public GlobalCatModel(List<CategoryModel> categoryModelList,
                          List<SubCategoryModel> subCategoryModelList, List<MenuItemModel> menuItemModelList) {
        this.categoryModelList = categoryModelList;
        this.subCategoryModelList = subCategoryModelList;
        this.menuItemModelList = menuItemModelList;
    }

    public GlobalCatModel() {
    }

    public List<CategoryModel> getCategoryModelList() {
        return categoryModelList;
    }

    public void setCategoryModelList(List<CategoryModel> categoryModelList) {
        this.categoryModelList = categoryModelList;
    }

    public List<SubCategoryModel> getSubCategoryModelList() {
        return subCategoryModelList;
    }

    public void setSubCategoryModelList(List<SubCategoryModel> subCategoryModelList) {
        this.subCategoryModelList = subCategoryModelList;
    }

    public List<MenuItemModel> getMenuItemModelList() {
        return menuItemModelList;
    }

    public void setMenuItemModelList(List<MenuItemModel> menuItemModelList) {
        this.menuItemModelList = menuItemModelList;
    }
}
