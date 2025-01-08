package com.example.sqlite_demo;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
RecyclerView recy_id;
FloatingActionButton btn_id;
DatabaseHelper mydb;
ArrayList<String> book_id,book_title,book_author,book_pages;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FindViewByID();
        Body();

    }

    private void Body()
    {

        mydb = new DatabaseHelper(MainActivity.this);

        book_id =new ArrayList<>();
        book_title =new ArrayList<>();
        book_author =new ArrayList<>();
        book_pages =new ArrayList<>();

        btn_id.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i  = new Intent(MainActivity.this, AddActivity.class);
                startActivity(i);
            }
        });
        storeDataArray();

        CustomAdapter adapter = new CustomAdapter(MainActivity.this,book_id,book_title,book_author,book_pages);
        recy_id.setAdapter(adapter);
        recy_id.setLayoutManager(new LinearLayoutManager(MainActivity.this));
        }
    void storeDataArray()
    {
        Cursor cursor = mydb.getBook();
        if (cursor.getCount() != 0)
        {
            while (cursor.moveToNext())
            {
                book_id.add(cursor.getString(0));
                book_title.add(cursor.getString(1));
                book_author.add(cursor.getString(2));
                book_pages.add(cursor.getString(3));
            }
        }
    }

    private void FindViewByID()
    {
        recy_id = findViewById(R.id.recy_id);
        btn_id = findViewById(R.id.btn_id);
    }
}