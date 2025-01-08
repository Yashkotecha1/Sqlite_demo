package com.example.sqlite_demo;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class AddActivity extends AppCompatActivity {

    EditText edt_booktitle,edt_Author,edt_bookpages;
    Button btn_submit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_add);

        FindViewByID();
Body();
    }

    private void Body()
    {
        btn_submit.setOnClickListener(view -> {

            try {
                DatabaseHelper dbh = new DatabaseHelper(AddActivity.this);
                dbh.addBook(edt_booktitle.getText().toString().trim(), edt_Author.getText().toString().trim(), Integer.parseInt(edt_bookpages.getText().toString().trim()));
                Intent intent = new Intent(AddActivity.this,MainActivity.class);
                startActivity(intent);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        });
    }

    private void FindViewByID()
    {
        edt_booktitle = findViewById(R.id.edt_booktitle);
        edt_bookpages = findViewById(R.id.edt_bookpages);
        edt_Author = findViewById(R.id.edt_Author);
        btn_submit = findViewById(R.id.btn_submit);
    }
}