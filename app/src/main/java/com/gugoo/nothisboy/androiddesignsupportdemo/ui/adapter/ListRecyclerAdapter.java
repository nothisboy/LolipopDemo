package com.gugoo.nothisboy.androiddesignsupportdemo.ui.adapter;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.gugoo.nothisboy.androiddesignsupportdemo.R;
import com.gugoo.nothisboy.androiddesignsupportdemo.bean.PictureBean;
import com.squareup.picasso.Picasso;

import java.util.List;
import java.util.Map;

/**
 * Created by nothisboy on 16/3/31.
 */
public class ListRecyclerAdapter extends RecyclerView.Adapter<ListRecyclerAdapter.ListRecyclerHolder> {

    private List<PictureBean> listContent;
    private Context context;


    public ListRecyclerAdapter(Context context, List<PictureBean> listContent) {
        this.context = context;
        this.listContent = listContent;
    }

    @Override
    public ListRecyclerHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View rView = View.inflate(parent.getContext(), R.layout.item_recycle_list, null);
        return new ListRecyclerHolder(rView);
    }

    @Override
    public void onBindViewHolder(final ListRecyclerHolder holder, final int position) {
        holder.text_item_list_recycle.setText(listContent.get(position).content);
//        Picasso.with(context).load(Integer.valueOf(listContent.get(position).get("img").toString())).into(holder.img_item_list_recycler);
        Picasso.with(context).load(listContent.get(position).picUrl).into(holder.img_item_list_recycler);
    }

    @Override
    public int getItemCount() {
        return listContent.size();
    }

    public class ListRecyclerHolder extends RecyclerView.ViewHolder {

        public TextView text_item_list_recycle;
        public ImageView img_item_list_recycler;

        public ListRecyclerHolder(View itemView) {
            super(itemView);
            this.text_item_list_recycle = (TextView) itemView.findViewById(R.id.text_item_list_recycler);
            this.img_item_list_recycler = (ImageView) itemView.findViewById(R.id.img_item_list_recycler);
        }
    }
}
