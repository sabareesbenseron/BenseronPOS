package com.example.saku1.benseronemv.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.saku1.benseronemv.Model.CategoryModel;
import com.example.saku1.benseronemv.R;

import java.util.List;

/**
 * Created by saku1 on 4/1/2017.
 */

public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.Holder> {

    private Context context;
    private List<CategoryModel> categoryModelList;
    private CategoryAdapter.onItemClickListener listener;

    public CategoryAdapter(Context context, List<CategoryModel> categoryModelList) {
        this.context = context;
        this.categoryModelList = categoryModelList;
    }

    public void setOnItemClickListener(CategoryAdapter.onItemClickListener listener) {
        this.listener = listener;

    }

    @Override
    public CategoryAdapter.Holder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.item_adapter_category_screen_layout, parent, false);
        return new Holder(view);
    }

    @Override
    public void onBindViewHolder(CategoryAdapter.Holder holder, final int position) {

        CategoryModel categoryModel = categoryModelList.get(position);
        holder.categoryText.setText(categoryModel.getCategoryname());

        holder.categoryText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (listener != null) {
                    listener.onItemClick(v, position);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return categoryModelList.size();
    }

    public class Holder extends RecyclerView.ViewHolder {

        Button categoryText;

        public Holder(View itemView) {
            super(itemView);

            categoryText = (Button) itemView.findViewById(R.id.item_adapter_categoryscreen_category_view);
        }
    }

    public interface onItemClickListener {
        void onItemClick(View v, int position);
    }
}
