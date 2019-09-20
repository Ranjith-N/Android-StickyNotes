package com.example.stickynotes.adapter;


import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.stickynotes.activity.R;
import com.example.stickynotes.bean.Note;

import java.util.ArrayList;
import java.util.List;

/*
 * {@link DessertAdapter} is an {@link ArrayAdapter} that can provide the layout for each list
 * based on a data source, which is a list of {@link Dessert} objects.
 * */
public class NotesAdapter extends ArrayAdapter<Note> {

    private static final String LOG_TAG = NotesAdapter.class.getSimpleName();

    private List<Note> notes;

    public NotesAdapter(Activity context, List<Note> notes) {

        super(context, 0, notes);
        this.notes = notes;
    }

    /**
     * Provides a view for an AdapterView (ListView, GridView, etc.)
     *
     * @param position The position in the list of data that should be displayed in the
     *                 list item view.
     * @param convertView The recycled view to populate.
     * @param parent The parent ViewGroup that is used for inflation.
     * @return The View for the position in the AdapterView.
     */
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Check if the existing view is being reused, otherwise inflate the view
        View listItemView = convertView;
        if(listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }

        // Get the {@link Dessert} object located at this position in the list
        Note currentNote = getItem(position);

        // Find the TextView in the list_item.xml layout with the ID version_name
        TextView noteTextView = (TextView) listItemView.findViewById(R.id.notes);
        // Get the version name from the current Dessert object and
        // set this text on the name TextView
        noteTextView.setText(currentNote.getNote());

        // Find the TextView in the list_item.xml layout with the ID version_number
        TextView timeTextView = (TextView) listItemView.findViewById(R.id.timestamp);
        // Get the version number from the current Dessert object and
        // set this text on the number TextView
        timeTextView.setText(String.valueOf(currentNote.getTimestamp()));
/*
        // Find the ImageView in the list_item.xml layout with the ID list_item_icon
        ImageView iconView = (ImageView) listItemView.findViewById(R.id.list_item_icon);
        // Get the image resource ID from the current Dessert object and
        // set the image to iconView
        iconView.setImageResource(currentDesert.getImageResourceId());*/

        // Return the whole list item layout (containing 2 TextViews and an ImageView)
        // so that it can be shown in the ListView
        return listItemView;
    }

    public void refreshEvents(List<Note> notes) {
        this.notes.clear();
        this.notes.addAll(notes);
        notifyDataSetChanged();
    }
}