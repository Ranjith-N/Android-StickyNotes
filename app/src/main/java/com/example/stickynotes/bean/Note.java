package com.example.stickynotes.bean;

import java.util.Date;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Note {

    @PrimaryKey(autoGenerate = true)
    private int noteid;
    @ColumnInfo(name="note")
    private String note;
    @ColumnInfo(name="created")
    private String timestamp;

    public Note(int noteid, String note, String timestamp) {
        this.noteid = noteid;
        this.note = note;
        this.timestamp = timestamp;
    }

    public int getNoteid() {
        return noteid;
    }

    public void setNoteid(int noteid) {
        this.noteid = noteid;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    @Override
    public String toString(){
        return "ID:"+this.noteid+" Note:"+this.note+" time:"+this.timestamp;
    }
}
