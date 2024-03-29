package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.text.SimpleDateFormat;
import java.util.Date;

public class AddtTaskActivity extends AppCompatActivity {

    EditText etTitle, etDescription;
    Button btnAddTask;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addt_task);
        etTitle = findViewById(R.id.et_title);
        etDescription = findViewById(R.id.et_description);
        btnAddTask = findViewById(R.id.btn_add_task);
        btnAddTask.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String title = etTitle.getText().toString();
                String description = etDescription.getText().toString();
                SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy  HH:mm");
                String date = sdf.format(new Date());
                if (!title.isEmpty() && !description.isEmpty()){
                    Intent intent = new Intent(AddtTaskActivity.this, MainActivity.class);
                    intent.putExtra("title", title);
                    intent.putExtra("description", description);
                    intent.putExtra("date", date);
                    setResult(RESULT_OK, intent);
                    finish();
                }
            }
        });
    }
}