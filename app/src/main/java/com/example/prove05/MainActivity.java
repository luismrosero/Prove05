package com.example.prove05;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "BEFORE INTENT";

    private EditText edtChapter, edtVerse, edtBook;
    private Button btnEnter, btnLoad, btnSave;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        edtChapter = findViewById(R.id.edt_chapter);
        edtVerse = findViewById(R.id.edt_verse);
        edtBook = findViewById(R.id.edt_book);
        btnEnter = findViewById(R.id.btn_enter);
        btnLoad = findViewById(R.id.btn_load);
        btnSave = findViewById(R.id.btn_save);


        btnEnter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (!edtChapter.getText().toString().isEmpty()
                        && !edtVerse.getText().toString().isEmpty()
                        && !edtBook.getText().toString().isEmpty()){

                    Log.i(TAG, "About to create intent with " +
                            edtBook.getText().toString() + " " +
                            edtChapter.getText().toString() + ":"
                    +  edtBook.getText().toString());

                    Intent intent = new Intent(MainActivity.this, MainActivity2.class);
                    intent.putExtra("chapter", edtChapter.getText().toString());
                    intent.putExtra("verse", edtVerse.getText().toString());
                    intent.putExtra("book", edtBook.getText().toString());
                    startActivity(intent);
                }else{
                    Toast.makeText(MainActivity.this, "All is necesary", Toast.LENGTH_SHORT).show();
                }


            }
        });

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!edtChapter.getText().toString().isEmpty()
                        && !edtVerse.getText().toString().isEmpty()
                        && !edtBook.getText().toString().isEmpty()){

                    SharedPreferences preferences = getSharedPreferences("data", MODE_PRIVATE);
                    SharedPreferences.Editor editor = preferences.edit();
                    editor.putString("chapter", edtChapter.getText().toString());
                    editor.putString("verse", edtVerse.getText().toString());
                    editor.putString("book", edtBook.getText().toString());
                    editor.apply();


                    Toast.makeText(MainActivity.this, "the scripture was saved successfully.", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(MainActivity.this, "All is necesary", Toast.LENGTH_SHORT).show();
                }
            }
        });

        btnLoad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences preferences = getSharedPreferences("data", MODE_PRIVATE);
                String chapter = preferences.getString("chapter",null);
                String verse = preferences.getString("verse",null);
                String book = preferences.getString("book",null);


                if (book != null){
                    edtBook.setText(book);
                }

                if (verse != null){
                    edtVerse.setText(verse);
                }

                if (chapter != null){
                    edtChapter.setText(chapter);
                }
            }
        });

    }
}