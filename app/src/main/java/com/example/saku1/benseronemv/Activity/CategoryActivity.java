package com.example.saku1.benseronemv.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.example.saku1.benseronemv.Adapter.CategoryAdapter;
import com.example.saku1.benseronemv.ApiHolder.GlobalCatHolder;
import com.example.saku1.benseronemv.Controller.CategoryController;
import com.example.saku1.benseronemv.Listener.OnHttpListener;
import com.example.saku1.benseronemv.Model.CategoryModel;
import com.example.saku1.benseronemv.Model.GlobalCatModel;
import com.example.saku1.benseronemv.Model.MenuItemModel;
import com.example.saku1.benseronemv.Model.SubCategoryModel;
import com.example.saku1.benseronemv.R;
import com.example.saku1.benseronemv.Utils.Tag;

import java.util.ArrayList;
import java.util.List;

public class CategoryActivity extends AppCompatActivity implements CategoryAdapter.onItemClickListener {

  private static final String TAG = "CategoryActivity";

    RecyclerView categoryview;
    CategoryAdapter categoryAdapter;
    List<CategoryModel> categoryModelList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category_screen);

        categoryview = (RecyclerView) findViewById(R.id.categoryrecyclerview);

        GridLayoutManager layoutManager = new GridLayoutManager(CategoryActivity.this,2);
        layoutManager.setOrientation(GridLayoutManager.VERTICAL);
        categoryview.setLayoutManager(layoutManager);

        categoryModelList=new ArrayList<>();
        categoryAdapter = new CategoryAdapter(CategoryActivity.this, categoryModelList);
        categoryview.setAdapter(categoryAdapter);

        categoryAdapter.setOnItemClickListener(this);

        startTask();
    }

//    private void startTask(){
//        CategoryHolder holder =new CategoryHolder(new OnHttpListener<List<CategoryModel>>() {
//            @Override
//            public void onComplete(List<CategoryModel> model, boolean isValid) {
//                categoryModelList.clear();
//                categoryModelList.addAll(model);
//                categoryAdapter.notifyDataSetChanged();
//            }
//        });
//        holder.execute();
//    }

    private void startTask(){
        GlobalCatHolder holder =new GlobalCatHolder(new OnHttpListener<GlobalCatModel>() {
            @Override
            public void onComplete(GlobalCatModel model, boolean isValid) {
                if (model!=null){
                    //set data into controller
                    setDataIntoController(model);

                    updateAdapter();
                }else {
                    //IO exception
                    Tag.showToast(CategoryActivity.this,"Unable to connect with server");
                }
            }
        });
        holder.execute();
    }

    //set all data into controller
    private void setDataIntoController(GlobalCatModel model){
        CategoryController.setCategoryModelList(model.getCategoryModelList());
        CategoryController.setSubCategoryModelList(model.getSubCategoryModelList());
        CategoryController.setMenuItemModelList(model.getMenuItemModelList());
    }

    private void updateAdapter(){
        categoryModelList.clear();
        categoryModelList.addAll(CategoryController.getCategoryModelList());
        categoryAdapter.notifyDataSetChanged();
    }



    @Override
    public void onItemClick(View v, int position) {
        CategoryModel model = categoryModelList.get(position);
        Intent intent = new Intent(CategoryActivity.this, SubCategoryAndMenuScreenActivity.class);
        intent.putExtra("model",model);
        startActivity(intent);
    }


}
