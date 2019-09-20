package com.example.stickynotes.util;

import android.content.Context;
import android.view.View;

import com.example.stickynotes.bean.Note;
import com.example.stickynotes.dao.Appdatabase;
import com.example.stickynotes.dialog.AddNotesDialog;

import java.util.Date;
import java.util.List;

public class DataUtil {

    public static void insertNote(String notes, Context context){

        Appdatabase db = Appdatabase.getDataBase(context);
        Integer id = db.NoteDao().getmaxId();
        if(id == null){
            id = 0;
        }
        Note note = new Note(id+1,notes,(new Date()).toString());
        db.NoteDao().insert(note);
    }

    public static int updateNote(int id, String notes, Context context){

        Appdatabase db = Appdatabase.getDataBase(context);
        return db.NoteDao().updateNote(id, notes);
    }

    public static int deleteNote(int id, Context context){

        Appdatabase db = Appdatabase.getDataBase(context);
        return db.NoteDao().deleteNote(id);
    }
}
