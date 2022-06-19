package com.example.mainpage;

import androidx.cardview.widget.CardView;

import com.example.mainpage.Models.Notes;

public interface NotesClickListener {
    void onClick (Notes notes);
    void onLongClick (Notes notes, CardView cardView);
}
