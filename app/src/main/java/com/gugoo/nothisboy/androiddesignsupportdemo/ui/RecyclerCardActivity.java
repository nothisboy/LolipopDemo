package com.gugoo.nothisboy.androiddesignsupportdemo.ui;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

import com.gugoo.nothisboy.androiddesignsupportdemo.R;
import com.gugoo.nothisboy.androiddesignsupportdemo.ui.fragment.ListRecyclerFragment;
import com.gugoo.nothisboy.androiddesignsupportdemo.ui.fragment.StaggeredGridFragment;


/**
 * Created by nothisboy on 16/3/31.
 */
public class RecyclerCardActivity extends AppCompatActivity {

    public static final String TAG_FRA_LIST_RECYCLER = "TAG_FRA_LIST_RECYCLER";
    public static final String TAG_FRA_STAGGERED_GRID = "TAG_FRA_STAGGERED_GRID";

    private Toolbar toolbar_recycler_card;
    private TabLayout tab_recycler_card;


    private ListRecyclerFragment listRecyclerFragment;
    private StaggeredGridFragment staggeredGridFragment;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycle_card);


//        button_list_recycler = (Button) findViewById(R.id.button_list_recycler);

        initLayout();
        initValue();
        initListener();
    }

    private void initLayout() {
        toolbar_recycler_card = (Toolbar) findViewById(R.id.toolbar_recycler_card);
        tab_recycler_card = (TabLayout) findViewById(R.id.tab_recycler_card);
    }

    private void initValue() {
        listRecyclerFragment = new ListRecyclerFragment();
        staggeredGridFragment = new StaggeredGridFragment();

        getSupportFragmentManager().beginTransaction().add(R.id.frame_fragment_recycler_card, listRecyclerFragment, TAG_FRA_LIST_RECYCLER).commit();
        getSupportFragmentManager().beginTransaction().add(R.id.frame_fragment_recycler_card, staggeredGridFragment, TAG_FRA_STAGGERED_GRID).commit();
        getSupportFragmentManager().beginTransaction().hide(staggeredGridFragment).commit();

        tab_recycler_card.addTab(tab_recycler_card.newTab().setText("列表"));
        tab_recycler_card.addTab(tab_recycler_card.newTab().setText("瀑布流"));

    }


    private void initListener() {
        tab_recycler_card.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                switch (tab.getPosition()) {
                    case 0:
                        getSupportFragmentManager().beginTransaction().hide(staggeredGridFragment).show(listRecyclerFragment).commit();
                        break;
                    case 1:
                        getSupportFragmentManager().beginTransaction().hide(listRecyclerFragment).show(staggeredGridFragment).commit();
                        break;
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }


}
