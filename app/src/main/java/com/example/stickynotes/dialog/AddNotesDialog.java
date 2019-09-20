package com.example.stickynotes.dialog;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.stickynotes.activity.R;
import com.example.stickynotes.bean.Note;
import com.example.stickynotes.dao.Appdatabase;
import com.example.stickynotes.util.DataUtil;

import java.util.Date;
import java.util.Random;

import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.DialogFragment;

public class AddNotesDialog extends DialogFragment {

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        // Get the layout inflater
        LayoutInflater inflater = requireActivity().getLayoutInflater();

        // Inflate and set the layout for the dialog
        // Pass null as the parent view because its going in the dialog layout
        final View dialogView = inflater.inflate(R.layout.add_dialog, null);
        builder.setView(dialogView)
                // Add action buttons
                .setPositiveButton(R.string.title_add, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int id) {
                        // sign in the user ..
                        EditText view = (EditText) dialogView.findViewById(R.id.notes);
                        DataUtil.insertNote(view.getText().toString(), getContext());

                        Toast.makeText(getContext(), "Notes Added sucessfully", Toast.LENGTH_LONG)
                                .show();
                    }
                })
                .setNegativeButton(R.string.dialog_cancel, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        AddNotesDialog.this.getDialog().cancel();
                    }
                });
        return builder.create();
    }



    private int generateId() {
        Random randomGenerator = new Random();
        int randomInt = randomGenerator.nextInt(50) + 1;
        System.out.println("Random number generated is : " + randomInt);
        return randomInt;
    }
}
