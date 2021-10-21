package com.example.prove05;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {

    private TextView txtScripture;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        String chapter = getIntent().getStringExtra("chapter");
        String verse = getIntent().getStringExtra("verse");
        String book = getIntent().getStringExtra("book");


        txtScripture = findViewById(R.id.txt_scrptura);

        txtScripture.setText(book + " " + chapter + ":" + verse);



    }
}