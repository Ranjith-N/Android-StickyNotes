package com.example.stickynotes.dao;

import android.content.Context;

import com.example.stickynotes.bean.Note;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {Note.class}, version = 2)
public abstract class Appdatabase extends RoomDatabase {
    public abstract NoteDao NoteDao();
    private static Appdatabase db = null;
    public static Appdatabase getDataBase(Context context){
        if(db == null) {
            db = Room.databaseBuilder(context.getApplicationContext(),
                    Appdatabase.class, "notesDb").allowMainThreadQueries().build();
        }
        return db;
    }
}
