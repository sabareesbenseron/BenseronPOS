package com.example.saku1.benseronemv.Controller;

import android.util.Log;

import com.example.saku1.benseronemv.Model.CategoryModel;
import com.example.saku1.benseronemv.Model.MenuItemModel;
import com.example.saku1.benseronemv.Model.SubCategoryModel;

import java.util.List;

/**
 * Created by saku1 on 4/2/2017.
 */

public class CategoryController {
    private static final String TAG = "CategoryController";

    private CategoryController(){

    }
    private static CategoryController instance = null;

    public static CategoryController getInstance(){
        if (instance == null) instance = new CategoryController();
        return instance;
    }

    private static List<CategoryModel> categoryModelList;
    private static List<SubCategoryModel> subCategoryModelList;
    private static List<MenuItemModel> menuItemModelList;

    public static List<CategoryModel> getCategoryModelList() {
        return categoryModelList;
    }

    public static void setCategoryModelList(List<CategoryModel> categoryModels) {
        categoryModelList = categoryModels;
        Log.e(TAG, "setCategoryModelList: size "+categoryModelList.size() );
    }

    public static List<SubCategoryModel> getSubCategoryModelList() {
        return subCategoryModelList;
    }

    public static void setSubCategoryModelList(List<SubCategoryModel> subCategoryModels) {
        subCategoryModelList = subCategoryModels;
        Log.e(TAG, "setSubCategoryModelList: size "+subCategoryModelList.size() );
    }

    public static List<MenuItemModel> getMenuItemModelList() {
        return menuItemModelList;
    }

    public static void setMenuItemModelList(List<MenuItemModel> menuItemModels) {
        menuItemModelList = menuItemModels;
        Log.e(TAG, "setMenuItemModelList: size "+menuItemModelList.size() );
    }
}
