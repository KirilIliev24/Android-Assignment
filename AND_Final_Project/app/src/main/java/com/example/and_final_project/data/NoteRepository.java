package com.example.and_final_project.data;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import com.example.and_final_project.data.model.Note;

import java.util.List;

public class NoteRepository {
    private NoteDAO noteDAO;
    private LiveData<List<Note>> allNotes;



    public NoteRepository(Application application)
    {
        DataBase db = DataBase.getInstance(application);
        noteDAO = db.noteDAO();
        allNotes = noteDAO.getAllNotes();

    }

    public void insert(Note note)
    {
        new InsertNoteAsync(noteDAO).execute(note);
    }

    public void update(Note note)
    {
        new UpdateNoteAsync(noteDAO).execute(note);
    }

    public void delete(Note note)
    {
        new DeleteNoteAsync(noteDAO).execute(note);
    }

    public void deleteAllNotes()
    {
        new DeleteAllNotesAsync(noteDAO).execute();
    }

    public LiveData<List<Note>> getAllNotes()
    {
        return allNotes;
    }



    private static class InsertNoteAsync extends AsyncTask<Note, Void, Void>
    {
        private NoteDAO noteDAO;
        private InsertNoteAsync(NoteDAO noteDAO)
        {
            this.noteDAO = noteDAO;
        }
        @Override
        protected Void doInBackground(Note... notes) {
            noteDAO.insert(notes[0]);
            return null;
        }
    }

    private static class UpdateNoteAsync extends AsyncTask<Note, Void, Void>
    {
        private NoteDAO noteDAO;
        private UpdateNoteAsync(NoteDAO noteDAO)
        {
            this.noteDAO = noteDAO;
        }
        @Override
        protected Void doInBackground(Note... notes) {
            noteDAO.update(notes[0]);
            return null;
        }
    }

    private static class DeleteNoteAsync extends AsyncTask<Note, Void, Void>
    {
        private NoteDAO noteDAO;
        private DeleteNoteAsync(NoteDAO noteDAO)
        {
            this.noteDAO = noteDAO;
        }
        @Override
        protected Void doInBackground(Note... notes) {
            noteDAO.delete(notes[0]);
            return null;
        }
    }

    private static class DeleteAllNotesAsync extends AsyncTask<Void, Void, Void>
    {
        private NoteDAO noteDAO;
        private DeleteAllNotesAsync(NoteDAO noteDAO)
        {
            this.noteDAO = noteDAO;
        }
        @Override
        protected Void doInBackground(Void... voids) {
            noteDAO.deleteAllNotes();
            return null;
        }
    }
}
