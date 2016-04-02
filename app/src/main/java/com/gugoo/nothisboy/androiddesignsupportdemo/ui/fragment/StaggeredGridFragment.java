package com.gugoo.nothisboy.androiddesignsupportdemo.ui.fragment;

import android.graphics.Canvas;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.gugoo.nothisboy.androiddesignsupportdemo.R;
import com.gugoo.nothisboy.androiddesignsupportdemo.bean.PictureBean;
import com.gugoo.nothisboy.androiddesignsupportdemo.constant.Constants;
import com.gugoo.nothisboy.androiddesignsupportdemo.ui.adapter.ListRecyclerAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by nothisboy on 16/4/1.
 */
public class StaggeredGridFragment extends Fragment {

    private RecyclerView recycler_list_recycler;

    private ListRecyclerAdapter adapter;
    private List<PictureBean> listContent;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rView = inflater.inflate(R.layout.fragment_recycler, null);

        recycler_list_recycler = (RecyclerView) rView.findViewById(R.id.recycler_recycler);


        listContent = new ArrayList<>();
        getData();

        adapter = new ListRecyclerAdapter(getActivity(), listContent);
        StaggeredGridLayoutManager manager = new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL);
        recycler_list_recycler.setLayoutManager(manager);
        recycler_list_recycler.setAdapter(adapter);
        recycler_list_recycler.addItemDecoration(new RecyclerView.ItemDecoration() {
            @Override
            public void onDraw(Canvas c, RecyclerView parent, RecyclerView.State state) {
                super.onDraw(c, parent, state);
            }
        });

        return rView;
    }


    private void getData() {
        listContent.clear();

        for (int i = 0; i < Constants.netImgArray.length; i++) {
            PictureBean bean = new PictureBean();
            bean.content = Constants.netImgDescArray[i];
            bean.picUrl = Constants.netImgArray[i];
            listContent.add(bean);
        }
    }
}
