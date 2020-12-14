package com.example.madt_async;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;


import com.example.madt_async.AsyncDataLoader;
import com.example.madt_async.Constants;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private ListView lvItems;
    private TextView tvStatus;
    private ArrayAdapter listAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.lvItems = findViewById(R.id.lv_items);
        this.tvStatus = findViewById(R.id.tv_status);

        this.listAdapter = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_list_item_1, new ArrayList<>());
        this.lvItems.setAdapter(this.listAdapter);
    }

    @SuppressLint("StaticFieldLeak")
    public void onBtnGetDataClick(View view) {
        this.tvStatus.setText("Downloading the data...");
        new AsyncDataLoader() {
            @Override
            public void onPostExecute(List<String> result) {
                tvStatus.setText("Processed Data");
                listAdapter.clear();
                listAdapter.addAll(result);
                listAdapter.notifyDataSetChanged();
            }
        }.execute(Constants.FLOATRATES_API_URL);
    }
}