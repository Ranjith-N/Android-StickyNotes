package com.example.stickynotes.dao;

import com.example.stickynotes.bean.Note;

import java.util.List;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

@Dao
public interface NoteDao {

    @Query("SELECT * FROM Note")
    List<Note> getAllNotes();

    @Insert
    void insert(Note notes);

    @Delete
    void delete(Note note);

    @Query("SELECT max(noteid) from Note")
    Integer getmaxId();

    @Query("SELECT * FROM Note where noteid = :noteID")
    Note getNote(int noteID);

    @Query("UPDATE Note SET note = :note WHERE noteid = :noteId")
    int updateNote(int noteId, String note);

    @Query("DELETE FROM Note WHERE noteid = :noteId")
    int deleteNote(int noteId);
}
