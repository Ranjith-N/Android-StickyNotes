package com.example.stickynotes.util;

import android.content.Context;
import android.widget.TextView;

import com.example.stickynotes.bean.Note;
import com.example.stickynotes.dao.Appdatabase;

import java.util.List;

import androidx.room.Room;

public class DisplayUtil {

    public static List<Note> getNotes(Context context){

        Appdatabase db = Appdatabase.getDataBase(context);
        List<Note> notes = db.NoteDao().getAllNotes();

        return notes;
    }
}
