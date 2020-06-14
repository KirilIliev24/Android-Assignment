package com.example.and_final_project;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.and_final_project.data.model.Note;

import java.util.ArrayList;
import java.util.List;

public class NoteAdaptor extends RecyclerView.Adapter<NoteAdaptor.NoteHolder> {

    private List<Note> notes = new ArrayList<>();
    @NonNull
    @Override
    public NoteHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_note, parent, false);
        return new NoteHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull NoteHolder holder, int position) {
        Note current = notes.get(position);
        holder.title.setText(current.getTitle());
        holder.description.setText(current.getDescription());
        holder.priority.setText(String.valueOf(current.getPriority()));
    }



    @Override
    public int getItemCount() {
        //number of notes to be displayed
        return notes.size();
    }

    public void setNotes(List<Note> notes)
    {
        this.notes = notes;
        notifyDataSetChanged();
    }

    public Note getNotePosition(int position)
    {
        return notes.get(position);
    }

    class NoteHolder extends RecyclerView.ViewHolder
    {
        private TextView title;
        private TextView description;
        private TextView priority;

        public NoteHolder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.text_view_title);
            description = itemView.findViewById(R.id.text_view_description);
            priority = itemView.findViewById(R.id.text_view_priority);
        }
    }
}
