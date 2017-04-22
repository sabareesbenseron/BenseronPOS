package com.example.saku1.benseronemv.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.saku1.benseronemv.Model.SubCategoryModel;
import com.example.saku1.benseronemv.R;

import java.util.List;

/**
 * Created by saku1 on 4/2/2017.
 */

public class SubCategoryAdapter extends RecyclerView.Adapter<SubCategoryAdapter.Holder> {
    private static final String TAG = "SubCategoryAdapter";
    private Context context;
    private List<SubCategoryModel> subCategoryModelList;

    private OnItemClickListener itemClickListener;

    public SubCategoryAdapter(Context context, List<SubCategoryModel> subCategoryModelList) {
        this.context = context;
        this.subCategoryModelList = subCategoryModelList;
    }

    public void seOnITemClickListener(OnItemClickListener listener){
        this.itemClickListener = listener;
    }

    @Override
    public SubCategoryAdapter.Holder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.item_adapter_subcategory_screen_layout, parent, false);
        return new Holder(view);
    }

    @Override
    public void onBindViewHolder(SubCategoryAdapter.Holder holder, final int position) {

        SubCategoryModel subCategoryModel = subCategoryModelList.get(position);
        holder.subCategoryText.setText(subCategoryModel.getGetSubcategoryname());

        holder.subCategoryText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (itemClickListener!=null){
                    itemClickListener.onItemClick(v,position);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
//        Log.e(TAG, "getItemCount: size "+subCategoryModelList.size() );
        return subCategoryModelList.size();
    }

    public class Holder extends RecyclerView.ViewHolder {

            TextView subCategoryText;

            public Holder(View itemView){
            super(itemView);

                subCategoryText = (TextView) itemView.findViewById(R.id.item_adapter_subcategory_screen_view);
        }
    }

    public interface OnItemClickListener{
        void onItemClick(View v,int position);
    }
}


