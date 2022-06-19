package com.example.mainpage;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.mainpage.Models.Notes;

import java.text.SimpleDateFormat;
import java.util.Date;

public class NotesTakerActivity extends AppCompatActivity {

    EditText editText_title, editText_notes;
    ImageView imageView_save;
    Notes notes;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notes_taker);

        editText_title = findViewById(R.id.editText_title);
        editText_notes = findViewById(R.id.editText_notes);
        imageView_save = findViewById(R.id.imageView_save);
        imageView_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String title = editText_title.getText().toString();
                String discription = editText_notes.getText().toString();

                if(discription.isEmpty()){
                    Toast.makeText(NotesTakerActivity.this,"Пожалуйста напишите что-нибудь",Toast.LENGTH_SHORT).show();
                    return;
                }
                SimpleDateFormat formatter = new SimpleDateFormat("yyyy.MM.dd G 'at' HH:mm:ss");
                Date date = new Date();
                notes = new Notes();
                notes.setTitle(title);
                notes.setNotes(discription);
                notes.setDate(formatter.format(date));

                Intent intent= new Intent();
                intent.putExtra("notes", notes);
                setResult(Activity.RESULT_OK,intent);
                finish();
            }
        });

    }
}