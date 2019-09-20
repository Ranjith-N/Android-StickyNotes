package com.example.stickynotes.activity;

import android.content.Intent;
import android.os.Bundle;

import com.example.stickynotes.adapter.NotesAdapter;
import com.example.stickynotes.bean.Note;
import com.example.stickynotes.dao.Appdatabase;
import com.example.stickynotes.dialog.AddNotesDialog;
import com.example.stickynotes.util.DisplayUtil;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.ListView;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    public static final String NOTES = "com.example.stickynotes.activity.NOTES";


    private NotesAdapter notesadapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
     //   mTextMessage = (TextView) findViewById(R.id.message);
        List<Note> notes =  DisplayUtil.getNotes(getApplicationContext());
        notesadapter = new NotesAdapter(this,notes);
        ListView listView = (ListView) findViewById(R.id.listview);
        listView.setAdapter(notesadapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                Note note = (Note) adapterView.getItemAtPosition(i);

                Intent editNotes = new Intent(MainActivity.this, EditNotesActivity.class);
                editNotes.putExtra(NOTES, note.getNoteid());
                startActivity(editNotes);
            }
        });

    }

    @Override
    public void onResume(){
        super.onResume();
        List<Note> notes =  DisplayUtil.getNotes(getApplicationContext());
        notesadapter.refreshEvents(notes);
    }

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        List<Note> notes =  DisplayUtil.getNotes(getApplicationContext());
        notesadapter.refreshEvents(notes);
    }

    public void addNotesButton(View view){
        AddNotesDialog dialog = new AddNotesDialog();
        dialog.show(getSupportFragmentManager(),"dialog");
       // List<Note> notes =  DisplayUtil.refreshAndGetNotes(getApplicationContext());
    }

}
