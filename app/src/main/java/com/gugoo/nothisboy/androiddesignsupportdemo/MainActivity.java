package com.gugoo.nothisboy.androiddesignsupportdemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.gugoo.nothisboy.androiddesignsupportdemo.ui.CoodinatorActivity;
import com.gugoo.nothisboy.androiddesignsupportdemo.ui.RecyclerCardActivity;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button button_coodinator;
    private Button button_recycler_card;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button_coodinator = (Button) findViewById(R.id.button_coodinator);
        button_recycler_card = (Button) findViewById(R.id.button_recycler_card);

        button_coodinator.setOnClickListener(this);
        button_recycler_card.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button_coodinator:
                startActivity(new Intent(this, CoodinatorActivity.class));
                break;
            case R.id.button_recycler_card:
                startActivity(new Intent(this, RecyclerCardActivity.class));
                break;
            default:
                break;
        }
    }
}
