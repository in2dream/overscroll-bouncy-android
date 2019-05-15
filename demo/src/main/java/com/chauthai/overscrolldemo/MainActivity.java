package com.chauthai.overscrolldemo;

import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

import java.util.logging.Logger;

public class MainActivity extends AppCompatActivity {
    private static final int SIZE = 15;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setupActionBar();
        setupRecyclerView();
    }

    private void setupActionBar() {
        final ActionBar actionBar = getSupportActionBar();

        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setHomeButtonEnabled(true);
            actionBar.setHomeAsUpIndicator(R.drawable.ic_menu_white_24dp);
            actionBar.setTitle("Inbox");
        }
    }

    private void setupRecyclerView() {
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(layoutManager);

        recyclerView.addOnItemTouchListener(
            new ItemClickListener(recyclerView.getContext(), recyclerView , new ItemClickListener.OnItemClickListener() {
                @Override public void onItemClick(View view, int position) {
                    Log.d("aa", "click");
                }

                @Override public void onLongItemClick(View view, int position) {

                }
            })
        );
        MyAdapter adapter = new MyAdapter(this, TestDataGenerator.generateTestData(SIZE));
        recyclerView.setAdapter(adapter);
    }
}
