package com.example.stickynotes.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.stickynotes.bean.Note;
import com.example.stickynotes.dao.Appdatabase;
import com.example.stickynotes.util.DataUtil;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.lang.reflect.Array;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

public class EditNotesActivity extends AppCompatActivity {

    private int noteId = 0;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_delete:
                    delete();
                    return true;
                case R.id.navigation_share:
                    share();
                    return true;
                case R.id.navigation_update:
                    update();
                    return true;
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.edit_notes);
        Intent intent = getIntent();
        noteId = intent.getIntExtra(MainActivity.NOTES,0);
        Appdatabase db = Appdatabase.getDataBase(getApplicationContext());
        Note note = db.NoteDao().getNote(noteId);
        EditText textView = (EditText) findViewById(R.id.edit_text_notes);
        textView.setText(note.getNote());
        /*Button editButton = (Button) this.findViewById(R.id.navigation_update);
        editButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText textView = (EditText) findViewById(R.id.edit_text_notes);
               int result =  DataUtil.updateNote(noteId, textView.getText().toString(), getApplicationContext());
                Toast.makeText(getApplicationContext(), "Notes updated sucessfully", Toast.LENGTH_LONG)
                        .show();
            }
        });

        Button deleteButton = (Button) this.findViewById(R.id.navigation_delete);
        deleteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });*/

        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
    }

    private void delete(){
        EditText textView = (EditText) findViewById(R.id.edit_text_notes);
        DataUtil.deleteNote(noteId, getApplicationContext());
        Toast.makeText(getApplicationContext(), "Notes deleted sucessfully", Toast.LENGTH_LONG)
                .show();
        finish();
    }

    private void update(){
        EditText textView = (EditText) findViewById(R.id.edit_text_notes);
        int result =  DataUtil.updateNote(noteId, textView.getText().toString(), getApplicationContext());
        Toast.makeText(getApplicationContext(), "Notes updated sucessfully", Toast.LENGTH_LONG)
                .show();
    }

    private void share(){
        Intent sendIntent = new Intent();
        sendIntent.setAction(Intent.ACTION_SEND);
        EditText textView = (EditText) findViewById(R.id.edit_text_notes);
        sendIntent.putExtra(Intent.EXTRA_TEXT, textView.getText().toString());
        sendIntent.setType("text/plain");
        startActivity(sendIntent);
    }

}