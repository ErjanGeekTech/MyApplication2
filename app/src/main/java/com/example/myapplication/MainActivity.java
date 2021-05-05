package com.example.myapplication;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView rvTask;
    private TaskAdapter adapter;

    TextView textView;
    FloatingActionButton btnOpenAddTask;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rvTask = findViewById(R.id.rv_task);
        btnOpenAddTask = findViewById(R.id.btn_open_add_task);
        textView = findViewById(R.id.item_title_txt);
        btnOpenAddTask.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, AddtTaskActivity.class);
                startActivityForResult(intent, 100);
            }
        });
        rvTask.setLayoutManager(new LinearLayoutManager(this));
        adapter = new TaskAdapter(this, MainActivity.this);
        rvTask.setAdapter(adapter);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 100 && resultCode == RESULT_OK){
            if (data != null) {
                Toast.makeText(this, data.getStringExtra("title") , Toast.LENGTH_SHORT).show();
                TaskModel model = new TaskModel(data.getStringExtra("title"), data.getStringExtra("description"), data.getStringExtra("date"));
                adapter.addTask(model);
            }
        }
    }
}