package com.example.saku1.benseronemv.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

import com.example.saku1.benseronemv.Adapter.MenuItemAdapter;
import com.example.saku1.benseronemv.Adapter.SelectedItemAdapter;
import com.example.saku1.benseronemv.Adapter.SubCategoryAdapter;
import com.example.saku1.benseronemv.Controller.CategoryController;
import com.example.saku1.benseronemv.Controller.OrderController;
import com.example.saku1.benseronemv.Listener.OnItemClickListener;
import com.example.saku1.benseronemv.Model.CategoryModel;
import com.example.saku1.benseronemv.Model.MenuItemModel;
import com.example.saku1.benseronemv.Model.SubCategoryModel;
import com.example.saku1.benseronemv.R;
import com.example.saku1.benseronemv.Utils.Tag;

import java.util.ArrayList;
import java.util.List;

public class SubCategoryAndMenuScreenActivity extends AppCompatActivity implements View.OnClickListener {

    private static final String TAG = "SubCategoryAndMenuScree";

    RecyclerView subcategoryview, menuitemview, selecteditemview;
    SubCategoryAdapter subcategoryAdapter;
    MenuItemAdapter menuitemAdapter;
    SelectedItemAdapter selecteditemAdapter;
    List<SubCategoryModel> subcategorymodellist;
    List<MenuItemModel> menuitemmodellist, selecteditemmodellist;

    CategoryModel categoryModel;

    FloatingActionButton fab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub_category_and_menu_screen);

        categoryModel = getIntent().getExtras().getParcelable("model");

        initViews();
        initSubCategoryAdapter();
        initMenuItemAdapter();
        initSelectedItemAdapter();

        if (categoryModel!=null)
        updateAdapter(categoryModel);
        else
            Tag.showToast(SubCategoryAndMenuScreenActivity.this,"Unable to connect with server");
    }
    private void initViews(){
        //View Inflation

        subcategoryview = (RecyclerView) findViewById(R.id.activity_sub_category_and_menu_subcategory);
        menuitemview = (RecyclerView) findViewById(R.id.activity_sub_category_and_menu_menuitem);
        selecteditemview = (RecyclerView) findViewById(R.id.activity_sub_category_and_menu_selecteditem);

        fab= (FloatingActionButton) findViewById(R.id.sub_cat_next_btn);

        fab.setOnClickListener(this);
    }

    private void initSubCategoryAdapter(){
        //SubCategory

        LinearLayoutManager layoutManager = new LinearLayoutManager(SubCategoryAndMenuScreenActivity.this,
                LinearLayoutManager.HORIZONTAL, false);
        subcategoryview.setLayoutManager(layoutManager);

        subcategorymodellist = new ArrayList<>();
        subcategoryAdapter = new SubCategoryAdapter(SubCategoryAndMenuScreenActivity.this, subcategorymodellist);
        subcategoryview.setAdapter(subcategoryAdapter);

        subcategoryAdapter.seOnITemClickListener(new SubCategoryAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View v, int position) {
                updateMenuItemAdapter(subcategorymodellist.get(position));
            }
        });
    }

    private void initMenuItemAdapter(){
        //MenuItem

        GridLayoutManager layoutManager = new GridLayoutManager(SubCategoryAndMenuScreenActivity.this, 2);
        layoutManager.setOrientation(GridLayoutManager.VERTICAL);
        menuitemview.setLayoutManager(layoutManager);

        menuitemmodellist = new ArrayList<>();
        menuitemAdapter = new MenuItemAdapter(SubCategoryAndMenuScreenActivity.this, menuitemmodellist);
        menuitemview.setAdapter(menuitemAdapter);

        menuitemAdapter.setOnItemClickListner(new MenuItemAdapter.OnItemClickListner() {
            @Override
            public void onItemClick(View v, int position) {
                MenuItemModel model = menuitemmodellist.get(position);
                selecteditemmodellist.add(model);
                selecteditemAdapter.notifyDataSetChanged();
            }
        });
    }

    private void initSelectedItemAdapter(){
        //SelectedItem

        GridLayoutManager layoutManager = new GridLayoutManager(SubCategoryAndMenuScreenActivity.this, 3);
        layoutManager.setOrientation(GridLayoutManager.VERTICAL);
        selecteditemview.setLayoutManager(layoutManager);

        selecteditemmodellist = new ArrayList<>();
        selecteditemAdapter = new SelectedItemAdapter(SubCategoryAndMenuScreenActivity.this, selecteditemmodellist);
        selecteditemview.setAdapter(selecteditemAdapter);

        selecteditemAdapter.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItenClcik(View v, int position) {
                selecteditemmodellist.remove(position);
                selecteditemAdapter.notifyDataSetChanged();
            }
        });
    }

    private void updateAdapter(CategoryModel model){

        List<SubCategoryModel> subCategoryModels=new ArrayList<>();
        List<MenuItemModel> menuItemModels=new ArrayList<>();

        for(SubCategoryModel subModel : CategoryController.getSubCategoryModelList()){
            if (subModel.getCategoryid().equalsIgnoreCase(model.getCategoryid())){
                subCategoryModels.add(subModel);
            }
        }

        for (MenuItemModel menuModel : CategoryController.getMenuItemModelList()){
            if (menuModel.getCategoryid().equalsIgnoreCase(model.getCategoryid())){
                menuItemModels.add(menuModel);
            }
        }

        //updating subMenu adapter
        subcategorymodellist.clear();
        subcategorymodellist.addAll(subCategoryModels);
        subcategoryAdapter.notifyDataSetChanged();

        Log.e(TAG, "updateAdapter: sub CAt " + subcategorymodellist.size() );

        //updating menu item adapter
        menuitemmodellist.clear();
        menuitemmodellist.addAll(menuItemModels);
        menuitemAdapter.notifyDataSetChanged();
        Log.e(TAG, "updateAdapter: meun item  " + menuitemmodellist.size() );

    }

    private void updateMenuItemAdapter(SubCategoryModel model){
        menuitemmodellist.clear();
        for (MenuItemModel menuModel : CategoryController.getMenuItemModelList()){
            if (menuModel.getSubcategoryid().equalsIgnoreCase(model.getSubcategoryid())){
                menuitemmodellist.add(menuModel);
            }
        }
        menuitemAdapter.notifyDataSetChanged();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.sub_cat_next_btn:
                if (selecteditemmodellist.size()>0)
                {
                    OrderController.setOrderList(selecteditemmodellist);
                    Intent intent=new Intent(this,OrderActivity.class);
                    startActivity(intent);
                }else {
                    Tag.showToast(this,"Please select menu item to proceed");
                }
                break;
        }
    }
}
