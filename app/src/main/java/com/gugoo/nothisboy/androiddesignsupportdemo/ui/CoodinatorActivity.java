package com.gugoo.nothisboy.androiddesignsupportdemo.ui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.ImageView;
import android.widget.TextView;

import com.gugoo.nothisboy.androiddesignsupportdemo.R;

/**
 * Created by nothisboy on 16/3/29.
 */
public class CoodinatorActivity extends AppCompatActivity {

    private Toolbar toolbarCoor;
    private ImageView imgTop;
    private TextView textContent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_coordinator);

        initLayout();
        initValue();
    }

    private void initLayout() {
        textContent = (TextView) findViewById(R.id.text_coor_content);
        toolbarCoor = (Toolbar) findViewById(R.id.toolbar_coordina);
    }

    private void initValue() {
        toolbarCoor.setTitle("Android MVVM探讨");
        toolbarCoor.setSubtitle("知乎");
        setSupportActionBar(toolbarCoor);
        textContent.setText(getResources().getText(R.string.text_coor_content));
    }
}
