package com.example.sqlite_demo;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class MainActivity extends AppCompatActivity {
RecyclerView recy_id;
FloatingActionButton btn_id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FindViewByID();
        Body();

    }

    private void Body()
    {
        btn_id.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i  = new Intent(MainActivity.this, AddActivity.class);
                startActivity(i);
            }
        });
    }

    private void FindViewByID()
    {
        recy_id = findViewById(R.id.recy_id);
        btn_id = findViewById(R.id.btn_id);
    }
}